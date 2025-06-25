package MovieTicketBookingSystem;

import java.time.LocalTime;
import java.util.*;

public class BookMyShow {

    public static Map<City, List<Theatre>> cityWiseTheatre = new HashMap<>();

    public List<Seat> getListOfNewSeats()
    {
        List<Seat> newSeatList = new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            newSeatList.add(new Seat(String.valueOf(i+1),false,SeatType.Normal));
        }
        return newSeatList;
    }

    public void preSettingData()
    {
        City jaipurCity = new City("CityId1","Jaipur");
        City mumbaiCity = new City("CityId2","Mumbai");

        Movie avengers = new Movie("Avenger","MovieId1");
        Movie don = new Movie("Don","MovieId2");

        Theatre golcha = new Theatre("TheatreId1","Golcha","Jaipur");
        Theatre ramMandir = new Theatre("TheatreId2","RamMandir","EndJaipur");
        Theatre bombay = new Theatre("TheatreId3","Bombay","CentralBombay");

        Screen screen1 = new Screen(getListOfNewSeats(),"ScreenId1",golcha);
        Screen screen2 = new Screen(getListOfNewSeats(),"ScreenId2",ramMandir);
        Screen screen3 = new Screen(getListOfNewSeats(),"ScreenId3",bombay);

        Show show1 = new Show(avengers,screen1,LocalTime.NOON,LocalTime.NOON.plusHours(2),"ShowId1");
        Show show2 = new Show(avengers,screen2,LocalTime.NOON.plusHours(9),LocalTime.NOON.plusHours(11),"ShowId2");
        Show show3 = new Show(don,screen3,LocalTime.NOON.plusHours(9),LocalTime.NOON.plusHours(11),"ShowId3");

        golcha.setListOfScreenInTheatre(new ArrayList<>(Arrays.asList(screen1)));
        ramMandir.setListOfScreenInTheatre(new ArrayList<>(Arrays.asList(screen2)));
        bombay.setListOfScreenInTheatre(new ArrayList<>(Arrays.asList(screen3)));

        golcha.setListOfShowsInATheatre(new ArrayList<>(Arrays.asList(show1)));
        ramMandir.setListOfShowsInATheatre(new ArrayList<>(Arrays.asList(show2)));
        bombay.setListOfShowsInATheatre(new ArrayList<>(Arrays.asList(show3)));

        cityWiseTheatre.put(jaipurCity,new ArrayList<>(
            Arrays.asList(golcha,ramMandir)));
        cityWiseTheatre.put(mumbaiCity,new ArrayList<>(Arrays.asList(bombay)));

    }


    public void printCity()
    {
        for (Map.Entry<City, List<Theatre>> entry : cityWiseTheatre.entrySet())
        {
            System.out.println(entry.getKey().getCityName());
        }
    }

    public void getAllShowsForAMovie(String movieId,String cityId)
    {
        for(Map.Entry<City,List<Theatre>>entry : cityWiseTheatre.entrySet())
        {
            if(entry.getKey().getCityId().equals(cityId))
            {
                for (Theatre theatre : entry.getValue())
                {
                    for(Show show : theatre.getListOfShowsInATheatre())
                    {
                        if(show.getMovie().getMovieId().equals(movieId))
                        {
                            System.out.println("Show in " + theatre.getTheatreId() +
                                    " at " + show.getStartTime() + " And Show Id is " + show.getShowId());
                        }

                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        BookMyShow bookMyShow = new BookMyShow();
        MovieController movieController = new MovieController();
        bookMyShow.preSettingData();

        System.out.println("List Of Cities And Theatres Are : " );
        bookMyShow.printCity();
        bookMyShow.getAllShowsForAMovie("MovieId1","CityId1");
        movieController.bookMovie("CityId1","ShowId1","1");

    }

}
