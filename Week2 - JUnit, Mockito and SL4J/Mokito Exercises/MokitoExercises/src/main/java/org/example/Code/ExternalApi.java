package org.example.Code;

public interface ExternalApi {
    String getData();
    void sendMessage(String userId, String message);
    void process(int id, String data);
    void logEvent(String string);
    String getNextItem();

    void connect();
    void send(String message);
    void disconnect();

    void deleteData(String id);
}
