package CORRegles;

import src.model.Carte;
import java.util.ArrayList;

/**
 * Classe qui gère la chaîne de responsabilité
 */
abstract class ExpertCOR implements Expert {
    private Expert suivant;

    /**
     * procédure qui fixe le gestionnaire suivant
     * @param nextHandler
     */
    public void setNextHandler(Expert nextHandler) {
        this.suivant = nextHandler;
    }

    /**
     * procédure qui gère la chaîne de responsabilité
     * @param cartetire
     *
     */
    public void handle(ArrayList<Carte> cartetire) {
        if (canHandle(cartetire)) {
            calculPoint(cartetire);
        } else if (suivant != null) {
            suivant.handle(cartetire);
        } else {
            /*que couleurs diff +0 points"*/
        }
    }

    /**
     * fonction qui voit si la règle peut gérer le cas
     * @param cartetire
     * @return
     */
    protected abstract boolean canHandle(ArrayList<Carte> cartetire);
}
