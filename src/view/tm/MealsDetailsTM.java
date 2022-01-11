package view.tm;

import javafx.scene.control.Button;

public class MealsDetailsTM {
    private String date;
    private String id;
    private String type;
    private String count;
    private String meals;
    private String prize;
    private String offer;
    private String modify;
    private Button btn;

    public MealsDetailsTM() {
    }

    public MealsDetailsTM(final String date, final String id, final String type, final String count, final String meals, final String prize, final String offer, final String modify, final Button btn) {
        this.setDate(date);
        this.setId(id);
        this.setType(type);
        this.setCount(count);
        this.setMeals(meals);
        this.setPrize(prize);
        this.setOffer(offer);
        this.setModify(modify);
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
