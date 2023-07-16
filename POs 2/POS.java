import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

class GloceryItem implements Serializable {
    private String item_code;
    private float price;
    private float weight;
    private String m_date;
    private String e_date;
    private String manufacture_name;
    private float discount;
    private int qty;

    public GloceryItem() { 
    }

    public GloceryItem(String item_code, int price, float weight, String m_date, String e_date,
            String manufacture_name) {
        this.item_code = item_code;
        this.price = price;
        this.weight = weight;
        this.m_date = m_date;
        this.e_date = e_date;
        this.manufacture_name = manufacture_name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getM_date() {
        return m_date;
    }

    public void setM_date(String m_date) {
        this.m_date = m_date;
    }

    public String getE_date() {
        return e_date;
    }

    public void setE_date(String e_date) {
        this.e_date = e_date;
    }

    public String getManufacture_name() {
        return manufacture_name;
    }

    public void setManufacture_name(String manufacture_name) {
        this.manufacture_name = manufacture_name;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}

class Bill implements Serializable {
    private String cashier_name;
    private String branch;
    private String customer_name;
    private Queue<GloceryItem> items;
    private float tot_discount;
    private float tot_price;
    private float net_price;
    private LocalDate date;
    private LocalTime time;

    public Bill(String cashier_name, String branch) {
        this.cashier_name = cashier_name;
        this.branch = branch;
        date = java.time.LocalDate.now();
        time = java.time.LocalTime.now();
        items = new LinkedList<>();
        tot_price = 0;
        net_price = 0;
        tot_discount = 0;

    }

    public void setTime() {
        time = java.time.LocalTime.now();
    }

    public void setDate() {
        date = java.time.LocalDate.now();
    }

    public String getCashier_name() {
        return cashier_name;
    }

    public String getBranch() {
        return branch;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Queue<GloceryItem> getItems() {
        return items;
    }

    public void setItems(GloceryItem item) {
        items.add(item);
        float price = item.getPrice() * item.getQty();
        float new_price = price * (100 - item.getDiscount()) / 100;
        setNetPrice(price);
        setTot_price(new_price);
    }

    public float getTot_discount() {
        this.setTot_discount();
        return tot_discount;
    }

    public void setTot_discount() {
        tot_discount = (1 - (tot_price / net_price)) * 100;
    }

    public float getTot_price() {
        return tot_price;
    }

    public void setTot_price(float price) {
        tot_price += price;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setNetPrice(float price) {
        net_price += price;
    }
}

class ItemCodeNotFound extends Exception {
    public ItemCodeNotFound(String item_code) {
        System.out.println(item_code + " is Invalid Item Code!");
    }
}

class HoldException extends Exception {
    public HoldException() {
        System.out.println("Bill is being hold !");
    }
}

public class POS {

    private static GloceryItem[] items;

    public GloceryItem getItemDetails() throws HoldException {
        String item_code = null;
        GloceryItem item = null;

        try {
            System.out.print("Enter item codes (press -1 if finished, to hold press -2 ) : ");
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            item_code = br.readLine();
            if (Integer.parseInt(item_code) == -1) {
                return null;
            }
            if (Integer.parseInt(item_code) == -2) {
                throw new HoldException();
            }
            for (GloceryItem it : items) {
                if (Integer.parseInt(item_code) == Integer.parseInt(it.getItem_code())) {
                    item = it;
                }
            }
            if (item == null) {
                throw new ItemCodeNotFound(item_code);
            } else {
                System.out.print("Enter Quantity : ");
                int Qty = Integer.parseInt(br.readLine());
                item.setQty(Qty);
            }
        } catch (ItemCodeNotFound ex) {
            return getItemDetails();
        } catch (IOException ex) {
        } catch (NumberFormatException ex) {
            System.out.println("Does not match The types !");
            return getItemDetails();
        }
        return item;
    }

    public static void main(String[] args) {
        GloceryItem it1 = new GloceryItem("1000", 1000, 1000, "2002", "2020", "Kamal");
        GloceryItem it2 = new GloceryItem("1001", 1000, 1000, "2002", "2020", "Kamal");
        GloceryItem it3 = new GloceryItem("1002", 1000, 1000, "2002", "2020", "Kamal");
        GloceryItem it4 = new GloceryItem("1003", 1000, 1000, "2002", "2020", "Kamal");

        items = new GloceryItem[4];
        items[0] = it1;
        items[1] = it2;
        items[2] = it3;
        items[3] = it4;
        Scanner scan = new Scanner(System.in);

        System.out.println("\t \t Welcome !");
        String branch, cashier_name;
        System.out.print("Enter the Branch : ");
        branch = scan.nextLine();
        System.out.print("Enter the name of Cashier : ");
        cashier_name = scan.nextLine();

        try {
            int command = 0;
            String customer_name;
            while (command != -4) {
                System.out.print("Load before Holded bill press -3  otherwise press 0 : ");
                command = scan.nextInt();
                Bill bill = new Bill(cashier_name, branch);
                if (command == -3) {
                    try {
                        FileInputStream fileStream = new FileInputStream("bill.sev");
                        ObjectInputStream ob = new ObjectInputStream(fileStream);

                        Object obj = ob.readObject();
                        bill = (Bill) obj;
                        ob.close();
                        fileStream.close();
                    } catch (ClassCastException ex) {
                        System.out.println("No Holded Bill !");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Bill is not found !");
                    }
                }

                System.out.print("Enter the name of Customer : ");
                customer_name = scan.next();
                bill.setCustomer_name(customer_name);
                try {
                    while (true) {
                        GloceryItem item = new POS().getItemDetails();
                        if (item == null) {
                            break;
                        }
                        bill.setItems(item);
                    }

                    System.out.println("\n\n");
                    System.out.println("Branch \t\t: " + bill.getBranch());
                    System.out.println("Cashier \t: " + bill.getCashier_name());

                    bill.setDate();
                    bill.setTime();

                    System.out.println("Time \t: " + bill.getTime());
                    System.out.println("Date \t: " + bill.getDate());

                    Queue<GloceryItem> its = bill.getItems();

                    for (GloceryItem it : its) {
                        System.out.println("Unit Price \t: " + it.getPrice() + '\t');
                        System.out.println("Quantity \t: " + it.getQty() + '\t');
                        System.out.println("Discount \t: " + it.getDiscount() + '\t');
                        System.out.println(
                                "net Price \t: " + it.getQty() * it.getPrice() * ((100 - it.getDiscount()) / 100)
                                        + '\t');
                        System.out.println('\n');
                    }

                    System.out.println("Total Discount \t\t: " + bill.getTot_discount());
                    System.out.println("Total Price \t\t: " + bill.getTot_price());

                } catch (HoldException ex) {
                    FileOutputStream fileStream = new FileOutputStream("bill.sev");
                    ObjectOutputStream ob = new ObjectOutputStream(fileStream);

                    ob.writeObject(bill);
                    ob.close();
                    fileStream.close();
                } finally {
                    System.out.print("\nTo Exit Press (-4) ohterwise (any): ");
                    command = scan.nextInt();
                }
            }

        } catch (IOException ex) {
            System.out.println("There are not a file with given name !");
        } catch (NumberFormatException ex) {
            System.out.println("The entered value is not in the type !");
        }
    }
}