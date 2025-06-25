package MovieTicketBookingSystem;

import java.util.List;
import java.util.Map;

public class City {
    private  String cityName;
    private String cityId;

    public City(String cityId,String cityName)
    {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

}
