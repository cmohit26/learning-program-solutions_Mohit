package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise7.code;

// File: ObserverPatternTest.java
public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        MobileApp mobileApp1 = new MobileApp("FinanceTracker");
        WebApp webApp1 = new WebApp("StockWatch");

        // Register observers
        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(webApp1);

        // Simulate stock price update
        stockMarket.setStockPrice("$100");

        // Deregister one observer
        stockMarket.deregisterObserver(webApp1);

        // Simulate another stock price update
        stockMarket.setStockPrice("$105");
    }
}
