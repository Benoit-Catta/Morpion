package modele;

public class Joueur {
    private String nom;
    private String symbole;

    public Joueur(String nom,String symbole){
        this.nom = nom;
        this.symbole = symbole;
    }

    public String getNom(){
        return this.nom;
    }

    public String getSymbole(){
        return this.symbole;
    }
}
