package org.example.TP2.EXo4;

public interface Joueur {
    int mise();                            // Retourne la mise du joueur (supposée positive)

    void debiter(int somme) throws DebitImpossibleException;  // Débite la mise du joueur
    void crediter(int somme);             // Crédite les gains au joueur
}
