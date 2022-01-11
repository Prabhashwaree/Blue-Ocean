package controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminFormController {

    public AnchorPane adminPane;
    public JFXButton btnLogin;
    public JFXButton btnHome;
    public TextField txtUserName;
    public TextField txtPassword;
    public JFXButton btnConfirm;

    public void openIncomeReportWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/IncomeReportsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openHomeWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/EnterWebForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void showPassword(ActionEvent actionEvent) {

    }

    public void confirmMethod(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Your Password is Successful", ButtonType.OK);
            a.show();
        });
    }
}
