package tecinfo.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import tecinfo.poo.model.dao.DBConnection;
import tecinfo.poo.model.dao.PlayerDao;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        DBConnection db = new DBConnection();
        PlayerDao p1 = new PlayerDao();
        if(db.getConnection() != null){
            System.out.println("Deu certo!");
            System.out.println(p1.getAll());

        }
        scene = new Scene(loadFXML("tela01"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }



}