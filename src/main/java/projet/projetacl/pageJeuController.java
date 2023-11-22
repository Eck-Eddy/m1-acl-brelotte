package projet.projetacl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.model.Carte;
import src.model.Jeu;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class pageJeuController implements Initializable {

    private Jeu game;
    private int nombreDeTour;
    private int pointDuTour;
    private int scoreTotalPartie;

    @FXML
    private Button tirerCartes;

    @FXML
    private Button abandonPartie;

    @FXML
    private Label pointTour;

    @FXML
    private Label scoreTotal;

    @FXML
    private Label nbTour;

    @FXML
    private ImageView caseCarte1;

    @FXML
    private ImageView caseCarte2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pointTour.setText(String.valueOf(pointDuTour));
        scoreTotal.setText(String.valueOf(scoreTotalPartie));
        nbTour.setText(String.valueOf(nombreDeTour));

    }

    public pageJeuController(Jeu game)
    {
        this.game = game;
        nombreDeTour = game.getNbTour();
        pointDuTour = game.getPointTour();
        scoreTotalPartie = game.getJoueur().getPoints();

    }

    public void rafraichirAffichage()
    {
        pointTour.setText(String.valueOf(game.getPointTour()));
        scoreTotal.setText(String.valueOf(game.getJoueur().getPoints()));
        nbTour.setText(String.valueOf(game.getNbTour()));
    }

    public void tirageCarte(ActionEvent event) throws IOException {

        if(game.getNbTour()>1)
        {
            ArrayList<Carte> tirage = game.getPaquetCarte().tirage2Cartes();
            game.calculPoint(tirage);
            game.setNbTour(game.getNbTour()-1);
            rafraichirAffichage();

            Image image1 = new Image(getClass().getResourceAsStream("Images/"+tirage.get(0).getNom()+".png"));
            caseCarte1.setImage(image1);

            Image image2 = new Image(getClass().getResourceAsStream("Images/"+tirage.get(1).getNom()+".png"));
            caseCarte2.setImage(image2);

            System.out.println(tirage.get(0).getNom());
            System.out.println(tirage.get(1).getNom());
        }
        else
        {

            FileWriter writer = new FileWriter("tableauScore.txt",true);
            writer.append(game.getJoueur().getPseudonyme()+","+game.getJoueur().getPoints()+"\n");
            writer.close();

            ChangementScene controller = new ChangementScene();
            controller.changerScene2(tirerCartes,"finPartie","Menu de fin de partie",scoreTotal);
            //controller.changerScene(tirerCartes,"finPartie","Menu de fin de partie");
            //controller.changerSceneControllerSpecifier(tirerCartes,"finPartie","Menu de fin de partie",game);
        }


    }

    public void abandonnerPartie(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.abandon(abandonPartie);
    }


}
