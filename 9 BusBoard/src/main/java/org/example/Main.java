package org.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Main {
    public static void main(String[] args) {

        //Get user input for postcode

        //Get the lat and long info from postcode
        String response = getPostCodeInfo("HA96FB");
        ArrayList<String> latlong = deserializeLatitudeAndLongitude(response);

        String latitude = latlong.get(0);
        String longtitude = latlong.get(1);

        //Use lat and long to run tfl api command to find bus stops
        // TFLAPI : Gets a list of StopPoints within {radius} by the specified criteria
        // - the criteria is longitude and latitude
        // Find two nearest bus stop
        JSONArray jsonArray = getStopPointIDS(latitude, longtitude);
                System.out.println(jsonArray);
        // get 5 of the next arrivals at that bus stop for each bus stop

        // display this info to the user
    }

    public static ArrayList<String> deserializeLatitudeAndLongitude(String string) {
        try {
            JSONObject object = new JSONObject(string);
            JSONObject result = object.getJSONObject("result");
            String longitude = result.getBigDecimal("longitude").toString();
            String latitude = result.getBigDecimal("latitude").toString();
            ArrayList<String> latlong = new ArrayList<>();
            latlong.add(latitude);
            latlong.add(longitude);
            return latlong;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getTflInfo(String latitude, String longtitude) {
        String url = "https://api.tfl.gov.uk/StopPoint/?lat=" + latitude + "&lon=" + longtitude + "&stopTypes=NaptanOnstreetBusCoachStopPair&radius=200";
        //https://api.tfl.gov.uk/StopPoint/?lat=51.544624&lon=-0.273983&stopTypes=naptanbuscoachstation&radius=500
        String response = "";
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .join();

        } catch (Exception e) {
            System.out.println("Failed -- " + e);
        }
        return response;

    }

    public static String getPostCodeInfo(String PostCode) {
        //Get Postcode information
        String url = "http://api.postcodes.io/postcodes/" + PostCode;
        String response = "";
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .join();
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("Failed -- " + e);
        }

        return response;
    }

    public static JSONArray getStopPointIDS(String latitude, String longtitude)
    {
        JSONObject obj = new JSONObject(getTflInfo(latitude,longtitude));
        //System.out.println(obj.get("stopPoints"));
        JSONArray jsonArray = obj.getJSONArray("stopPoints");

        JSONArray stopPointsIds = new JSONArray();
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject o = jsonArray.getJSONObject(i);
            stopPointsIds.put(o.get("naptanId"));
        }
        return stopPointsIds;
    }

    public static void listNextArrivalsAtStopPoints(JSONArray jsonArray)
    {
        //for each element in jsonarray of stoppointsids find the next arrivals for each of the stoppoints
    }
}