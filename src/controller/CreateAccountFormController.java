package controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CreateAccountFormController {
    public AnchorPane createYourOceanAccount;
    public Label labelOceanAccount;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtUserName;
    public TextField txtConfirm;
    public TextField txtPassword;
    public RadioButton btnShowPassword;
    public Label labelSignInInstead;
    public JFXButton btnNext;
    public JFXButton btnBack;

    public void moveToLastName(ActionEvent actionEvent) {
        txtLastName.requestFocus();
    }

    public void moveToUserName(ActionEvent actionEvent) {
        txtUserName.requestFocus();
    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }



    public void showPassword(ActionEvent actionEvent) {

    }

    public void nextWindowOpen(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) createYourOceanAccount.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void backToWindowOpen(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/EnterWebForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) createYourOceanAccount.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void moveToConfirm(ActionEvent actionEvent) {
        txtConfirm.requestFocus();
    }

    public void confirmMethod(ActionEvent actionEvent) {

    }
}
