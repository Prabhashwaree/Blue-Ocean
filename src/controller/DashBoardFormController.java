package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBoardFormController {
    public AnchorPane hotelManagementSystemPane;
    public JFXButton btnBookingDetails;
    public JFXButton btnRoomDetails;
    public JFXButton btnMealsDetails;
    public JFXButton btnIncomeReportsDetails;
    public Label labelHotelManagementSystem;
    public JFXButton btnBack;

    public void openBookingDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/BookingDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) hotelManagementSystemPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openRoomDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/RoomDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) hotelManagementSystemPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openMealsDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MealsDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) hotelManagementSystemPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openIncomeReportsDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) hotelManagementSystemPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void backToWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/EnterWebForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) hotelManagementSystemPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }


}
