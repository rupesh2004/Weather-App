package com.example.weather_app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {
    String mTemperature,micon,mcity,mweathertype;
    int mCondition;


    public static weatherData fromJson(JSONObject jsonObject){
        try{
            weatherData weatherD= new weatherData();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mweathertype=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.micon=updateWeatherIcon(weatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundValue=(int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundValue);
            return  weatherD;




        }catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }



    private static String updateWeatherIcon(int condition) {
        if(condition>=0 && condition<=300){
            return "thunderstorm";
        }
        else if(condition>=300 && condition<=500){
            return "lightrain";
        }
        else if(condition>=500 && condition<=600){
            return "shower";
        }
        else if(condition>=600 && condition<=700){
            return "snow";
        }
        else if(condition>=701 && condition<=771){
            return "fog";
        }
        else if(condition>=701 && condition<=771){
            return "overcast";
        }
        else if(condition==800){
            return "sunny";
        }
        else if(condition>=801 && condition<=804){
            return "cloudy";
        }
        else if(condition>=900 && condition<=902){
            return "fog";
        }
        if(condition==903){
            return "snow";
        }
        if(condition==904){
            return "sunny";
        }
        if(condition>=905 && condition<=1000){
            return "thunderstorm";
        }
        return "dunno";
    }


    public String getmTemperature(){
        return mTemperature+"°C";
    }
    public String getMicon(){
        return micon;
    }
    public String getMcity(){
        return mcity;
    }
    public String getMweathertype(){
        return mweathertype;
    }
}
