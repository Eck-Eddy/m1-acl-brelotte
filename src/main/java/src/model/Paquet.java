package src.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;;

public class Paquet {

    final String SEPARATEUR = ",";
    private ArrayList<Carte> cartes = new ArrayList<Carte>();

    public Paquet()
    {
        initPaquet();
    }

    public ArrayList<Carte> getCartes()
    {
        return cartes;
    }

    public Carte getCartes(int i)
    {
        if(i<0 || i>nbCarte())
        {
            throw new IllegalArgumentException("La case demandé n'existe pas");
        }

        return cartes.get(i);
    }

    public Carte getCartes(String i){
        for(Carte j : cartes) {
            if ( j.getNom().matches(i))
            {
                System.out.println(j.getNom()+","+j.getCategorie()+","+j.getValeur()+","+j.getColor()+","+j.getNbPoint());
                return j;
            }


        }
        return null;
    }

    public void addCarte(Carte arg0) {
        cartes.add(arg0);
    }

    public int nbCarte(){
        return cartes.size();

    }

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

    public Carte tirageCarte(ArrayList<Carte> liste)
    {
        Collections.shuffle(liste);
        int n = (int) (Math.random() * liste.size());
        return this.getCartes(n);
    }

    public ArrayList<Carte> tirage2Cartes()
    {
        //ArrayList<Carte> copie = cartes;
        ArrayList<Carte> copie = new ArrayList<>(cartes);
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
