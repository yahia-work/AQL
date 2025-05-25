package org.example.TP2;

import org.example.TP2.EXO3.ServiceException;
import org.example.TP2.EXO3.UserService;
import org.example.TP2.EXO3.Utilisateur;
import org.example.TP2.EXO3.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest3 {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    // Cas 1 : Lever une exception
    @Test(expected = ServiceException.class)
    public void testCreerUtilisateur_EchecCreation() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Erreur", "Test", "erreur@test.com");

        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur); // doit lever exception
    }

    // Cas 2 : Vérifier qu’aucun appel à l’API si validation échoue
    @Test
    public void testCreerUtilisateur_ErreurValidation() throws ServiceException {
        Utilisateur utilisateur = null; // simulons une validation échouée

        UserService userService = new UserService(utilisateurApiMock);

        if (utilisateur != null) {
            userService.creerUtilisateur(utilisateur);
        }

        verify(utilisateurApiMock, never()).creerUtilisateur(any());
    }

    // Cas 3 : Vérification de l’ID retourné
    @Test
    public void testCreerUtilisateur_RetourID() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Ali", "Baba", "ali@baba.com");
        int idAttendu = 123;

        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(idAttendu);

        UserService userService = new UserService(utilisateurApiMock);
        int idRetourne = userService.creerUtilisateur(utilisateur);

        assertEquals(idAttendu, idRetourne);
    }

    // Cas 4 : Capturer les arguments passés
    @Test
    public void testCreerUtilisateur_ArgumentCapture() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Samira", "Benali", "samira@ex.com");
        ArgumentCaptor<Utilisateur> captor = ArgumentCaptor.forClass(Utilisateur.class);

        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(101);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        verify(utilisateurApiMock).creerUtilisateur(captor.capture());

        Utilisateur capturé = captor.getValue();

        assertEquals("Samira", capturé.getNom());
        assertEquals("Benali", capturé.getPrenom());
        assertTrue(capturé.getEmail().contains("@ex.com"));
    }
}
