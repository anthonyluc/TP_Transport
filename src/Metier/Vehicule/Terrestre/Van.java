package Metier.Vehicule.Terrestre;

import Metier.Vehicule.Vehicule;

public class Van extends Terrestre {
    public Van(){
        this.setNbMaxPersonne(8);
    }

    @Override public String toString(){
        return "Van :" +
                "\nRéférence : " + getIdReference() +
                "\nType : " + getType() +
                "\nNb max personnes : " + getNbMaxPersonne();
    }
}
