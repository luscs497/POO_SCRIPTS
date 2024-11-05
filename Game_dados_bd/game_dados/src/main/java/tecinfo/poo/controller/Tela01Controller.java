package tecinfo.poo.controller;


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
        App.setRoot("face");

    }

    @FXML
    private void lancarDados(ActionEvent event) {
        Integer[] apostas = new Integer[11];
        String[] nomes = new String[11];
        
        apostas[0] = apostaP1.getValue();
        apostas[1] = apostaP2.getValue();
        apostas[2] = apostaP3.getValue();
        apostas[3] = apostaP4.getValue();
        apostas[4] = apostaP5.getValue();
        apostas[5] = apostaP6.getValue();
        apostas[6] = apostaP7.getValue();
        apostas[7] = apostaP8.getValue();
        apostas[8] = apostaP9.getValue();
        apostas[9] = apostaP10.getValue();
        apostas[10] = apostaP11.getValue();

        nomes[0] = nameP1.getText();
        nomes[1] = nameP2.getText();
        nomes[2] = nameP3.getText();
        nomes[3] = nameP4.getText();
        nomes[4] = nameP5.getText();
        nomes[5] = nameP6.getText();
        nomes[6] = nameP7.getText();
        nomes[7] = nameP8.getText();
        nomes[8] = nameP9.getText();
        nomes[9] = nameP10.getText();
        nomes[10] = nameP11.getText();


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
        boolean isThere = false;
        int cont = 0;
        for (Integer x : apostas) {
            if(x != null && x == resultado){
                isThere = true;
                break;
            }
            cont++;
        }
        if(isThere){
            conteudo += ", " + nomes[cont];
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