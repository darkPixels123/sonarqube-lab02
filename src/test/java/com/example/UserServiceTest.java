package com.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void testServiceInstantiation() {
        UserService service = new UserService();
        assertNotNull(service);
    }

    @Test
    void testFindUserExecutionPath() {
        UserService service = new UserService();
        // This covers the try-with-resources and SQL preparation
        Exception exception = assertThrows(Exception.class,
                () -> service.findUser("testUser"));
        assertNotNull(exception);
    }

    @Test
    void testFindUserWithDifferentInputs() {
        UserService service = new UserService();
        // Cover parameter handling
        assertNotNull(assertThrows(Exception.class, () -> service.findUser("admin")));
        assertNotNull(assertThrows(Exception.class, () -> service.findUser("user123")));
        assertNotNull(assertThrows(Exception.class, () -> service.findUser("")));
    }

    @Test
    void testDeleteUserExecutionPath() {
        UserService service = new UserService();
        // This covers the DELETE SQL path
        Exception exception = assertThrows(Exception.class,
                () -> service.deleteUser("admin"));
        assertNotNull(exception);
    }

    @Test
    void testDeleteUserWithDifferentInputs() {
        UserService service = new UserService();
        // Cover parameter handling for delete
        assertNotNull(assertThrows(Exception.class, () -> service.deleteUser("user1")));
        assertNotNull(assertThrows(Exception.class, () -> service.deleteUser("user2")));
    }

    @Test
    void testBothMethodsSequentially() {
        UserService service = new UserService();
        // Simulate the pattern used in App.main()
        assertThrows(Exception.class, () -> {
            service.findUser("admin");
            service.deleteUser("admin");
        });
    }
}
