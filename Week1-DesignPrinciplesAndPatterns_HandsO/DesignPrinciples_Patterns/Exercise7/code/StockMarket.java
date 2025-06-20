package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise7.code;

// File: StockMarket.java
import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockPrice;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    // Method to update stock price and notify observers
    public void setStockPrice(String price) {
        this.stockPrice = price;
        notifyObservers();
    }
}
