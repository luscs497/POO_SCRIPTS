package tecinfo.poo.controller;

import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.fxml.FXML;
import tecinfo.poo.App;
import tecinfo.poo.controller.FaceController;


public class Tela02Controller {

    private Integer[] apostas;

    private String[] nomes;

    @FXML
    public void initialize() {
        
    }

    public void setNomes(String[] nomes){
        this.nomes = nomes;
    }

    public void setApostas(Integer[] apostas){
        this.apostas = apostas;
        try {
            switchToSecondary(getNomes(), getApostas());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public Integer[] getApostas(){
        return this.apostas;
    }

    public String[] getNomes(){
        return this.nomes;
    }

    private void switchToSecondary(String[] nomes, Integer[] apostas) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("face.fxml"));
        loader.load();
        FaceController faceController = loader.getController(); // Obtém a instância do controlador da nova tela

        // Passa os dados para o novo controlador

        // Muda a cena para a nova tela
        App.setRoot("face");

    }
}
