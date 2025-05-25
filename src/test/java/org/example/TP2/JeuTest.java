package org.example.TP2;

import org.example.TP2.EXo4.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JeuTest {

    @Mock
    Banque banque;
    @Mock
    Joueur joueur;
    @Mock
    De de1;
    @Mock
    De de2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Scénario 1 : Jeu fermé
    @Test
    public void testJeuFerme() {
        Jeu jeu = new Jeu(banque);
        jeu.fermer();
        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueur, de1, de2));
    }

    // Scénario 2 : Joueur insolvable
    @Test
    public void testJoueurInsolvable() throws DebitImpossibleException {
        Jeu jeu = new Jeu(banque);

        when(joueur.mise()).thenReturn(50);
        doThrow(new DebitImpossibleException("Fonds insuffisants")).when(joueur).debiter(50);

        assertThrows(DebitImpossibleException.class, () -> jeu.jouer(joueur, de1, de2));

        verify(joueur).debiter(50);
        verify(de1, never()).lancer();
        verify(de2, never()).lancer();
    }

    // Scénario 3 : Perte
    @Test
    public void testPerte() throws Exception {
        Jeu jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(10);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(2); // Somme ≠ 7

        jeu.jouer(joueur, de1, de2);

        verify(joueur).debiter(10);
        verify(banque).crediter(10);
        verify(joueur, never()).crediter(anyInt());
    }

    // Scénario 4 : Gain, banque solvable
    @Test
    public void testGainEtBanqueSolvable() throws Exception {
        Jeu jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(20);
        when(de1.lancer()).thenReturn(4);
        when(de2.lancer()).thenReturn(3); // Somme = 7
        when(banque.est_solvable()).thenReturn(true);

        jeu.jouer(joueur, de1, de2);

        verify(banque).crediter(20);
        verify(banque).debiter(40);
        verify(joueur).crediter(40);
        assertTrue(jeu.estOuvert());
    }

    // Scénario 5 : Gain, banque insolvable
    @Test
    public void testGainEtBanqueInsolvable() throws Exception {
        Jeu jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(30);
        when(de1.lancer()).thenReturn(2);
        when(de2.lancer()).thenReturn(5); // 7
        when(banque.est_solvable()).thenReturn(false);

        jeu.jouer(joueur, de1, de2);

        verify(banque).debiter(60);
        verify(joueur).crediter(60);
        assertFalse(jeu.estOuvert());
    }
}


