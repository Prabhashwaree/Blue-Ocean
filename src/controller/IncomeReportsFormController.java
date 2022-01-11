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

import model.IncomeReport;

import view.tm.IncomeReportFormTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class IncomeReportsFormController {
    public AnchorPane incomeReportsPane;
    public JFXTextField txtDate;
    public JFXTextField txtId;
    public JFXTextField txtMeals;
    public JFXTextField txtRoom;
    public JFXTextField txtEmail;
    public JFXTextField txtSend;
    public JFXTextField txtMonth;
    public TextField txtDay;
    public TextField txtPassword;
    public JFXTextField txtOut;
    public JFXTextField txtIn;
    public JFXTextField txtAnnually;
    public TableView <IncomeReportFormTM>tblIncomeReport;
    public TableColumn colDate;
    public TableColumn colId;
    public TableColumn colMeals;
    public TableColumn colRoom;
    public TableColumn colEmail;
    public TableColumn colSend;
    public TableColumn colMonth;
    public TableColumn colDelete;
    public TableColumn colIn;
    public TableColumn colOut;
    public TableColumn colAnnually;
    public JFXButton btnSave;
    public JFXButton btnBack;

    static ArrayList<IncomeReport> incomeList = new ArrayList();
    public TextField txtSearch;


    public void initialize() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMeals.setCellValueFactory(new PropertyValueFactory<>("meals"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colSend.setCellValueFactory(new PropertyValueFactory<>("send"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colIn.setCellValueFactory(new PropertyValueFactory<>("in"));
        colOut.setCellValueFactory(new PropertyValueFactory<>("out"));
        colAnnually.setCellValueFactory(new PropertyValueFactory<>("annually"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        txtSearch.textProperty().addListener((observable, oldValue, txt) -> {
            for (IncomeReport i : incomeList
            ) {
                if (i.getDate().contains(txt)
                        ||
                        i.getId().contains(txt)
                        ||
                        i.getMeals().contains(txt)
                        ||
                        i.getRoom().contains(txt)
                        ||
                        i.getEmail().contains(txt)
                        ||
                        i.getSend().contains(txt)
                        ||
                        i.getMonth().contains(txt)
                        ||
                        i.getIn().contains(txt)
                        ||
                        i.getOut().contains(txt)
                        ||
                        i.getAnnually().contains(txt)


                ) {
                    System.out.println(i);
                }
            }

        });
        tblIncomeReport.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                loadIncomeReportsData(newValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private void loadIncomeReportsData(IncomeReportFormTM tm) throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("../view/IncomeReportsDataForm.fxml"));
        Parent parent = loader.load();
        IncomeReportsDataFormController controller = loader.getController();
        controller.setData(tm);
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
    public void saveUpdate(ActionEvent actionEvent) {
        if (btnSave.getText().equalsIgnoreCase("Save")) {
            IncomeReport report = new IncomeReport(txtDate.getText(),txtId.getText(),txtMeals.getText(),txtRoom.getText(),txtEmail.getText(), txtSend.getText(),txtMonth.getText(), txtIn.getText(), txtOut.getText(), txtAnnually.getText());
            txtDate.clear();
            txtId.clear();
            txtMeals.clear();
            txtRoom.clear();
            txtEmail.clear();
            txtDate.clear();
            txtSend.clear();
            txtMonth.clear();
            txtIn.clear();
            txtOut.clear();
            txtAnnually.clear();


            if (isExists(report)) {
                if (IncomeReportsFormController.incomeList.add(report)) {
                    loadAllIncomeReport();
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
    private void loadAllIncomeReport() {
        ObservableList<IncomeReportFormTM> tmObservableList = FXCollections.observableArrayList();
        for (IncomeReport temp : incomeList
        ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new IncomeReportFormTM(temp.getDate(), temp.getId(), temp.getMeals(), temp.getRoom(),temp.getEmail(),temp.getSend(),temp.getMonth(), temp.getIn(),temp.getOut(),temp.getAnnually(),btn)
            );
            btn.setOnAction((e) -> {
                ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION
                        , "Are you sure whether you want to delete this Report?", yes, no);
                alert.setTitle("Confirmation Alert");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no) == yes) {
                    incomeList.remove(temp);
                    loadAllIncomeReport();
                } else {

                }
            });

            tblIncomeReport.setItems(tmObservableList);
        }
    }

    public boolean isExists(IncomeReport booking) {
        for (IncomeReport b : incomeList
        ) {
            if (b.getId().equalsIgnoreCase(booking.getId())) {
                return false;
            }
        }
        return true;
    }

    public void moveToId(ActionEvent actionEvent) {
        txtId.requestFocus();
    }

    public void moveToMeals(ActionEvent actionEvent) {
       txtMeals.requestFocus();
    }

    public void moveToRoom(ActionEvent actionEvent) {
        txtRoom.requestFocus();
    }

    public void moveToEmail(ActionEvent actionEvent) {
       txtEmail.requestFocus();
    }

    public void moveToSendOrNot(ActionEvent actionEvent) {
       txtSend.requestFocus();
    }

    public void moveToMonthlyPayment(ActionEvent actionEvent) {
        txtMonth.requestFocus();

    }

    public void moveToPassword(ActionEvent actionEvent) {
       txtPassword.requestFocus();

    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) incomeReportsPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }


    public void moveToIn(ActionEvent actionEvent) {
        txtIn.requestFocus();
    }

    public void moveToAnnually(ActionEvent actionEvent) {
        txtAnnually.requestFocus();
    }

    public void moveToOut(ActionEvent actionEvent) {
        txtOut.requestFocus();
    }
}
