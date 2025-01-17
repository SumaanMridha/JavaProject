package com.example.javaprojectfxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import java.util.ResourceBundle;

public class MoviesProduction1Controller implements Initializable {
    ProductionSceneController productionSceneController;

    public ProductionSceneController getProductionSceneController() {
        return productionSceneController;
    }

    public void setProductionSceneController(ProductionSceneController productionSceneController) {
        this.productionSceneController = productionSceneController;
    }

    public TableView<Movie> table;
    public TableColumn<String,Movie> Moviename;
    public TableColumn<Integer,Movie> releaseyear;
    public TableColumn <String,Movie>genre1;
    public TableColumn<String,Movie> genre2;
    public TableColumn <String,Movie>genre3;
    public TableColumn<Integer,Movie> runningtime;
    public TableColumn <String,Movie>productioncompany;
    public TableColumn <Integer,Movie>budget;
    public TableColumn <Integer,Movie>revenue;
    public Button back;
    ObservableList<Movie> list= FXCollections.observableArrayList();
    public void initialize(URL location, ResourceBundle resources) {
        //System.out.println(ReadThreadClient.m.size());
        for (Movie movie : ReadThreadClient.m) {
           // System.out.println(movie.getMovieName());
            list.add(movie);

        }
        System.out.println(list.size());
        System.out.println(ReadThreadClient.p.size());
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
    @FXML

    private void onBackClick(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("production-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();

    }
}
