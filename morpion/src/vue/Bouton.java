package vue;

import modele.Morpion;

import javax.swing.*;

public class Bouton extends JButton {
    private int x;
    private int y;
    Morpion morpion;

    public Bouton(int x,int y,Morpion morpion){
        this.x = x;
        this.y = y;
        this.morpion = morpion;
        this.setText(morpion.getEtatCasePlateau(x,y));

    }


    public int getX2() {
        return x;
    }

    public int getY2() {
        return y;
    }
}
