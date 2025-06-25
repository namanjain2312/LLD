package MovieTicketBookingSystem;

public class Seat {

    private String seatId;
    private boolean isOccupied;
    private SeatType seatType;

    public Seat(String seatId, boolean isOccupied,SeatType seatType) {
        this.seatId = seatId;
        this.isOccupied = isOccupied;
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
