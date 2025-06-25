package MovieTicketBookingSystem;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static MovieTicketBookingSystem.BookMyShow.cityWiseTheatre;

public class MovieController {

    public boolean bookMovie(String cityId,String showId,String seatIdToBook)
    {
        for(Map.Entry<City, List<Theatre>> entry : cityWiseTheatre.entrySet())
        {
            if(entry.getKey().getCityId().equals(cityId))
            {
                for(Theatre theatre : entry.getValue())
                {
                    for(Show show : theatre.getListOfShowsInATheatre())
                    {
                        if(show.getShowId().equals(showId))
                        {
                            if(show.getListOfBookedSeats()==null)
                                show.setListOfBookedSeats(new ArrayList<>());

                            int maxOccupancy = show.getScreen().getSeatList().size();
                            if(show.getListOfBookedSeats().size()==maxOccupancy) {
                                System.out.println("Show is fulled , try booking another show");
                                return  false;
                            }
                            else
                            {
                                if(show.getListOfBookedSeats().contains(seatIdToBook))
                                {
                                    System.out.println(seatIdToBook + " is already booked");
                                    return false;
                                }
                                else {
                                    for(Seat seat : show.getScreen().getSeatList())
                                    {
                                        if(seat.getSeatId().equals(seatIdToBook))
                                        {
                                            synchronized (seat)
                                            {
                                                show.getListOfBookedSeats().add(seat);
                                                System.out.println("Seat is been booked succesfully");
                                                return true;
                                            }
                                        }
                                    }
                                }


                            }

                        }
                    }
                }
            }
        }
        return false;
    }



}
