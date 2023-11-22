module projet.projetacl {
    requires javafx.controls;
    requires javafx.fxml;


    opens projet.projetacl to javafx.fxml;
    opens src.model to javafx.fxml;
    exports projet.projetacl;
    exports src.model;

}