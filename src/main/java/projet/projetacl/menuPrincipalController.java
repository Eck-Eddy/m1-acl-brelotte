package projet.projetacl;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class menuPrincipalController {

    @FXML
    private Button quitterMenuPrincipal;
    @FXML
    private Button afficheTableauRecord;
    @FXML
    private Button commencerPartie;

    @FXML

    private AnchorPane scenePane;


    @FXML
    protected void commencer(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.changerScene(commencerPartie,"menuSecondaire","Menu Secondaire");

    }

    @FXML
    protected void afficheTableau(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.changerScene(afficheTableauRecord,"tableauScore","Affichage Score");

    }


    @FXML
    protected void quitterMenu(ActionEvent event) {
        ChangementScene controller = new ChangementScene();
        controller.quitterJeu(quitterMenuPrincipal);

    }

}

