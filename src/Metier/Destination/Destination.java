package Metier.Destination;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String idReference;
    private String type;
    private String lieuDepart;
    private String lieuDestination;
    private List<String> listeArret;

    public Destination(){
        this.listeArret = new ArrayList<String>();
    }

    public Destination(String idReference, String type, String lieuDepart, String lieuDestination, List<String> listeArret) {
        this.setIdReference(idReference);
        this.setType(type);
        this.setLieuDepart(lieuDepart);
        this.setLieuDestination(lieuDestination);
        this.setListeArret(listeArret);
    }

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

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getLieuDestination() {
        return lieuDestination;
    }

    public void setLieuDestination(String lieuDestination) {
        this.lieuDestination = lieuDestination;
    }

    public List<String> getListeArret() {
        return listeArret;
    }

    public void setListeArret(List<String> listeArret) {
        this.listeArret = listeArret;
    }

    public void ajouterArret(String arret){
        this.listeArret.add(arret);
    }

    public void supprimerArret(String arret){
        this.listeArret.remove(arret);
    }

    @Override public String toString() {
        return "Référence : " + this.getIdReference() +
                "\nType : " + this.getType() +
                "\nLieu de départ : " + this.getLieuDepart() +
                "\nLieu de destination : " + this.getLieuDestination() +
                "\nListe des arrêts : " + this.getListeArret();
    }
}
