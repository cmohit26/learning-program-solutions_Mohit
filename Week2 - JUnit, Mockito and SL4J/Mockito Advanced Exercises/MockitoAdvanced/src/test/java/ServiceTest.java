// ServiceTest.java
import static org.mockito.Mockito.*;

import org.example.Code.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    Repository mockRepository = mock(Repository.class);
    Service service = new Service(mockRepository);

    //Exercise 1
    @Test
    public void testServiceWithMockRepository() {
        // 2. Stub the repository method
        when(mockRepository.getData()).thenReturn("Mock Data");

        // 3. Inject mock into service and test logic
        String result = service.processData();

        // 4. Verify result
        assertEquals("Processed Mock Data", result);
    }

    //Exercise 2
    @Test
    public void testServiceWithMockRestClient() {
        // 1. Create mock REST client
        RestClient mockRestClient = mock(RestClient.class);

        // 2. Stub the REST client's method
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // 3. Inject mock into the service
        ApiService apiService = new ApiService(mockRestClient);

        // 4. Verify the logic
        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);
    }

    //Exercise 3
    @Test
    public void testServiceWithMockFileIO() {
        // 1. Create mocks
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // 2. Stub the read method
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // 3. Inject mocks into service
        FileService fileService = new FileService(mockFileReader, mockFileWriter);

        // 4. Execute and assert
        String result = fileService.processFile();
        assertEquals("Processed Mock File Content", result);

        // 5. Verify that write was called with the correct content
        verify(mockFileWriter).write("Processed Mock File Content");
    }

    // Example 4
    @Test
    public void testServiceWithMockNetworkClient() {
        // 1. Create mock network client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // 2. Stub the connect method
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // 3. Inject mock into service
        NetworkService networkService = new NetworkService(mockNetworkClient);

        // 4. Execute and verify result
        String result = networkService.connectToServer();
        assertEquals("Connected to Mock Connection", result);

        // 5. Optionally verify that connect() was called exactly once
        verify(mockNetworkClient, times(1)).connect();
    }

    //Example 5 
    @Test
    public void testServiceWithMultipleReturnValues() {
        // 1. Create mock object
        Repository mockRepository = mock(Repository.class);

        // 2. Stub to return different values on consecutive calls
        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        // 3. Use mocked repository
        Service service = new Service(mockRepository);

        // 4. Call method twice
        String firstResult = service.processData();
        String secondResult = service.processData();

        // 5. Assert both results
        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);
    }

}
