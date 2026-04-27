package payment;

public class PaymentService {

    public static boolean processPayment(double amount) {
        System.out.println("Payment of ₹" + amount + " successful!");
        return true;
    }
}
