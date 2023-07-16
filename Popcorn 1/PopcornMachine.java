class OutputBin {
    private int contents;
    private boolean available = false;

    public synchronized int get() {
        while (available == false) {
            try { wait();} 
            catch (InterruptedException e) {}
        }
        available = false;
        notifyAll();
        return contents;
    }

        public synchronized void put(int value) {
        while (available == true) {
            try { wait();} 
            catch (InterruptedException e) {}
        }
        contents = value;
        available = true;
        notifyAll();
    }
}

class PopcornMaker extends Thread {
    private OutputBin bin;

    public PopcornMaker(OutputBin bin) {
        this.bin = bin;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            bin.put(i);
            System.out.println("PopcornMaker: " + i);
            try { sleep((int) (Math.random() * 100));} 
            catch (InterruptedException e) {}
        }
    }
}

class Robotarm extends Thread {
    private OutputBin bin;

    public Robotarm(OutputBin bin) {
        this.bin = bin;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = bin.get();
            System.out.println("robotarm: " + value);
            try { sleep((int) (Math.random() * 100));} 
            catch (InterruptedException e) {}
        }
    }
}

class PopcornMachine {
    public static void main(String[] args) {
        OutputBin bin = new OutputBin();
        PopcornMaker p = new PopcornMaker(bin);
        Robotarm r = new Robotarm(bin);
        p.start();
        r.start();
    }
}

