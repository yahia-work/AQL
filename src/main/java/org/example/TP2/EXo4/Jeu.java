package org.example.TP2.EXo4;

public class Jeu {
    private Banque banque;
    private boolean ouvert;

    public Jeu(Banque banque) {
        this.banque = banque;
        this.ouvert = true;
    }

    public void fermer() {
        this.ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException, DebitImpossibleException {
        if (!ouvert) throw new JeuFermeException("Jeu fermé");

        int mise = joueur.mise();
        joueur.debiter(mise);
        banque.crediter(mise);

        int resultat = de1.lancer() + de2.lancer();
        if (resultat == 7) {
            int gain = 2 * mise;
            banque.debiter(gain);
            joueur.crediter(gain);
            if (!banque.est_solvable()) {
                this.fermer();
            }
        }
    }
}
