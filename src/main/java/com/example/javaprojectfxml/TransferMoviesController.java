package com.example.javaprojectfxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TransferMoviesController {
    public Button back;
    ProductionSceneController productionSceneController;

    public ProductionSceneController getProductionSceneController() {
        return productionSceneController;
    }

    public void setProductionSceneController(ProductionSceneController productionSceneController) {
        this.productionSceneController = productionSceneController;
    }

    public TextField moviename;
    public TextField productioncompanyname;
    public Button transfer;

    public void onTransferClick(ActionEvent actionEvent) {
        String s = moviename.getText();
        Movie mtr = new Movie();
        for (int i = 0; i < ReadThreadClient.p.size(); i++) {
            Movie nnn = ReadThreadClient.p.get(i);
            if (s.equalsIgnoreCase(nnn.getMovieName())) {
                mtr = nnn;
                ReadThreadClient.p.remove(nnn);
            }
        }
        System.out.println(ReadThreadClient.p.size());
        String s1 = productioncompanyname.getText();
        String s2 = MainSceneController.clientname;
        Message message = new Message();
        message.setFrom(s2);
        message.setTo(s1);
        message.setMovie(mtr);
        try {
            Client.sock.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
