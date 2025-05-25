package org.example.TP2.EXo4;

public interface Banque {
    void crediter(int somme);           // La banque reçoit une mise du joueur
    void debiter(int somme);            // La banque paie le gain au joueur
    boolean est_solvable();             // Indique si la banque est encore solvable
}

