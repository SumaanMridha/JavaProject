package com.example.javaprojectfxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMovieoptionController {
    ProductionSceneController productionSceneController;

    public ProductionSceneController getProductionSceneController() {
        return productionSceneController;
    }

    public void setProductionSceneController(ProductionSceneController productionSceneController) {
        this.productionSceneController = productionSceneController;}

    public TextField moviename;
    public TextField releaseyear;
    public TextField genre1;
    public TextField genre2;
    public TextField genre3;
    public TextField runningtime;
    public TextField productionname;
    public TextField budget;
    public TextField revenue;
    public Button add;
    public Button back;

    public void onAddClick(ActionEvent actionEvent) throws IOException {
        ADDMOVIE add=new ADDMOVIE();
        add.setMoviename(moviename.getText());
        add.setYear(Integer.parseInt(releaseyear.getText()));
        add.setGenre1(genre1.getText());
        add.setGenre2(genre2.getText());
        add.setGenre3(genre3.getText());
        add.setRunningtime(Long.parseLong(runningtime.getText()));
        add.setProductioncompany(productionname.getText());
        add.setBudget(Long.parseLong(budget.getText()));
        add.setRevenue(Long.parseLong(revenue.getText()));
        System.out.println(releaseyear.getText());
       // ADDMOVIE.addd=add;
        Client.sock.write(add);
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
