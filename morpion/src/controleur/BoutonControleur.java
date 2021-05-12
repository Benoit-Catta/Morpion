package controleur;

import modele.Morpion;
import vue.Bouton;
import vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonControleur implements ActionListener {

    private Morpion morpion;
    private Fenetre fenetre;

    public BoutonControleur(Morpion morpion,Fenetre fenetre){
        this.morpion = morpion;
        this.fenetre = fenetre;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Bouton bouton = (Bouton) e.getSource();
        morpion.clic(bouton.getX2(),bouton.getY2());
        bouton.setText(morpion.getEtatCasePlateau(bouton.getX2(),bouton.getY2()));
        bouton.setEnabled(false);
        if (!morpion.gagner()){
            if (morpion.getTour()){
                JOptionPane.showMessageDialog(null,"égalité");
                morpion.reinitialiser();
                fenetre.reinitialiserFenetre(morpion,fenetre);
            } else {
                morpion.changerJoueurCourant();
                fenetre.setAQuiDeJouer(morpion.getNomCourant());
            }
        }else{
            JOptionPane.showMessageDialog(null, morpion.getNomCourant() + " à gangé");
            morpion.reinitialiser();
            fenetre.reinitialiserFenetre(morpion,fenetre);
        }
    }
}
