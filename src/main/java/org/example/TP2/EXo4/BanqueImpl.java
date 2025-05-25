package org.example.TP2.EXo4;

public class BanqueImpl implements Banque {
    private int solde;
    private int minimum;

    public BanqueImpl(int soldeInitial, int seuilMin) {
        this.solde = soldeInitial;
        this.minimum = seuilMin;
    }

    public void crediter(int somme) {
        solde += somme;
    }

    public void debiter(int somme) {
        solde -= somme;
    }

    public boolean est_solvable() {
        return solde >= minimum;
    }
}

