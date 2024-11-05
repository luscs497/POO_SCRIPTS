package tecinfo.poo.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.fxml.FXML;
import tecinfo.poo.App;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import tecinfo.poo.model.Dado;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import tecinfo.poo.model.dao.PlayerDao;
import tecinfo.poo.model.Player;


public class FaceController {

    @FXML
    private ImageView dado01;

    @FXML
    private ImageView dado02;

    @FXML
    private Label gameResult;

    @FXML
    private Button playAgain;

    @FXML
    private Label playerResult;


    private final String[] diceImages = {
        "/tecinfo/poo/img/Face1.png",
        "/tecinfo/poo/img/Face2.png",
        "/tecinfo/poo/img/Face3.png",
        "/tecinfo/poo/img/Face4.png",
        "/tecinfo/poo/img/Face5.png",
        "/tecinfo/poo/img/Face6.png"
    };

    @FXML
    public void initialize() {
        try {
            mostrarResultado();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    private void mostrarResultado() throws IOException {
        int resultado = 0;
        int dd1 = 0;
        int dd2 = 0;
        String nameP = "";
        try {
            FileReader leitorArquivo = new FileReader("src/main/java/tecinfo/poo/controller/auxiliar.txt");
            BufferedReader leitorBuffer = new BufferedReader(leitorArquivo);
            
            String linha;
            while ((linha = leitorBuffer.readLine()) != null) {
                String[] dados = linha.split(", ");
                resultado = Integer.valueOf(dados[0]);
                dd1 = Integer.valueOf(dados[1]);
                dd2 = Integer.valueOf(dados[2]);
                if(dados.length > 3){
                    nameP = dados[3];
                }
            }
            leitorBuffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dado01.setImage(new Image(getClass().getResourceAsStream(diceImages[dd1 - 1])));

        dado02.setImage(new Image(getClass().getResourceAsStream(diceImages[dd2 - 1])));
        

        gameResult.setText("O resultado do lançamento dos dados foi: " + resultado);

        if(nameP != ""){
            playerResult.setText("O jogador " + nameP + " venceu! Parabéns!!");
            PlayerDao db = new PlayerDao();
            Player p1 = db.get(nameP);
            if(p1 != null){
                p1.setWins(p1.getWins() + 1);
                db.update(p1);
            }else{
                p1 = new Player(nameP, 1);
                db.save(p1);
            }
            
        }else{
            playerResult.setText("Nenhum jogador venceu! Sinto muito :/");
        }
    }

    @FXML
    private void playAgain(ActionEvent event){
        try {
            App.setRoot("tela01");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
