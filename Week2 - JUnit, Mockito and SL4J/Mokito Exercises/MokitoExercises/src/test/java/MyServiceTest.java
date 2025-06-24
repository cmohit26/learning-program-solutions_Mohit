import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.example.Code.ExternalApi;
import org.example.Code.MyService;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MyServiceTest {

    ExternalApi mockApi = Mockito.mock(ExternalApi.class);
    MyService service = new MyService(mockApi);

    // Create an InOrder verifier
    InOrder inOrder = inOrder(mockApi);

    //Exercise 1
    @Test
    public void testExternalApi() {
        String result = service.fetchData();
        when(mockApi.getData()).thenReturn("Mock Data");
        assertEquals("Mock Data", result);
    }

    //Exercise 2
    @Test
    public void testVerifyInteraction() {
        service.fetchData();
        verify(mockApi).getData();
    }

    //Exercise 3
    @Test
    public void testArgumentMatching() {
        service.sendWelcomeMessage("user123");
        verify(mockApi).sendMessage(eq("user123"), eq("Hello"));

        // exactly 42 || any string (could be anything)
        service.handleProcessing();
        verify(mockApi).process(eq(42), anyString());
    }

    //Exercise 4
    @Test
    public void testVoidMethod(){
        service.doSomethingImportant();
        verify(mockApi).logEvent(eq("Logged Something Important"));
    }

    //Exercise 5
    @Test
    public void testMultipleReturns() {
        // Stub method to return "First" on first call and "Second" on second call
        when(mockApi.getNextItem()).thenReturn("First", "Second");

        String[] items = service.getTwoItems();

        // Verify both values were returned to the right order
        assertEquals("First", items[0]);
        assertEquals("Second", items[1]);
    }

    //Exercise 6
    @Test
    public void testInteractionOrder() {
        service.performOperation();
        // Verify methods were called in this exact sequence
        inOrder.verify(mockApi).connect();
        inOrder.verify(mockApi).send("Data payload");
        inOrder.verify(mockApi).disconnect();
    }

    //Exercise 7
    @Test
    public void testVoidMethodThrowsException() {
        // Stub the void method to throw an exception
        doThrow(new RuntimeException("Deletion error")).when(mockApi).deleteData("123");
        service.delete("123");

        // Verify the method was still called
        verify(mockApi).deleteData("123");
    }

}