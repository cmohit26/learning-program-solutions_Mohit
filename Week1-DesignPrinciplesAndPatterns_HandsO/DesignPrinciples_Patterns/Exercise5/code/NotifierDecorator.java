package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise5.code;

// NotifierDecorator.java
public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;

    public NotifierDecorator(Notifier notifier) {
        this.wrappee = notifier;
    }

    @Override
    public void send(String message) {
        wrappee.send(message); // delegate
    }
}
