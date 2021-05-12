package vue;

import controleur.BoutonControleur;
import modele.Case;
import modele.Joueur;
import modele.Morpion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    Morpion morpion;
    JLabel aQuiDeJouer;

    public Fenetre(Morpion morpion){
        super("Morpion");

        this.morpion = morpion;



        JPanel jeu = new JPanel(new GridLayout(3,3));

        BoutonControleur action = new BoutonControleur(morpion,this);
        for (int i = 0 ; i < 3; i++ ){
            for (int c = 0 ; c < 3; c++ ){
                Bouton btn = new Bouton(i,c,morpion);
                jeu.add(btn);
                btn.addActionListener(action);
            }
        }

        JPanel principal = new JPanel(new BorderLayout());
        principal.add(jeu,BorderLayout.CENTER);

        aQuiDeJouer = new JLabel("A " + morpion.getNomCourant() + " de jouer<");
        principal.add(aQuiDeJouer,BorderLayout.SOUTH);

        this.add(principal);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);

    }

    public void setAQuiDeJouer(String nomJoueur){
        aQuiDeJouer.setText("A " + nomJoueur + " de jouer");
    }

    public void reinitialiserFenetre(Morpion morpion, Fenetre fenetre){
        fenetre.dispose();
        fenetre = new Fenetre(morpion);
    }

}
