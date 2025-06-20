package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise5.code;

// NotificationTest.java
public class Main {
    public static void main(String[] args) {
        // Base notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorated with SMS
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorated with Slack as well
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Final decorated notifier sends via Email + SMS + Slack
        slackNotifier.send("System alert: High CPU usage detected!");
    }
}
