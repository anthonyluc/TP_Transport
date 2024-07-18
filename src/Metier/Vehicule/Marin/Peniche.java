package Metier.Vehicule.Marin;

public class Peniche extends Marin{
    private boolean repas;

    public Peniche(){
        this.repas = false;
    }

    public boolean getRepas(){
        return repas;
    }

    public void setRepas(boolean repas){
        this.repas = repas;
    }

    @Override public String toString(){
        return "Peniche "+
                "\nRéférence : "+ getIdReference() +
                "\nType : " + getType() +
                "\nNb max personnes : " + getNbMaxPersonne() +
                "\nRepas autorisé : "+ getRepas();
    }
}
