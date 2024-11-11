package tecinfo.poo.controller;

import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import tecinfo.poo.App;
import tecinfo.poo.controller.FaceController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.image.Image;


public class Tela02Controller {

    @FXML
    private ImageView ImageDice;

    @FXML
    private Label LabelDice;

    private int counter = 1;

    private String content = "Lançando os dados";



    @FXML
    public void initialize() {
        ImageDice.setImage(new Image(getClass().getResourceAsStream("/tecinfo/poo/img/dados.gif")));

        LabelDice.setText(content);

        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> {
                content = content + ".";
                LabelDice.setText(content);
                counter++;
            })
        );

        timeline.setCycleCount(4);
        timeline.play();

        timeline.setOnFinished(e -> {
            try {
                switchToFace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void switchToFace() throws IOException {
        App.setRoot("face");
    }
}
