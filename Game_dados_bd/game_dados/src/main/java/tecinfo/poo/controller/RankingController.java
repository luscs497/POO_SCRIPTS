package tecinfo.poo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import tecinfo.poo.model.dao.PlayerDao;
import tecinfo.poo.model.Player;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import tecinfo.poo.App;



public class RankingController {

    @FXML
    private Button backButton;

    @FXML
    private TableView<Player> tableView;

    @FXML
    private TableColumn<Player, Integer> Id; 
    @FXML
    private TableColumn<Player, String> Nome;
    @FXML
    private TableColumn<Player, Integer> Vitorias;


    @SuppressWarnings("unchecked")
    @FXML
    public void initialize() {

        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nome.setCellValueFactory(new PropertyValueFactory<>("name"));
        Vitorias.setCellValueFactory(new PropertyValueFactory<>("wins"));
        ObservableList<Player> players = fillTableFromDB();
        players.sort((p1, p2) -> Integer.compare(p2.getWins(), p1.getWins()));

        ObservableList<Player> limitedPlayers = FXCollections.observableArrayList(players.subList(0, Math.min(players.size(), 5)));
        tableView.setItems(limitedPlayers);

    }

    public ObservableList<Player> fillTableFromDB() {
        PlayerDao playerDao = new PlayerDao();
        return FXCollections.observableArrayList(playerDao.getAll());
    }

    @FXML
    public void backToPage(ActionEvent event){
        try {
            App.setRoot("tela01");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

