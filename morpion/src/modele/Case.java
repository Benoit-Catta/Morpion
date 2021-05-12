package modele;

public class Case {
    private String etat;

    public Case(){
        this.etat = "";
    }

    public void clicker(Joueur joueur){
        this.etat = joueur.getSymbole();
    }

    public String getEtat(){
        return this.etat;
    }
}
