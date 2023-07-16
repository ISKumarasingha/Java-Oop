import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public class Shopping {
	public static void main(String[] args) {
		Map<String, GroceryItem> database = new HashMap<>();
		GroceryItem item1 = new GroceryItem("1", "salt", 10, 1110);
		GroceryItem item2 = new GroceryItem("2", "dsds", 2340, 300);
		item1.addNewItems(item1);
		item2.equals(item2);
		database.put("1", item1);
		database.put("2", item2);
		POS P1 = new POS("Sajith", "Galle");
		P1.processSale(database);
	}
}

class POS implements Serializable {
	private String cashierName;
	private String branch;
	private String customerName;
	private ArrayList<GroceryItem> itemList;
	private double totalDiscount;
	private double totalPrice;
	private LocalDateTime dateTime;
	private boolean Do_process = true;
	private boolean correct_code = true;

	public POS(String cashierName, String branch) {
		this.setCashierName(cashierName);
		this.setBranch(branch);
		this.setTotalDiscount(0.0);
		this.setTotalPrice(0.0);
		this.dateTime = LocalDateTime.now();
		this.itemList = new ArrayList<>();
	}

	public String get_customer_name() {
		return this.customerName;
	}

	void processSale(Map<String, GroceryItem> database) {

		System.out.println("Welcome to Super-Saving!");
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Register customer or Not (y or n) ");
			String isRegistered = scanner.nextLine();

			if (isRegistered.equalsIgnoreCase("y")) {
				System.out.print("Please enter your name: ");
				customerName = scanner.nextLine();
			}

			while (Do_process) {
				System.out.print("Enter item code (or 'done' to finish): (or type 'pending' : (or type 'back' to go to previous customer)");
				String itemCode = scanner.next();

				if (itemCode.equalsIgnoreCase("done")) {
					savebill(itemList);
					break;
				} else if (itemCode.equalsIgnoreCase("pending")) {
					System.out.println("Next customer please ");
					try {
						pending_bills(itemList);
						processSale(database);
					} catch (Throwable e) {
						e.printStackTrace();
					}
					break;

				} else if (itemCode.equalsIgnoreCase("back")) {
					System.out.println(" Enter customer name");

				} else {
					GroceryItem item = getItemDetails(itemCode, database);
					while (correct_code) {
						System.out.print("Give the quantity == ");
						int quantity = scanner.nextInt();
						item.setQuantity(quantity);
						double price = quantity * item.getPrice();
						this.setTotalDiscount(this.getTotalDiscount() + quantity * item.getPrice() * (item.getDiscounts()));
						setTotalPrice(this.getTotalPrice() + price - this.getTotalDiscount());
						add(item);
						correct_code = false;
					}
				}
			}
		}
	}

	private void add(GroceryItem item) {
		itemList.add(item);
	}

	public void pending_bills(ArrayList<GroceryItem> itemList) throws Throwable {
		FileOutputStream fileStream = new FileOutputStream(this.customerName);
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
		for (GroceryItem item : itemList) {
			os.writeObject(item);
		}
		os.close();
	}

	public void Getting_previous_customer() {
		System.out.println("Enter customer name");
		try (Scanner scanner = new Scanner(System.in)) {
			String customerName = scanner.nextLine();
			FileInputStream fileStream = new FileInputStream(customerName);
			ObjectInputStream os = new ObjectInputStream(fileStream);
			GroceryItem item = (GroceryItem) os.readObject();
			itemList.add(item);
			os.close();
		} catch (Exception e) {
			System.out.println("Error");
		}

	}

	public void savebill(List<GroceryItem> addItemList) {
		System.out.println("=========================================");
		System.out.println("----------- Super-Saving-----------------");
		System.out.println(" -----------Supermarket ------------------");
		System.out.println("=========================================");
		System.out.println("Cashier name --" + this.cashierName);
		System.out.println("Branch ---" + this.branch);

		if (this.customerName != null) {
			System.out.println("customer name --" + this.customerName);
		}

		for (GroceryItem item : addItemList) {
			System.out.println("Item name = " + item.getItemName() + "   " + "quantity =" + item.getQuantity());
		}

		System.out.println("TOTAL DISCOUNTS =======  " + this.totalDiscount);
		System.out.println("TOTAL PRICE  ======  " + this.totalPrice);

	}

	private GroceryItem getItemDetails(String itemcode, Map<String, GroceryItem> database) {
		if (database.get(itemcode) == null) {
			System.out.println(" itemocode invalid ");
			correct_code = false;
		} else {
			correct_code = true;
		}
		return database.get(itemcode);
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}

	public ArrayList<GroceryItem> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<GroceryItem> itemList) {
		this.itemList = itemList;
	}

}

class GroceryItem implements Serializable {
	private String itemCode;
	private String itemName;
	private double price;
	private double weight;
	private double discounts;
	private int quantity;

	private Map<String, GroceryItem> database = new HashMap<>();

	public GroceryItem(String itemcode, String itemName, double price, double weight) {

		this.itemCode = itemcode;
		this.setItemName(itemName);
		this.setPrice(price);
		this.setWeight(weight);
		this.setDiscounts(0.1);
		this.setQuantity(0);
		database = new HashMap<>();

	}

	public Map<String, GroceryItem> mapTheThings() {
		return database;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void addNewItems(GroceryItem item) {
		database.put(item.getItemCode(), item);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscounts() {
		return discounts;
	}

	public void setDiscounts(double discounts) {
		this.discounts = discounts;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}