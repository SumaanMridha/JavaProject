package com.example.javaprojectfxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TotalProfitController implements Initializable {
    long p=ReadThreadClient.totalprofit;
    ProductionSceneController productionSceneController;

    public ProductionSceneController getProductionSceneController() {
        return productionSceneController;
    }

    public void setProductionSceneController(ProductionSceneController productionSceneController) {
        this.productionSceneController = productionSceneController;
    }



    public Button back;
    public Label label;


    public void onBackClick(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("production-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        label.setText(String.valueOf(p));

    }
}
