package projet.projetacl;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangementScene {

    DataSingleton data = DataSingleton.getInstance();

    public void quitterJeu(Button bouton){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Déconnexion");
        alert.setHeaderText("Vous allez quitter le jeu");
        alert.setContentText("Voulez-vous vraiment quitter le jeu? ");

        if(alert.showAndWait().get() == ButtonType.OK){
            Stage stage = (Stage) bouton.getScene().getWindow();
            System.out.println("Vous avez quitté le jeu avec succès");
            stage.close();
        }

    }

    public void changerScene(Button bouton, String pageVoulu, String titrePage) throws IOException {

        Stage stage = (Stage) bouton.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(pageVoulu+".fxml"));
        Parent root = loader.load();

        stage.setTitle(titrePage);
        stage.setScene(new Scene(root));
    }

    //ne pas oublier d'enlever le controller dans le FXML
    public void changerSceneControllerSpecifier(Button bouton, String pageVoulu, String titrePage, Object obj) throws IOException
    {
        Stage stage = (Stage) bouton.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(pageVoulu+".fxml"));
        loader.setController(obj);
        Parent root = loader.load();

        stage.setTitle(titrePage);
        stage.setScene(new Scene(root));
    }

    public void changerScene2(Button bouton, String pageVoulu, String titrePage, Label label) throws IOException {

        data.setScoreFinal(label.getText());
        Stage stage = (Stage) bouton.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(pageVoulu+".fxml"));
        Parent root = loader.load();

        stage.setTitle(titrePage);
        stage.setScene(new Scene(root));
    }



    public void abandon(Button bouton) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Abandon");
        alert.setHeaderText("Vous allez quitter la partie");
        alert.setContentText("Voulez-vous vraiment abandonner la partie? (aucune sauvegarde ne sera fait) ");

        if(alert.showAndWait().get() == ButtonType.OK){
            changerScene(bouton,"menuPrincipal","Menu Principal");
        }
    }

    public void popUp(String direction,String titre) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(direction+".fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root,500,300);
        stage.setTitle(titre);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

}
