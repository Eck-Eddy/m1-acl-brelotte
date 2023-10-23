package src;

import java.util.ArrayList;
import java.util.Random;;

public class Paquet {

    private ArrayList<Carte> cartes;

    //Fonction tirer cartes pour pouvoir enlever du tas une carte et la retourner
    Carte TirerCarte(){
    	
    	Carte carteRetiree;
    	
    	//nb alea taille paquet
    	//ens stocker la carte l'enlever du paquet et la return de la fonction
    	Random random = new Random();
		int carteAleatoire = random.nextInt(cartes.size());
		carteRetiree = cartes.get(carteAleatoire);
		cartes.remove(carteAleatoire);
		return carteRetiree;
    }
    
    
}