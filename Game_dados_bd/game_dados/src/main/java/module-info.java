module tecinfo.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;
    requires javafx.base;
    requires javafx.graphics;

    opens tecinfo.poo.controller to javafx.fxml;
    opens tecinfo.poo.model to javafx.base; // adicionado para que possa usar Player no ObservableList do TableView em SecondaryController

    exports tecinfo.poo;
} 