package controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class EnterWebFormController {
    public AnchorPane openWindowFirst;
    public Label blueOceanName;
    public Label labelUserName;
    public Label labelPassword;
    public TextField txtUserName;
    public TextField txtPassword;
    public JFXButton createAccountBtn;
    public JFXButton loginBtn;

    public void openInCreateAccount(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/CreateAccountForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) openWindowFirst.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }


    public void openInLoginWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) openWindowFirst.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void passwordShow(ActionEvent actionEvent) {
    }

    public void comfirmMethod(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Your Password is Successful", ButtonType.OK);
            a.show();
        });
    }
}
