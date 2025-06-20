package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise7.code;

// File: MobileApp.java
public class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockPrice) {
        System.out.println(appName + " MobileApp received stock price update: " + stockPrice);
    }
}
