package com.example.nguyen.weaver;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Nguyen on 27-Apr-16.
 */
public class Wheat {
    private OpenWeatherMap owm;

    public Wheat() {
        this.owm = new OpenWeatherMap("");
        this.owm.setApiKey("06d02908ccc55248a13798d40258902e");
    }

    /**
     * this method accepts an city name and look for its current temperature on the open weather api
     * @param city  a string contains name of a real city
     * @return temperature in celsius
     * @throws JSONException in case the weather api not responding
     * @throws IOException
     */
    public int getTemp(String city) throws JSONException, IOException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);
        float t = cwd.getMainInstance().getTemperature();
        t = (t-32)*5/9;
        int temp = Math.round(t);
        return temp;
    }

    /**
     * this method indicates if it is raining in th given city or not
     * @param city a string contains name of a real city
     * @return true if it is raining, false if it is not
     * @throws JSONException in case the weather api doe not respond
     * @throws IOException
     */
    public boolean isRaining(String city) throws JSONException, IOException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);
        if(cwd.getWeatherInstance(0).getWeatherDescription().contains("rain"))
            return true;
        else
            return false;
    }
}
