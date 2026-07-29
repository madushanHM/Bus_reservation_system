public class Payment {
    // Private attributes (represented by '-' in UML)
    private int paymentId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    // Constructor
    public Payment(int paymentId, double amount, String paymentMethod, String paymentStatus) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Public methods (represented by '+' in UML)
    public boolean processPayment() {
        // Implement payment processing logic here
        this.paymentStatus = "Completed";
        return true;
    }

    public boolean refund() {
        // Implement refund logic here
        this.paymentStatus = "Refunded";
        return true;
    }
}