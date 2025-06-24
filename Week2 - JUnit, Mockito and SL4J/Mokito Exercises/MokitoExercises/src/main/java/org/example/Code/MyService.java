package org.example.Code;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void sendWelcomeMessage(String userId) {
        api.sendMessage(userId, "Hello");
    }

    public void handleProcessing(){
        api.process(42, "Important Data");
    }

    public void doSomethingImportant(){
        // No return, just logs something
        api.logEvent("Something important happened");
    }

    public String[] getTwoItems() {
        String first = api.getNextItem();
        String second = api.getNextItem();
        return new String[] { first, second };
    }

    public void performOperation() {
        api.connect();
        api.send("Data payload");
        api.disconnect();
    }

    public void delete(String id) {
        try {
            api.deleteData(id);
        } catch (RuntimeException e) {
            System.out.println("Deletion failed: " + e.getMessage());
        }
    }
}
