package view.tm;

import javafx.scene.control.Button;

public class IncomeReportFormTM {
    private String date;
    private String id;
    private String meals;
    private String room;
    private String email;
    private String send;
    private String month;
    private String in;
    private String out;
    private String annually;
    private Button btn;

    public IncomeReportFormTM() {
    }

    public IncomeReportFormTM(final String date, final String id, final String meals, final String room, final String email, final String send, final String month, final String in, final String out, final String annually, final Button btn) {
        this.setDate(date);
        this.setId(id);
        this.setMeals(meals);
        this.setRoom(room);
        this.setEmail(email);
        this.setSend(send);
        this.setMonth(month);
        this.setIn(in);
        this.setOut(out);
        this.setAnnually(annually);
        this.setBtn(btn);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getAnnually() {
        return annually;
    }

    public void setAnnually(String annually) {
        this.annually = annually;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
