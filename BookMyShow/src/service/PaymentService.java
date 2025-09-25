package service;

import models.*;

import  java.util.*;

public class PaymentService {
    private Map<String, Payment> payments;

    public PaymentService() {
        this.payments = new HashMap<>();
    }

    public Payment processPayment(double amount, String paymentMethod) {
        String paymentId = "PAY" + System.currentTimeMillis();
        Payment payment = new Payment(paymentId, amount, paymentMethod);

        System.out.println("Processing payment of $" + amount + " via " + paymentMethod);

        boolean success = payment.processPayment();
        payments.put(paymentId, payment);

        if (success) {
            System.out.println("Payment successful! Payment ID: " + paymentId);
        } else {
            System.out.println("Payment failed! Payment ID: " + paymentId);
        }

        return payment;
    }

    public boolean refundPayment(String paymentId) {
        Payment payment = payments.get(paymentId);
        if (payment != null && payment.getStatus() == PaymentStatus.SUCCESS) {
            System.out.println("Refund processed for payment: " + paymentId);
            return true;
        }
        return false;
    }

    public List<Payment> getPaymentHistory(String userId) {
        // In real implementation, this would filter by user
        return new ArrayList<>(payments.values());
    }

    public boolean validatePayment(String paymentId) {
        Payment payment = payments.get(paymentId);
        return payment != null && payment.getStatus() == PaymentStatus.SUCCESS;
    }
}
