package src.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;;

/**
 * Classe Paquet qui represente un paquet de Carte
 */
public class Paquet {


    final String SEPARATEUR = ",";


    /**
     * arrayList qui contient les cartes par défaut vide
     */
    private ArrayList<Carte> cartes = new ArrayList<Carte>();

    /**
     * Constructeur d'un Paquet
     */
    public Paquet()
    {
        initPaquet();
    }

    /**
     * Retourne toutes les cartes du paquet
     * @return cartes qui sont les cartes qui composent le paquet
     */
    public ArrayList<Carte> getCartes()
    {
        return cartes;
    }

    /**
     * Permet la recherche de carte par indice
     * @param i numéro de la carte que l'on souhaite
     * @return la carte qui correspond à i
     * @throws IllegalArgumentException si la carte demandé n'existe pas
     */
    public Carte getCartes(int i)
    {
        if(i<0 || i>nbCarte())
        {
            throw new IllegalArgumentException("La carte demandé n'existe pas");
        }

        return cartes.get(i);
    }

    /**
     * Permet la recherche d'une carte par nom
     * @param i le nom de la carte que l'on souhaite rechercher
     * @return Carte qui correspond au string passé en paramètre sinon retourne Null
     */
    public Carte getCartes(String i){
        for(Carte j : cartes) {
            if ( j.getNom().matches(i))
            {
                //System.out.println(j.getNom()+","+j.getCategorie()+","+j.getValeur()+","+j.getColor()+","+j.getNbPoint());
                return j;
            }

        }
        return null;
    }

    /**
     * Permet d'ajouter une carte
     * @param arg0 carte que l'on souhaite ajouté à notre paquet
     */
    public void addCarte(Carte arg0) {
        cartes.add(arg0);
    }

    /**
     * @return la taille du Paquet
     */
    public int nbCarte(){
        return cartes.size();

    }

    /**
     * Initialise le Paquet en prenant en compte le fichier texte Cartes.txt qui contient toutes les informations
     * @throws IllegalArgumentException si la couleur n'existe pas
     * @throws IllegalArgumentException si la categorie n'existe pas
     * @throws IllegalArgumentException si la valeur n'existe pas
     */
    public void initPaquet()
    {
        try {
            // Le fichier d'entrée
            FileInputStream file = new FileInputStream("Cartes.txt");
            Scanner scanner = new Scanner(file);
            //renvoie true s'il y a une autre ligne à lire
            while (scanner.hasNextLine()) {
                String ligne = (scanner.nextLine());
                String mots[] = ligne.split(SEPARATEUR);

                Couleur color;
                //associe la bonne couleur
                switch (mots[1]){
                    case "NOIR" :
                        color = Couleur.NOIR;
                        break;
                    case "ROUGE":
                        color = Couleur.ROUGE;
                        break;
                    default:
                        throw new IllegalArgumentException("Couleur non connue");
                }

                Categorie cat;
                //associe la bonne categorie
                switch (mots[2]){
                    case "PIQUE" :
                        cat = Categorie.PIQUE;
                        break;
                    case "TREFLE":
                        cat = Categorie.TREFLE;
                        break;
                    case "CARREAU" :
                        cat = Categorie.CARREAU;
                        break;
                    case "COEUR":
                        cat = Categorie.COEUR;
                        break;
                    default:
                        throw new IllegalArgumentException("Categorie non connue");
                }

                Valeur val;
                //associe la bonne valeur
                switch (mots[3]){
                    case "AS" :
                        val = Valeur.AS;
                        break;
                    case "ROI" :
                        val = Valeur.ROI;
                        break;
                    case "DAME" :
                        val = Valeur.DAME;
                        break;
                    case "VALET" :
                        val = Valeur.VALET;
                        break;
                    case "DIX" :
                        val = Valeur.DIX;
                        break;
                    case "NEUF" :
                        val = Valeur.NEUF;
                        break;
                    case "HUIT" :
                        val = Valeur.HUIT;
                        break;
                    case "SEPT" :
                        val = Valeur.SEPT;
                        break;
                    default:
                        throw new IllegalArgumentException("Valeur non connue");
                }

                Carte c = new Carte(mots[0],color,cat,val);
                cartes.add(c);

                mots[0] = null;
                mots[1] = null;
                mots[2] = null;
                mots[3] = null;
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param liste arrayList dans laquelle on souhaite effectué le tirage
     * @return Carte qui est celle tiré au sort
     */
    public Carte tirageCarte(ArrayList<Carte> liste)
    {
        Collections.shuffle(liste);
        int n = (int) (Math.random() * liste.size());
        return this.getCartes(n);
    }


    /**
     * @return ArrayList qui contient les deux cartes qui ont été tiré au sort, celui-ci s'effectue avec remise dans le paquet originel
     */
    public ArrayList<Carte> tirage2Cartes()
    {
        //création d'une copie pour ne pas affecté le paquet initial
        ArrayList<Carte> copie = this.getCartes();
        ArrayList<Carte> cartesTire = new ArrayList<Carte>();

        int i=0;
        while (i<2)
        {
            Carte carte = tirageCarte(copie);
            cartesTire.add(carte);
            copie.remove(carte);
            i++;
        }

        return cartesTire;

    }


}
