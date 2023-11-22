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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nbPointFinal.setText(data.getScoreFinal());
    }

    public void afficherTableau(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.popUp("tableauScore","Affichage Tableau Score");
    }

    public void quitterJeu(ActionEvent event) {
        ChangementScene controller = new ChangementScene();
        controller.quitterJeu(quitterPartie);
    }

    public void rejouerPartie(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.changerScene(rejouerNewPartie,"menuSecondaire","Menu Secondaire");
    }


}
