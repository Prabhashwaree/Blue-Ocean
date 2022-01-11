package view.tm;

import javafx.scene.control.Button;

public class BookingTM {
    private String date;
    private String id;
    private String name;
    private String number;
    private String address;
    private String roomNo;
    private String email;
    private String available;
    private Button btn;


    public BookingTM(String date, String customerId, String roomType, String roomCount, String addNewRoom, String roomPrize, String roomOffer, Button btn) {
    }

    public BookingTM(final String date, final String id, final String name, final String number, final String address, final String roomNo, final String email, final String available, final Button btn) {
        this.setDate(date);
        this.setId(id);
        this.setName(name);
        this.setNumber(number);
        this.setAddress(address);
        this.setRoomNo(roomNo);
        this.setEmail(email);
        this.setAvailable(available);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
