package org.example.TP2;

import org.example.TP2.EXO2.ServiceException;
import org.example.TP2.EXO2.UserService;
import org.example.TP2.EXO2.Utilisateur;
import org.example.TP2.EXO2.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Arrange
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jean.dupont@example.com");
        UserService userService = new UserService(utilisateurApiMock);

        // Act
        userService.creerUtilisateur(utilisateur);

        // Assert : Vérifie que l'appel a bien eu lieu
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
}
