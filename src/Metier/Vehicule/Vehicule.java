package Metier.Vehicule;

public class Vehicule{

    protected String idReference;
    protected String type;
    protected int nbMaxPersonne;

    public String getIdReference() {
        return idReference;
    }

    public void setIdReference(String idReference) {
        this.idReference = idReference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbMaxPersonne() {
        return nbMaxPersonne;
    }

    public void setNbMaxPersonne(int nbMaxPersonne) {
        this.nbMaxPersonne = nbMaxPersonne;
    }
}
