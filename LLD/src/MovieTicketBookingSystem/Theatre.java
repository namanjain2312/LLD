package MovieTicketBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private String theatreId;
    private String theatreName;
    private List<Show> listOfShowsInATheatre;
    private List<Screen> listOfScreenInTheatre;
    private String address;

    public Theatre(String theatreId,String theatreName,String address)
    {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.address = address;
        listOfShowsInATheatre = new ArrayList<>();
        listOfScreenInTheatre = new ArrayList<>();
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public List<Show> getListOfShowsInATheatre() {
        return listOfShowsInATheatre;
    }

    public void setListOfShowsInATheatre(List<Show> listOfShowsInATheatre) {
        this.listOfShowsInATheatre = listOfShowsInATheatre;
    }

    public List<Screen> getListOfScreenInTheatre() {
        return listOfScreenInTheatre;
    }

    public void setListOfScreenInTheatre(List<Screen> listOfScreenInTheatre) {
        this.listOfScreenInTheatre = listOfScreenInTheatre;
    }
}
