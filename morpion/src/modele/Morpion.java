package modele;

public class Morpion {

    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur courant;
    private Case plateau[][];
    private int tour;

    public Morpion(Joueur un,Joueur deux){
        this.joueur1 = un;
        this.joueur2 = deux;
        this.courant = joueur1;
        this.plateau = new Case[3][3];
        this.tour = 0;

        for (int i = 0 ; i < 3; i++ ){
            for (int c = 0 ; c < 3; c++ ){
                this.plateau[i][c] = new Case();
            }
        }
    }

    public void changerJoueurCourant(){
        if (joueur1.equals(courant)){
            courant = joueur2;
        }else{
            courant = joueur1;
        }
    }

    public void clic(int x,int y){
        plateau[x][y].clicker(courant);
        this.tour++;
    }

    public String getEtatCasePlateau(int x, int y){
        return plateau[x][y].getEtat();
    }

    public boolean gagner(){
        for (int i = 0 ; i < 3; i++ ){
            if (plateau[i][0].getEtat().equals(plateau[i][1].getEtat()) && plateau[i][1].getEtat().equals(plateau[i][2].getEtat()) && !plateau[i][2].getEtat().equals("")){
                return true;
            }
        }
        for (int i = 0 ; i < 3; i++ ){
            if (plateau[0][i].getEtat().equals(plateau[1][i].getEtat()) && plateau[1][i].getEtat().equals(plateau[2][i].getEtat()) && !plateau[1][i].getEtat().equals("")){
                return true;
            }
        }
        if (plateau[0][0].getEtat().equals(plateau[1][1].getEtat()) && plateau[1][1].getEtat().equals(plateau[2][2].getEtat()) && !plateau[1][1].getEtat().equals("")){
            return true;
        }
        if (plateau[0][2].getEtat().equals(plateau[1][1].getEtat()) && plateau[1][1].getEtat().equals(plateau[2][0].getEtat()) && !plateau[1][1].getEtat().equals("")){
            return true;
        }
        return false;
    }

    public void reinitialiser(){
        for (int i = 0 ; i < 3; i++ ){
            for (int c = 0 ; c < 3; c++ ){
                this.plateau[i][c] = new Case();
            }
        }
        this.tour = 0;
    }

    public String getNomCourant(){
        return courant.getNom();
    }

    public boolean getTour(){
        return tour == 9;
    }
}
