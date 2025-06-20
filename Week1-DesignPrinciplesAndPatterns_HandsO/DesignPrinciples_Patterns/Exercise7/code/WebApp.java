package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise7.code;

// File: WebApp.java
public class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockPrice) {
        System.out.println(appName + " WebApp received stock price update: " + stockPrice);
    }
}
