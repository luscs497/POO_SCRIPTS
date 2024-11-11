package tecinfo.poo.controller;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import tecinfo.poo.App;
import java.io.IOException;
import tecinfo.poo.controller.FaceController;
import tecinfo.poo.model.Dado;
import tecinfo.poo.model.Player;



public class Tela01Controller {

    @FXML 
    private Button ButtonPlay;

    @FXML
    private ChoiceBox<Integer> apostaP1;
    @FXML 
    private ChoiceBox<Integer> apostaP2;
    @FXML 
    private ChoiceBox<Integer> apostaP3;
    @FXML 
    private ChoiceBox<Integer> apostaP4;
    @FXML 
    private ChoiceBox<Integer> apostaP5;
    @FXML 
    private ChoiceBox<Integer> apostaP6;
    @FXML 
    private ChoiceBox<Integer> apostaP7;
    @FXML 
    private ChoiceBox<Integer> apostaP8;
    @FXML 
    private ChoiceBox<Integer> apostaP9;
    @FXML 
    private ChoiceBox<Integer> apostaP10;
    @FXML 
    private ChoiceBox<Integer> apostaP11;

    @FXML
    private TextField nameP1;
    @FXML 
    private TextField nameP2;
    @FXML 
    private TextField nameP3;
    @FXML 
    private TextField nameP4;
    @FXML 
    private TextField nameP5;
    @FXML 
    private TextField nameP6;
    @FXML 
    private TextField nameP7;
    @FXML 
    private TextField nameP8;
    @FXML 
    private TextField nameP9;
    @FXML 
    private TextField nameP10;
    @FXML 
    private TextField nameP11;



    @FXML
    public void initialize() {
        ObservableList<Integer> options = FXCollections.observableArrayList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        apostaP1.setItems(options);
        apostaP2.setItems(options);
        apostaP3.setItems(options);
        apostaP4.setItems(options);
        apostaP5.setItems(options);
        apostaP6.setItems(options);
        apostaP7.setItems(options);
        apostaP8.setItems(options);
        apostaP9.setItems(options);
        apostaP10.setItems(options);
        apostaP11.setItems(options);
    }

    private void switchToSecondary() throws IOException {
        App.setRoot("tela02");

    }

    @FXML
    private void lancarDados(ActionEvent event) {
        ArrayList<Player> jogadores = new ArrayList<>();
        Player p1 = new Player(nameP1.getText(), apostaP1.getValue());
        jogadores.add(p1);
        Player p2 = new Player(nameP2.getText(), apostaP2.getValue());
        jogadores.add(p2);
        Player p3 = new Player(nameP3.getText(), apostaP3.getValue());
        jogadores.add(p3);
        Player p4 = new Player(nameP4.getText(), apostaP4.getValue());
        jogadores.add(p4);
        Player p5 = new Player(nameP5.getText(), apostaP5.getValue());
        jogadores.add(p5);
        Player p6 = new Player(nameP6.getText(), apostaP6.getValue());
        jogadores.add(p6);
        Player p7 = new Player(nameP7.getText(), apostaP7.getValue());
        jogadores.add(p7);
        Player p8 = new Player(nameP8.getText(), apostaP8.getValue());
        jogadores.add(p8);
        Player p9 = new Player(nameP9.getText(), apostaP9.getValue());
        jogadores.add(p9);
        Player p10 = new Player(nameP10.getText(), apostaP10.getValue());
        jogadores.add(p10);
        Player p11 = new Player(nameP11.getText(), apostaP11.getValue());
        jogadores.add(p11);

        String caminhoArquivo = "src/main/java/tecinfo/poo/controller/auxiliar.txt";

        Dado d1 = new Dado();
        Dado d2 = new Dado();
        int dd1 = 0;
        int dd2 = 0;
        int resultado = 0;
        d1.setValorFace();
        d2.setValorFace();
        dd1 = d1.getValorFace();
        dd2 = d2.getValorFace();
        resultado = dd1 + dd2;

        String conteudo = resultado + ", " + dd1 + ", " + dd2;
        for (Player x : jogadores) {
            if(x.getAposta() != null && x.getAposta() == resultado){
                conteudo += ", " + x.getName();
                break;
            }
        }

        try {
            FileWriter escritorArquivo = new FileWriter(caminhoArquivo, false);
            BufferedWriter escritorBuffer = new BufferedWriter(escritorArquivo);

            escritorBuffer.write(conteudo);

            escritorBuffer.newLine();
            escritorBuffer.flush();
            escritorBuffer.close();
            escritorArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            switchToSecondary();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showRanking(ActionEvent event){
        try {
            App.setRoot("ranking");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}