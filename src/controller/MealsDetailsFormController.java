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

import model.MealsDetails;
import view.tm.MealsDetailsTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class MealsDetailsFormController {
    public AnchorPane mealsDetailsPane;
    public JFXButton btnHome;
    public JFXButton btnSave;
    public JFXTextField txtDate;
    public JFXTextField txtId;
    public JFXTextField txtType;
    public JFXTextField txtCount;
    public JFXTextField txtMeals;
    public JFXTextField txtPrize;
    public JFXTextField txtOffer;
    public JFXTextField txtModify;
    public PasswordField txtPassword;
    public TableView <MealsDetailsTM>tblMealsDetails;
    public TableColumn colDate;
    public TableColumn colId;
    public TableColumn colCount;
    public TableColumn colType;
    public TableColumn colMeals;
    public TableColumn colPrize;
    public TableColumn colOffer;
    public TableColumn colDelete;
    public TableColumn colModify;


    static ArrayList<MealsDetails> mealsList = new ArrayList();


    public void openBackToHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) mealsDetailsPane.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void initialize() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        colMeals.setCellValueFactory(new PropertyValueFactory<>("meals"));
        colPrize.setCellValueFactory(new PropertyValueFactory<>("prize"));
        colOffer.setCellValueFactory(new PropertyValueFactory<>("offer"));
        colModify.setCellValueFactory(new PropertyValueFactory<>("modify"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));



    }
    public void openSaveUpdate(ActionEvent actionEvent) {
        if (btnSave.getText().equalsIgnoreCase("Save")) {
            MealsDetails meals = new MealsDetails(txtDate.getText(),txtId.getId(),txtType.getText(),txtCount.getText(),txtMeals.getText(),txtPrize.getText(),txtOffer.getText(),txtModify.getText());
            txtDate.clear();
            txtId.clear();
            txtType.clear();
            txtCount.clear();
            txtMeals.clear();
            txtPrize.clear();
            txtOffer.clear();
            txtModify.clear();

            if (isExists(meals)) {
                if (MealsDetailsFormController.mealsList.add(meals)) {
                    loadAllMealsDetails();
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Already Exists..", ButtonType.CLOSE).show();
            }
        }else {

        }

    }
    private void loadAllMealsDetails() {
        ObservableList<MealsDetailsTM> tmObservableList = FXCollections.observableArrayList();
        for (MealsDetails temp : mealsList
        ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new MealsDetailsTM(temp.getDate(),temp.getId(),temp.getType(),temp.getCount(),temp.getMeals(),temp.getPrize(),temp.getOffer(),temp.getModify(),btn)
            );
            btn.setOnAction((e) -> {
                ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION
                        , "Are you sure whether you want to delete this Meals?", yes, no);
                alert.setTitle("Confirmation Alert");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no) == yes) {
                    mealsList.remove(temp);
                    loadAllMealsDetails();
                } else {

                }
            });

            tblMealsDetails.setItems(tmObservableList);
        }
    }

    public boolean isExists(MealsDetails details) {
        for (MealsDetails m :  mealsList
        ) {
            if (m.getId().equalsIgnoreCase(details.getId())) {
                return false;
            }
        }
        return true;
    }


    public void moveToId(ActionEvent actionEvent) {
        txtId.requestFocus();
    }

    public void moveToType(ActionEvent actionEvent) {
       txtType.requestFocus();
    }

    public void moveToCount(ActionEvent actionEvent) {
        txtCount.requestFocus();
    }

    public void moveToMeals(ActionEvent actionEvent) {
        txtMeals.requestFocus();
    }

    public void moveToPrize(ActionEvent actionEvent) {
        txtPrize.requestFocus();
    }


    public void moveToOffer(ActionEvent actionEvent) {
            txtOffer.requestFocus();

    }

    public void moveToModify(ActionEvent actionEvent) {
        txtModify.requestFocus();
    }
}
