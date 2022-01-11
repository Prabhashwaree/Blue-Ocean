package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Booking;
import view.tm.BookingTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class BookingDetailsFormController {
    public AnchorPane bookingDetailsPane;
    public Label labelBookingDetails;
    public JFXButton btnBack;
    public JFXButton btnSave;
    public JFXTextField txtCustomerId;
    public JFXTextField txtCustomerNumber;
    public JFXTextField txtCustomerAddress;
    public JFXTextField txtRoomNumber;
    public JFXTextField txtDate;
    public JFXTextField txtCustomerName;
    public JFXTextField txtEmail;
    public JFXTextField txtRoomAvailable;
    public TableView <BookingTM>tblBooking;
    public TableColumn colDate;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colNumber;
    public TableColumn colAddress;
    public TableColumn colRoomNo;
    public TableColumn colEmail;
    public TableColumn colAvailable;
    public TableColumn colDelete;
    public TextField txtSearch;

    static ArrayList<Booking> bookingsList = new ArrayList();

    public void initialize() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        txtSearch.textProperty().addListener((observable, oldValue, txt) -> {
            for (Booking b : bookingsList
            ) {
                if (b.getDates().contains(txt)
                        ||
                        b.getId().contains(txt)
                        ||
                        b.getNames().contains(txt)
                        ||
                        b.getNumbers().contains(txt)
                        ||
                        b.getAddress().contains(txt)
                        ||
                        b.getRoomNo().contains(txt)

                        ||
                        b.getEmails().contains(txt)

                        ||
                        b.getAvailable().contains(txt)
                ) {
                    System.out.println(b);
                }
            }

        });
    }

    public void openBackToWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) bookingDetailsPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void saveUpdate(ActionEvent actionEvent) {
        if (btnSave.getText().equalsIgnoreCase("Save")) {
            Booking booking = new Booking(txtDate.getText(),txtCustomerId.getText(),txtCustomerName.getText(),txtCustomerNumber.getText(),txtCustomerAddress.getText(), txtRoomNumber.getText(),txtEmail.getText(),txtRoomAvailable.getText());
            txtCustomerId.clear();
            txtCustomerNumber.clear();
            txtCustomerAddress.clear();
            txtRoomNumber.clear();
            txtDate.clear();
            txtCustomerName.clear();
            txtEmail.clear();
            txtRoomAvailable.clear();

            if (isExists(booking)) {
                if (BookingDetailsFormController.bookingsList.add(booking)) {
                    loadAllBookings();
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Already Exists..", ButtonType.CLOSE).show();
            }
        } else {

        }

    }
    private void loadAllBookings() {
        ObservableList<BookingTM> tmObservableList = FXCollections.observableArrayList();
        for (Booking temp : bookingsList
        ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new BookingTM(temp.getDates(), temp.getId(), temp.getNames(), temp.getNumbers(),temp.getAddress(),temp.getRoomNo(),temp.getEmails(),temp.getAvailable(), btn)
            );
            btn.setOnAction((e) -> {
                ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION
                        , "Are you sure whether you want to delete this Customer?", yes, no);
                alert.setTitle("Confirmation Alert");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no) == yes) {
                    bookingsList.remove(temp);
                    loadAllBookings();
                } else {

                }
            });

            tblBooking.setItems(tmObservableList);
        }
    }
    public boolean isExists(Booking booking) {
        for (Booking b : bookingsList
        ) {
            if (b.getId().equalsIgnoreCase(booking.getId())) {
                return false;
            }
        }
        return true;
    }



    public void moveToName(ActionEvent actionEvent) {
        txtCustomerName.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtCustomerAddress.requestFocus();
    }

    public void moveToRoomNumber(ActionEvent actionEvent) {
        txtRoomNumber.requestFocus();
    }

    public void moveToEmail(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void moveToId(ActionEvent actionEvent) {
        txtCustomerId.requestFocus();
    }

    public void moveToNumber(ActionEvent actionEvent) {
        txtCustomerNumber.requestFocus();
    }

    public void openTextSearch(ActionEvent actionEvent) {
    }

    public void moveToAvailable(ActionEvent actionEvent) {
        txtRoomAvailable.requestFocus();
    }

}
