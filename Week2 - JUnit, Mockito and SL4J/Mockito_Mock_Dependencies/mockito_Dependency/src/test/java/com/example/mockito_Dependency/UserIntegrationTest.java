package com.example.mockito_Dependency;

import static org.junit.jupiter.api.Assertions.*;

import com.example.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class UserIntegrationTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testGetUser_Success() {
        // Prepare test data
        User user = new User(100L, "Integration User");
        userRepository.save(user);

        ResponseEntity<User> response = userController.getUser(100L);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(user.getId(), response.getBody().getId());
        assertEquals(user.getName(), response.getBody().getName());

        // Clean up
        userRepository.deleteById(100L);
    }

    @Test
    void testGetUser_NotFound() {
        ResponseEntity<User> response = userController.getUser(9999L);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}

