package com.example.javaprojectfxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MoviesProductionController implements Initializable {
    ProductionSceneController productionSceneController;

    public ProductionSceneController getProductionSceneController() {
        return productionSceneController;
    }

    public void setProductionSceneController(ProductionSceneController productionSceneController) {
        this.productionSceneController = productionSceneController;
    }

    static List<Movie> movieList;
    public TableView<Movie> table;
    public TableColumn<Movie, String> Moviename;
    public TableColumn<Movie, Integer> releaseyear;
    public TableColumn<Movie, String> genre1;
    public TableColumn<Movie, String> genre2;
    public TableColumn<Movie, String> genre3;
    public TableColumn<Movie, Integer> runningtime;
    public TableColumn<Movie, String> productioncompany;
    public TableColumn<Movie, Integer> budget;
    public TableColumn<Movie, Integer> revenue;
    public Button back;

    ObservableList<Movie> list= FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Movie movie : ReadThreadClient.p) {
            list.add(movie);
        }
        Moviename.setCellValueFactory(new PropertyValueFactory<>("moviename"));
        releaseyear.setCellValueFactory(new PropertyValueFactory<>("year"));
        genre1.setCellValueFactory(new PropertyValueFactory<>("genre1"));
        genre2.setCellValueFactory(new PropertyValueFactory<>("genre2"));
        genre3.setCellValueFactory(new PropertyValueFactory<>("genre3"));
        runningtime.setCellValueFactory(new PropertyValueFactory<>("runningtime"));
        productioncompany.setCellValueFactory(new PropertyValueFactory<>("productioncompany"));
        budget.setCellValueFactory(new PropertyValueFactory<>("budget"));
        revenue.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        table.setItems(list);
    }

    public void onBackClick(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("production-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();

    }
}


