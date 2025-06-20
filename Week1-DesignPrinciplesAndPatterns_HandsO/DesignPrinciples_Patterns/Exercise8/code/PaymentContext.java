package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise8.code;

// PaymentContext.java
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(int amount) {
        if(paymentStrategy == null) {
            System.out.println("Payment strategy not set.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

