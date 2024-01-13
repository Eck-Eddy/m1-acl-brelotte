package projet.projetacl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.model.Joueur;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * classe qui gère le tableaud'affichage des scores
 */
public class tableauScoreController implements Initializable{

    final String SEPARATEUR = ",";

    @FXML
    private Button RetourMenu;


    @FXML
    private TableView<Joueur> joueurs;

    @FXML
    private TableColumn<Joueur, Integer> pointCol;

    @FXML
    private TableColumn<Joueur, String> pseudoCol;


    /**
     * procédure qui initialise le tableau
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pointCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("points"));
        pseudoCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("Pseudonyme"));
        setupTable();
    }

    /**
     * procédure qui créé la table à l'aide du fichier tableauScore.txt   */
    private void setupTable(){

        try {
            // Le fichier d'entrée
            FileInputStream file = new FileInputStream("tableauScore.txt");
            Scanner scanner = new Scanner(file);
            //renvoie true s'il y a une autre ligne à lire
            while (scanner.hasNextLine()) {
                String ligne = (scanner.nextLine());
                String mots[] = ligne.split(SEPARATEUR);

                Joueur j = new Joueur(mots[0], Integer.parseInt(mots[1]));
                joueurs.getItems().add(j);

                mots[0] = null;
                mots[1] = null;

            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * procédure qui gère l'action de retourner au menu principal
     * @param event
     * @throws IOException
     */
    public void retourMenu(ActionEvent event) throws IOException {
        ChangementScene controller = new ChangementScene();
        controller.changerScene(RetourMenu,"menuPrincipal","Menu Principal");

    }


}
