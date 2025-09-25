package models;

import java.time.LocalDateTime;

public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private PaymentStatus status;
    private LocalDateTime timestamp;

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = PaymentStatus.PENDING;
        this.timestamp = LocalDateTime.now();
    }

    public boolean processPayment() {
        // Simulate payment processing
        try {
            Thread.sleep(1000); // Simulate processing time
            // 90% success rate for demo
            if (Math.random() > 0.1) {
                status = PaymentStatus.SUCCESS;
                return true;
            } else {
                status = PaymentStatus.FAILED;
                return false;
            }
        } catch (InterruptedException e) {
            status = PaymentStatus.FAILED;
            return false;
        }
    }

    // Getters
    public String getPaymentId() { return paymentId; }
    public PaymentStatus getStatus() { return status; }
    public double getAmount() { return amount; }
}
