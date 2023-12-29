package de.htwberlin.user_management_impl;

import de.htwberlin.user_management_api.InvalidNameException;
import de.htwberlin.user_management_api.User;
import de.htwberlin.user_management_api.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl();
    }

    private static Stream<String> validUserNames() {
        return Stream.of("JohnDoe123", "Alice123", "Bob456");
    }

    private static Stream<String> invalidUserNames() {
        return Stream.of(null, "", "John-Doe", "   ");
    }

    @ParameterizedTest
    @MethodSource("validUserNames")
    public void testCreateUserWithValidName(String validName) throws InvalidNameException {
        User user = userService.createUser(validName);
        assertNotNull(user);
        assertEquals(validName, user.getName());
    }

    @ParameterizedTest
    @MethodSource("invalidUserNames")
    public void testCreateUserWithInvalidName(String invalidName) {
        assertThrows(InvalidNameException.class, () -> userService.createUser(invalidName));
    }

}