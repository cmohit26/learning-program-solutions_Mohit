package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise8.code;

// Main.java (test class)
public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay with Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234567890123456", "John Doe", "123", "12/25"));
        context.executePayment(100);

        // Pay with PayPal
        context.setPaymentStrategy(new PayPalPayment("john@example.com", "password123"));
        context.executePayment(200);
    }
}
