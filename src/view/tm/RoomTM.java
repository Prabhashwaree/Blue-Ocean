package view.tm;

import javafx.scene.control.Button;

public class RoomTM {
    private String date;
    private String id;
    private String type;
    private String count;
    private String room;
    private String prize;
    private String offer;
    private Button btn;

    public RoomTM() {
    }

    public RoomTM(final String date, final String id, final String type, final String count, final String room, final String prize, final String offer, final Button btn) {
        this.setDate(date);
        this.setId(id);
        this.setType(type);
        this.setCount(count);
        this.setRoom(room);
        this.setPrize(prize);
        this.setOffer(offer);
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
