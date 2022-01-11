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
import model.MealsDetails;
import model.Room;
import view.tm.RoomTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class RoomDetailsFormController {
    public AnchorPane roomsDetailsPane;
    public Label labelRoomDetails;
    public JFXButton btnHome;
    public JFXButton btnSave;
    public JFXTextField txtCustomerId;
    public JFXTextField txtRoomPrize;
    public JFXTextField txtAddNewRoom;
    public JFXTextField txtRoomType;
    public JFXTextField txtRoomCount;
    public JFXTextField txtRoomOffer;
    public TextField txtEnterPassword;
    public JFXTextField txtDate;
    public TableView <RoomTM>tblRoomDetails;
    public TableColumn colDate;
    public TableColumn colId;
    public TableColumn colType;
    public TableColumn colCount;
    public TableColumn colRoom;
    public TableColumn colPrize;
    public TableColumn colOffer;
    public TableColumn colDelete;

    static ArrayList<Room> roomList = new ArrayList();


    public void backToHomeWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomsDetailsPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }
    public void initialize() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
        colPrize.setCellValueFactory(new PropertyValueFactory<>("prize"));
        colOffer.setCellValueFactory(new PropertyValueFactory<>("offer"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    public void saveUpdate(ActionEvent actionEvent) {
        if (btnSave.getText().equalsIgnoreCase("Save")) {
           Room room = new Room(txtDate.getText(),txtCustomerId.getText(),txtRoomType.getText(),txtRoomCount.getText(),txtAddNewRoom.getText(), txtRoomPrize.getText(),txtRoomOffer.getText());
            txtDate.clear();
            txtCustomerId.clear();
            txtRoomType.clear();
            txtRoomCount.clear();
            txtDate.clear();
            txtAddNewRoom.clear();
            txtRoomPrize.clear();
            txtRoomOffer.clear();

            if (isExists(room)) {
                if (RoomDetailsFormController.roomList.add(room)) {
                    loadAllRoom();
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
    private void loadAllRoom() {
        ObservableList<RoomTM> tmObservableList = FXCollections.observableArrayList();
        for (Room temp : roomList
        ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new RoomTM(temp.getDate(), temp.getId(), temp.getType(), temp.getCount(),temp.getRoom(),temp.getPrize(),temp.getOffer(),btn)
            );
            btn.setOnAction((e) -> {
                ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION
                        , "Are you sure whether you want to delete this Room?", yes, no);
                alert.setTitle("Confirmation Alert");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no) == yes) {
                    roomList.remove(temp);
                    loadAllRoom();
                } else {

                }
            });

            tblRoomDetails.setItems(tmObservableList);
        }
    }

    public boolean isExists(Room room) {
        for (Room r : roomList
        ) {
            if (r.getId().equalsIgnoreCase(room.getId())) {
                return false;
            }
        }
        return true;
    }


    public void moveToRoomsType(ActionEvent actionEvent) {
        txtRoomType.requestFocus();
    }

    public void moveRoomOffer(ActionEvent actionEvent) {
        txtRoomOffer.requestFocus();
    }

    public void moveRoomPrize(ActionEvent actionEvent) {
        txtRoomPrize.requestFocus();
    }

    public void moveToRoomCount(ActionEvent actionEvent) {
        txtRoomCount.requestFocus();
    }

    public void moveToAddNewRoom(ActionEvent actionEvent) {
        txtAddNewRoom.requestFocus();
    }
    public void moveToCustomerId(ActionEvent actionEvent) {
        txtCustomerId.requestFocus();
    }

    public void methodEnterPassword(ActionEvent actionEvent) {
    }


}