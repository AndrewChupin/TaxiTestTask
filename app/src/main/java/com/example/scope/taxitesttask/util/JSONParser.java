package com.example.scope.taxitesttask.util;

import android.os.AsyncTask;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by scope on 06.04.16.
 */
public class JSONParser extends AsyncTask<Void, Void, Void> {

    private CallBackWeb callBackWeb;
    private LatLng latLng;
    private String addressName;
    private String vicinityName;

    public JSONParser(CallBackWeb callBackWeb, LatLng latLng) {
        this.callBackWeb = callBackWeb;
        this.latLng = latLng;
    }

    @Override
    protected Void doInBackground(Void... params) {
        if (latLng != null) {
            getStringFromLocation(latLng);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        /** init method in MainActivity*/
        callBackWeb.getStringAddress(addressName, vicinityName);
        super.onPostExecute(result);
    }

    /**
     * Get result parse
     */
    public void getStringFromLocation(LatLng latLng) {
        try {
            String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + URLEncoder.encode(latLng.latitude + "," + latLng.longitude, "UTF-8")
                    + "&language=ru&radius=100&key=AIzaSyDyc4K1EdYBZ09i3ONpADam4G5If_fuFw4";

            JSONObject jsonObject = new JSONObject(performGetCall(URL));
            JSONArray results = jsonObject.getJSONArray("results");

            if (results.length() > 0) {
                addressName = results.getJSONObject(1).getString("name");
                vicinityName = results.getJSONObject(1).getString("vicinity");

            }

        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    /**
     * Parse JSON document of url
     */
    public String performGetCall(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            System.out.println("\nSending 'GET' request to URL : " + url);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            return response.toString(); //this is your response
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }


}
