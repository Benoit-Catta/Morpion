import modele.Joueur;
import modele.Morpion;
import vue.Fenetre;

public class Application {
    public static void main(String[] args) {
        Morpion morpion = new Morpion(new Joueur("Ben","X"),new Joueur("Bot","O"));
        Fenetre fenetre = new Fenetre(morpion);
        fenetre.setAQuiDeJouer(morpion.getNomCourant());
    }
}
