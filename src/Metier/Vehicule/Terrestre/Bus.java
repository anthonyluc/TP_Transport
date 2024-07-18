package Metier.Vehicule.Terrestre;

public class Bus extends Terrestre{
    private int hauteur;
    private int longueur;

    public Bus(){
        this.setHauteur(0);
        this.setLongueur(0);
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    @Override public String toString(){
        return "Bus :" +
                "\nRéférence : " + getIdReference() +
                "\nType : " + getType() +
                "\nHauteur : " + getHauteur() +
                "\nLongueur : " + getLongueur() +
                "\nNb max personnes : " + getNbMaxPersonne();
    }
}
