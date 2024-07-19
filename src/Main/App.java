package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Metier.Destination.Destination;
import Metier.Vehicule.Marin.Peniche;
import Metier.Vehicule.Terrestre.Bus;
import Metier.Vehicule.Terrestre.Van;
import Metier.Vehicule.Vehicule;

public class App {
    private List<Destination> destinations;
    private List<Vehicule> vehicules;
    private List<Vehicule> vehiculesDisponibles;
    private HashMap<Vehicule, Destination> vehiculesReserves;

    public App(){
        this.destinations = new ArrayList<Destination>();
        this.vehicules = new ArrayList<Vehicule>();
        this.vehiculesDisponibles = new ArrayList<Vehicule>();
        this.vehiculesReserves = new HashMap<Vehicule, Destination>();
        System.out.println("Bienvenue à Transport Excursion App");
        System.out.println();
    }

    public void execution(){
        Boolean continuer;
        do {
            menu();
            continuer = action(inputIntUser());
        }
        while(continuer);
    }

    public void menu(){
        System.out.println("1 - Lister les destinations");
        System.out.println("2 - Lister tous les véhicules");
        System.out.println("3 - Ajouter un véhicule");
        System.out.println("4 - Supprimer un véhicule");
        System.out.println("5 - Ajouter une destination");
        System.out.println("6 - Supprimer une destination");
        System.out.println("7 - Réserver un véhicule");
        System.out.println("8 - Voir les véhicules réservés");
        System.out.println("9 - Voir les véhicules disponibles");
        System.out.println("10 - Rendre un véhicule disponible");
        System.out.println("11 - Afficher les détails d'une destination");
        System.out.println("12 - Quitter le programme");
        System.out.print("Que souhaitez-vous faire : ");
    }

    public boolean action(int choix){
        boolean continuer = true;
        System.out.println();
        switch (choix){
            case 1:
                listerDestinations();
                break;
            case 2:
                listerVehicules();
                break;
            case 3:
                ajouterVehicule();
                break;
            case 4:
                supprimerVehicule();
                break;
            case 5:
                ajouterDestination();
                break;
            case 6:
                supprimerDestination();
                break;
            case 7:
                reserverVehicule();
                break;
            case 8:
                voirVehiculeReserves();
                break;
            case 9:
                voirVehiculeDisponibles();
                break;
            case 10:
                rendreVehiculeDisponible();
                break;
            case 11:
                detailsDestination();
                break;
            case 12:
                continuer = quitterProgram();
                break;
        }
        System.out.println();
        return continuer;
    }

    public int inputIntUser(){
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        int choix = 0;
        try {
            choix = Integer.parseInt(bufferRead.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choix;
    }

    public String inputStringUser(){
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String info = "";
        try {
            info = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void listerDestinations(){
        System.out.println("Voici la liste complète des destinations : ");
        int index = 1;
        for(int i=0; i<destinations.size(); i++){
            System.out.println(index + ") " + destinations.get(i).getLieuDepart() +" - "+ destinations.get(i).getLieuDestination());
            ++index;
        }
        System.out.println("-- Fin de la liste --");
    }

    public void listerVehicules(){
        System.out.println("Voici la liste de tous vos véhicules : ");
        int index = 1;
        for(int i=0; i<vehicules.size(); i++){
            System.out.println(index + ") " +vehicules.get(i));
            System.out.println();
            ++index;
        }
        System.out.println("-- Fin de la liste --");
    }

    public void voirVehiculeReserves(){
        System.out.println("Voici la liste de tous les véhicules réservés: ");

        int index = 1;
        for (Map.Entry<Vehicule, Destination> vehiculeDestination : vehiculesReserves.entrySet()) {
            System.out.println(index+") "+
                    vehiculeDestination.getKey()+
                    "\n\nPour\n\n" +
                    vehiculeDestination.getValue()
            );
            ++index;
        }

        System.out.println("-- Fin de la liste --");
    }

    public void voirVehiculeDisponibles(){
        System.out.println("Voici la liste de vos véhicules disponibles : ");
        int index = 1;
        for(int i=0; i<vehiculesDisponibles.size(); i++){
            System.out.println(index + ") " +vehiculesDisponibles.get(i));
            System.out.println();
            ++index;
        }
        System.out.println("-- Fin de la liste --");
    }

    public void rendreVehiculeDisponible(){
        voirVehiculeReserves();
        System.out.println("Quel véhicule souhaitez-vous rendre disponible : ");
        int choixVehicule = inputIntUser() -1;

        int index = 0;
        for (Vehicule voiture : vehiculesReserves.keySet()) {
            if(index == choixVehicule) {
                vehiculesReserves.remove(voiture);
                vehiculesDisponibles.add(voiture);
            }
            ++index;
        }
        System.out.println("Véhicule rendu disponible : ");
        System.out.println(vehiculesDisponibles.get(vehiculesDisponibles.size()-1));
    }

    public void ajouterVehicule(){
        System.out.println("Ajout d'un véhicule : ");
        System.out.println("1) Terrestre ");
        System.out.println("2) Marin ");
        System.out.println("Quel est le type du véhicule : ");
        int typeVehicule = inputIntUser();
        System.out.println();

        switch(typeVehicule){
            case 1: //Terrestre
                System.out.println("Voici les véhicules terrestres disponibles : ");
                System.out.println("1) Bus ");
                System.out.println("2) Van ");
                System.out.print("Choisissez un véhicule : ");
                int typeVehiculeTerrestre = inputIntUser();
                switch(typeVehiculeTerrestre){
                    case 1: //Bus
                        System.out.println("Vous allez ajouter un bus : ");
                        Bus bus = new Bus();
                        System.out.println("Indiquez la référence du véhicule : ");
                        bus.setIdReference(inputStringUser());
                        System.out.println("Longueur (en m): ");
                        bus.setLongueur(inputIntUser());
                        System.out.println("Hauteur (en m): ");
                        bus.setHauteur(inputIntUser());
                        System.out.println("Indiquez le nombre max de personnes : ");
                        bus.setNbMaxPersonne(inputIntUser());
                        vehicules.add(bus);
                        vehiculesDisponibles.add(bus);
                        break;
                    case 2: //Van
                        System.out.println("Vous allez ajouter un van : ");
                        Van van = new Van();
                        System.out.println("Indiquez la référence du véhicule : ");
                        van.setIdReference(inputStringUser());
                        System.out.println("Indiquez le nombre max de personnes : ");
                        van.setNbMaxPersonne(inputIntUser());
                        vehicules.add(van);
                        vehiculesDisponibles.add(van);
                        break;
                }
                break;
            case 2: //Marin
                System.out.println("Voici les véhicules marin disponibles : ");
                System.out.println("1) Péniche ");
                System.out.print("Choisissez un véhicule : ");
                int typeVehiculeMarin = inputIntUser();
                if(typeVehiculeMarin == 1){
                    System.out.println("Vous allez ajouter une péniche : ");
                    Peniche peniche = new Peniche();
                    System.out.println("Indiquez la référence du véhicule : ");
                    peniche.setIdReference(inputStringUser());
                    System.out.println("Indiquez le nombre max de personnes : ");
                    peniche.setNbMaxPersonne(inputIntUser());
                    System.out.println("Les repas sont autorisé ? (o ou n) : ");
                    String repas = inputStringUser();
                    if(repas.equals("o")){
                        peniche.setRepas(true);
                    }else{
                        peniche.setRepas(false);
                    }
                    vehicules.add(peniche);
                    vehiculesDisponibles.add(peniche);
                }
                break;
        }
    }

    public void supprimerVehicule(){
        listerVehicules();
        System.out.print("Choisissez un véhicule à supprimer : ");
        int choixVehicule = inputIntUser() -1;
        vehicules.remove(choixVehicule);
        vehiculesDisponibles.remove(choixVehicule);
    }

    public void reserverVehicule(){
        listerDestinations();
        System.out.println("Choisissez une destination : ");
        Destination destination = destinations.get(inputIntUser() -1);
        listerVehicules();
        System.out.println("Choisissez un véhicule à réserver : ");
        Vehicule vehicule = vehicules.get(inputIntUser() -1);
        vehiculesReserves.put(vehicule, destination);
        vehiculesDisponibles.remove(vehicule);
    }

    public void ajouterDestination(){
        System.out.println("Création d'une destination : ");
        Destination destination = new Destination();
        System.out.println("Indiquez la référence : ");
        destination.setIdReference(inputStringUser());
        System.out.println("Indiquez le type (marin ou terrestre) : ");
        destination.setType(inputStringUser());
        System.out.println("Indiquez le lieu de départ : ");
        destination.setLieuDepart(inputStringUser());
        System.out.println("Indiquez le lieu de destination : ");
        destination.setLieuDestination(inputStringUser());
        String arret = "ok";
        System.out.println("Ecrivez le nom de l'arrêt puis Entrer (laisser vide pour terminer)");
        while(!arret.isEmpty()){
            arret = inputStringUser();
            if(!arret.isEmpty()){
                destination.ajouterArret(arret);
            }
        }
        this.getDestinations().add(destination);
        System.out.println("Destination ajoutée avec succès ! ");
    }

    public void supprimerDestination(){
        listerDestinations();
        System.out.print("Choisissez une destination à supprimer : ");
        int choixDestination = inputIntUser() -1;
        destinations.remove(choixDestination);
    }

    public void detailsDestination(){
        listerDestinations();
        System.out.print("Choisissez une destination à détailler : ");
        int choixDestination = inputIntUser() -1;
        Destination destination = this.getDestinations().get(choixDestination);
        System.out.println(destination);
    }

    public boolean quitterProgram(){
        System.out.println("Au revoir !");
        return false;
    }
}
