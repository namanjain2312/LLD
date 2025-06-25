package MovieTicketBookingSystem;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Show {
    private  String showId;
    private LocalTime startTime;
    private LocalTime endTime;
    private Screen screen;
    private Movie movie;
    private List<Seat> listOfBookedSeats;

    public Show(Movie movie, Screen screen, LocalTime startTime, LocalTime endTime, String showId) {
        this.movie = movie;
        this.screen = screen;
        this.endTime = endTime;
        this.startTime = startTime;
        this.showId = showId;
        listOfBookedSeats = new ArrayList<>();
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public List<Seat> getListOfBookedSeats() {
        return listOfBookedSeats;
    }

    public void setListOfBookedSeats(List<Seat> listOfBookedSeats) {
        this.listOfBookedSeats = listOfBookedSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}
