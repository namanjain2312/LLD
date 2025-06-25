package MovieTicketBookingSystem;

import java.util.List;

public class Screen {
    private String screenId;
    private List<Seat> seatList;
    private Theatre theatre;

    public Screen(List<Seat> seatList, String screenId,Theatre theatre) {
        this.seatList = seatList;
        this.screenId = screenId;
        this.theatre = theatre;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
