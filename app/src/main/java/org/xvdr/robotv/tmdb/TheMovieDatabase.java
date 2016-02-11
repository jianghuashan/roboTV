package org.xvdr.robotv.tmdb;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

public class TheMovieDatabase {

    private final static String TAG = "TheMovieDatabase";

    private String mApiKey;
    private String mLanguage;

    public TheMovieDatabase(String apiKey, String language) {
        mApiKey = apiKey;
        mLanguage = language;
    }

    private static String getJsonFromServer(String url) throws IOException {
        BufferedReader inputStream;

        URL jsonUrl = new URL(url);
        URLConnection dc = jsonUrl.openConnection();

        dc.setConnectTimeout(2000);
        dc.setReadTimeout(2000);

        inputStream = new BufferedReader(new InputStreamReader(dc.getInputStream()));

        String result = inputStream.readLine();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    protected JSONArray search(String section, String title) throws IOException, JSONException {
        return search(section, title, 0, "");
    }

    protected JSONArray search(String section, String title, int year, String dateProperty) throws IOException, JSONException {
        String request;

        request = "http://api.themoviedb.org/3/search/" + section + "?api_key=" + mApiKey + "&query=" + URLEncoder.encode(title);

        if (!mLanguage.isEmpty()) {
            request += "&language=" + mLanguage;
        }

        JSONObject o = new JSONObject(getJsonFromServer(request));
        JSONArray results = o.optJSONArray("results");

        // filter entries (search for year)
        if(year > 0 && !dateProperty.isEmpty()) {
            JSONArray a = new JSONArray();

            for(int i = 0; i < results.length(); i++) {
                JSONObject item = results.optJSONObject(i);

                if (item == null) {
                    continue;
                }

                String date = item.optString(dateProperty);
                if(date == null || date.length() < 4) {
                    continue;
                }

                int entryYear = Integer.parseInt(date.substring(0, 4));

                // release year differ often
                if(year == entryYear || year == entryYear -1 ) {
                    a.put(item);
                }
            }

            if(a.length() > 0) {
                return a;
            }
        }

        return results;
    }

    public JSONArray searchMovie(String title) throws IOException, JSONException {
        return searchMovie(title, 0);
    }

    public JSONArray searchMovie(String title, int releaseYear) throws IOException, JSONException {
        return search("movie", title, releaseYear, "release_date");
    }

    public JSONArray searchTv(String title) throws IOException, JSONException {
        return search("tv", title);
    }

    public JSONArray searchTv(String title, int firstAirYear) throws IOException, JSONException {
        return search("tv", title, firstAirYear, "first_air_date");
    }

    protected String getUrl(JSONArray results, String property) {
        if(results == null) {
            return "";
        }

        String path = "";
        for(int i = 0; i < results.length(); i++) {
            JSONObject item = results.optJSONObject(i);

            if (item == null) {
                continue;
            }

            path = item.optString(property);
            Log.d(TAG, property + ": " +path);

            if(path != null && !path.equals("null")) {
                break;
            }
        }

        if(path == null || path.isEmpty() || path.equals("null")) {
            return "";
        }

        return "http://image.tmdb.org/t/p/w600" + path;
    }

    public String getPosterUrl(JSONArray o) {
        return getUrl(o, "poster_path");
    }

    public String getBackgroundUrl(JSONArray o) {
        return getUrl(o, "backdrop_path");
    }

}
