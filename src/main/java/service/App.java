package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

    private static final String CITY_ID = "709930"; // Dnipro
    private static final Gson gson = new GsonBuilder().create();

    public static void main(String[] args) {
       // String weatherJson = Request.getRawWeather();
       // ResponseWeather now = gson.fromJson(weatherJson, ResponseWeather.class);

       // System.out.println(now.getName());

        /*
        try (Reader reader = new InputStreamReader(App.class.getResourceAsStream("/weather.json"))) {
            ResponseWeather weather = gson.fromJson(reader, ResponseWeather.class);
            System.out.println(weather);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }
}
