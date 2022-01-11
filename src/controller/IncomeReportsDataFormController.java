package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import view.tm.IncomeReportFormTM;

public class IncomeReportsDataFormController {
    public JFXTextField txtId;
    public JFXTextField txtRoom;
    public JFXTextField txtMeals;
    public JFXTextField txtEmail;

    public void setData(IncomeReportFormTM tm){
        txtId.setText(tm.getId());
        System.out.println(tm);
        txtMeals.setText(tm.getMeals());
        System.out.println(tm);
        txtRoom.setText(tm.getRoom());
        System.out.println(tm);
        txtEmail.setText(tm.getEmail());
        System.out.println(tm);
    }


    public void moveToRoom(ActionEvent actionEvent) {
        txtRoom.requestFocus();
    }

    public void moveToEmail(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }
}
