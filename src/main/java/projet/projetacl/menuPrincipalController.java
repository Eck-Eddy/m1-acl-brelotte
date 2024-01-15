package projet.projetacl;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * classe qui gère le menu principal
 */
public class menuPrincipalController {

    @FXML
    private Button quitterMenuPrincipal;
    @FXML
    private Button afficheTableauRecord;
    @FXML
    private Button commencerPartie;
    @FXML
    private Button ReglesJeu;

    @FXML

    private AnchorPane scenePane;


    /**
     * procédure qui gère le lancement du jeu
     * @param event
     * @throws IOException
     */
    @FXML
    protected void commencer(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.changerScene(commencerPartie,"menuSecondaire","Menu Secondaire");

    }

    /**
     * procédure qui gère le clic de l'utilisateur sur le bouton d'affichage pour le tableau des scores
     * @param event
     * @throws IOException
     */
    @FXML
    protected void afficheTableau(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.changerScene(afficheTableauRecord,"tableauScore","Affichage Score");

    }


    /**
     * procédure pour quitter l'application
     * @param event
     */
    @FXML
    protected void quitterMenu(ActionEvent event) {
        ChangementScene controller = new ChangementScene();
        controller.quitterJeu(quitterMenuPrincipal);

    }

    @FXML
    protected void afficherRegle(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.popUp("pageRegle","Affichage des règles");


    }
}

