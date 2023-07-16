class BankLoan{
    private double amount;
    private double interestRate;
    private double duration;
    private String paymentMethod;

    public BankLoan(double amount, double interestRate, double duration, String paymentMethod) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.duration = duration;
        this.paymentMethod = paymentMethod;
    }
}