package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise7.code;

// File: Stock.java
public interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}
