package projet.projetacl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import src.model.Jeu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * classe qui gère la fin de partie
 */
public class finPartieController implements Initializable {
    @FXML
    private Button rejouerNewPartie;

    @FXML
    private Button quitterPartie;

    @FXML
    private Button afficherTableauScore;

    @FXML
    private Label nbPointFinal;

    private int pointTotal;

    DataSingleton data = DataSingleton.getInstance();

    /**
     * Procédure qui gère l'initialisation de la page de fin de jeu
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nbPointFinal.setText(data.getScoreFinal());
    }

    /**
     * Procédure qui gère l'affichage du tableau de score si l'utilisateur clic dessus
     * @param event
     * @throws IOException
     */
    public void afficherTableau(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.popUp("tableauScore","Affichage Tableau Score");
    }

    /**
     * procédure qui gère le fait de quitter le jeu si l'utilisateur le décide
     * @param event
     */
    public void quitterJeu(ActionEvent event) {
        ChangementScene controller = new ChangementScene();
        controller.quitterJeu(quitterPartie);
    }

    /**
     * gére la relance d'une partie si l'utilisateur le décide en cliquant sur le bouton
     * @param event
     * @throws IOException
     */
    public void rejouerPartie(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.changerScene(rejouerNewPartie,"menuSecondaire","Menu Secondaire");
    }


}
