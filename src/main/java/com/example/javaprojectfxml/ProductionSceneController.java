package com.example.javaprojectfxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ProductionSceneController {
    public Button allmovies;
    public Button recentmovies;
    public Button maximumrevenue;
    public Button totalprofit;
    public Button back;
    public Button addmovie;
    public Button transfermovie;

    @FXML
    private void onAllMovieClick(ActionEvent actionEvent) throws IOException {

        Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("movies-production.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MoviesProductionController controller=fxmlLoader.getController();
            controller.setProductionSceneController(this);
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();

    }
    @FXML

    private void onRecentMovies(ActionEvent actionEvent) throws IOException {
            Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("movies-production1.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MoviesProduction1Controller controller=fxmlLoader.getController();
            controller.setProductionSceneController(this);
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
    }
    @FXML

    private void onMaximumRevenue(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("maxrevenue-show.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MaxRevenueShowConroller controller=fxmlLoader.getController();
        controller.setProductionSceneController(this);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    @FXML

    private void onTotalProfit(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("total-profit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        TotalProfitController controller=fxmlLoader.getController();
        controller.setProductionSceneController(this);
        stage.setTitle("");
        stage.setScene(scene);

    }
    @FXML

    public void onAddMovieClick(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("add-movieoption.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        AddMovieoptionController controller=fxmlLoader.getController();
        controller.setProductionSceneController(this);
        stage.setTitle("");
        stage.setScene(scene);
    }
    @FXML
    private void onBackClick(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onTransferMovie(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("transfer-movies.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        TransferMoviesController controller=fxmlLoader.getController();
        controller.setProductionSceneController(this);
        stage.setTitle("");
        stage.setScene(scene);

    }
}
