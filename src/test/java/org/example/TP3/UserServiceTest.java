package org.example.TP3;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void testGetUserById() {
        // Arrange
        UserRepository userRepositoryMock = mock(UserRepository.class);
        User expectedUser = new User(1L, "Alice");
        when(userRepositoryMock.findUserById(1L)).thenReturn(expectedUser);

        UserService userService = new UserService(userRepositoryMock);

        // Act
        User user = userService.getUserById(1L);

        // Assert
        assertEquals(expectedUser, user);
        verify(userRepositoryMock).findUserById(1L); // Vérifie l'appel
    }
}

