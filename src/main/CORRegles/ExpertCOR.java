package CORRegles;

import src.model.Carte;
import java.util.ArrayList;

abstract class ExpertCOR implements Expert {
    private Expert suivant;

    public void setNextHandler(Expert nextHandler) {
        this.suivant = nextHandler;
    }

    public void handle(ArrayList<Carte> cartetire) {
        if (canHandle(cartetire)) {
            calculPoint(cartetire);
        } else if (suivant != null) {
            suivant.handle(cartetire);
        } else {
            /*que couleurs diff +0 points"*/
        }
    }

    protected abstract boolean canHandle(ArrayList<Carte> cartetire);
}
