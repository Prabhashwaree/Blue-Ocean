package model;

public class Room {
    private String date;
    private String id;
    private String type;
    private String count;
    private String room;
    private String prize;
    private String offer;

    public Room() {
    }

    public Room(final String date, final String id, final String type, final String count, final String room, final String prize, final String offer) {
        this.date = date;
        this.id = id;
        this.type = type;
        this.count = count;
        this.room = room;
        this.prize = prize;
        this.offer = offer;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getCount() {
        return this.count;
    }

    public String getRoom() {
        return this.room;
    }

    public String getPrize() {
        return this.prize;
    }

    public String getOffer() {
        return this.offer;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setCount(final String count) {
        this.count = count;
    }

    public void setRoom(final String room) {
        this.room = room;
    }

    public void setPrize(final String prize) {
        this.prize = prize;
    }

    public void setOffer(final String offer) {
        this.offer = offer;
    }
}
