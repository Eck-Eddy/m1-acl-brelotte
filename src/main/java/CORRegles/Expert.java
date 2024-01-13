package CORRegles;

import src.model.Carte;

import java.util.ArrayList;

public interface Expert {
    /**
     * procédure qui gère le calcul du nombre de points
     * @param cartetire
     */
    void calculPoint(ArrayList<Carte> cartetire);

    /**
     * procédure qui gère la chaîne de responsabilité
     * @param cartetire
     */
    void handle(ArrayList<Carte> cartetire);

    /**
     * procédure qui fixe le gestionnaire suivant
     * @param memeValeurHandler
     */
    void setNextHandler(Expert memeValeurHandler);
}