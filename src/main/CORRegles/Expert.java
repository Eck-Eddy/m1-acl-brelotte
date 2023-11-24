package CORRegles;

import src.model.Carte;

import java.util.ArrayList;

public interface Expert {
    void calculPoint(ArrayList<Carte> cartetire);

    void handle(ArrayList<Carte> cartetire);

    void setNextHandler(Expert memeValeurHandler);
}