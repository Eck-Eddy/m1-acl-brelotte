package projet.projetacl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.model.Jeu;
import src.model.Joueur;

import java.io.IOException;

public class menuSecondaireController {

    @FXML
    private Button quitterMenuSecondaire;

    @FXML
    private Button retourMenuPrincipal;

    @FXML
    private Button validerSaisiePseudo;

    @FXML
    private TextField saisiePseudo;
    
    public void validerPseudo(ActionEvent event) throws IOException {

        try
        {
            Joueur joueur = new Joueur(saisiePseudo.getText());
            System.out.println(joueur.getPseudonyme());

            Jeu game = new Jeu(joueur);
            pageJeuController pageJeu = new pageJeuController(game);



            ChangementScene controller = new ChangementScene();
            controller.changerSceneControllerSpecifier(validerSaisiePseudo,"pageJeu","Jeu",pageJeu);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public void retourPrincipal(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.changerScene(retourMenuPrincipal,"menuPrincipal","Menu Principal");

    }

    public void quitterSecondaire(ActionEvent event) {

        ChangementScene controller = new ChangementScene();
        controller.quitterJeu(quitterMenuSecondaire);

    }


}
