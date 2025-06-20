package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise11.code;

// DependencyInjectionExample.java

interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // For demonstration, just return a dummy customer string
        return "Customer#" + id + " [Name: John Doe]";
    }
}

class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerDetails(int id) {
        return customerRepository.findCustomerById(id);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create concrete repository instance
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject repository into service via constructor
        CustomerService service = new CustomerService(repository);

        // Use the service to find a customer
        String customer = service.getCustomerDetails(1);
        System.out.println(customer);
    }
}
