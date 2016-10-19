package com.example.nguyen.weaver;

/**
 * Created by Nguyen on 27-Apr-16.
 */
public class Clothes {
    private String season;
    public Clothes()
    {
        season = "normal";
    }

    /**
     * return a string which indicate the temperatur for human
     * @param temp tempertature in celius
     * @return a string of either cold, normal or hot
     */
    public String getAdvise(int temp)
    {
        if(temp<6)
        {
            return "cold";
        }
        else if(temp>6 && temp<20)
        {
            return "normal";
        }
        return "hot";
    }
}
