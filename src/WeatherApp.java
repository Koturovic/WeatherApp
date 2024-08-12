// retreive weather data from API -backend logic
// display this data to user
// latest weather

import org.json.simple.*;
import netscape.javascript.JSObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {
    public static JSONObject getWeatherData(String locName){
        //get location cordinates using api geolocation
        JSONArray locationData = getLocationData(locName);
        return null;
    }
    public static JSONArray getLocationData(String location){
        location = location.replaceAll(" ", "+");
        // build api url with loc par
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                location + "&count=10&language=en&format=json";


        try{
            // call a api and get responce
            HttpURLConnection conn = fetchApiResponse(urlString);

            // check responce status
            // 200 mean OK!
            if(conn.getResponseCode()!=200){
                System.out.println("Could not  connect to API");
                return null;

            }else {
                // store the API results
                StringBuilder resultJson = new StringBuilder();
                Scanner s = new Scanner(conn.getInputStream());
                // read and store into out sb:
                while (s.hasNext()){
                    resultJson.append(s.nextLine());
                }
                s.close();
                conn.disconnect();

                //parse the json string into json obj
                JSONParser parser = new JSONParser();
                JSONObject resultJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                // get the list of location
                JSONArray locationData =(JSONArray) resultJsonObj.get("result");
                return locationData;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static HttpURLConnection fetchApiResponse(String url){

        try {
            // try to get connection:
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();

            //set request method to get
            conn.setRequestMethod("GET");
            //connect to our api:
            conn.connect();
            return conn;

        }catch (IOException e){
            e.printStackTrace();
        }
        // could not make conn:
        return null;
    }


}
