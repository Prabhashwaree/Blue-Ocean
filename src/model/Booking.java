package model;

public class Booking extends Room {
     private String dates;
     private String id;
     private String names;
     private String numbers;
     private String address;
     private String roomNo;
     private String emails;
     private String available;

    public Booking(String text, String txtCustomerIdText, String txtRoomTypeText, String txtRoomCountText, String txtAddNewRoomText, String txtRoomPrizeText, String txtRoomOfferText) {
    }

    public Booking(final String dates, final String id, final String names, final String numbers, final String address, final String roomNo, final String emails, final String available) {
        this.setDates(dates);
        this.setId(id);
        this.setNames(names);
        this.setNumbers(numbers);
        this.setAddress(address);
        this.setRoomNo(roomNo);
        this.setEmails(emails);
        this.setAvailable(available);
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
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

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
