package com.movies.movieapp;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class MovieApi {
    protected String buildMovieUrl(String movieName, String type) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("www.omdbapi.com")
                .appendPath("")
                .appendQueryParameter(type, movieName)
                .appendQueryParameter("apikey", "4f4704f5");
        String myUrl = builder.build().toString();
        Log.d(TAG, "BuildMovieUrl: " + myUrl);
        return myUrl;
    }

    public String title_json_data(String response) {
        JSONObject jsonResponse = null;
        StringBuilder finalViewResponse = new StringBuilder();
        try {
            jsonResponse = new JSONObject(response);
            if (jsonResponse.has("Error")) {
                String error = jsonResponse.getString("Error");
                finalViewResponse.append(error).append("\n");
            }
            else{
                finalViewResponse.append("\n");
                String title = jsonResponse.getString("Title");
                finalViewResponse.append("Title: ").append(title).append("\n");
                finalViewResponse.append("Year: ").append(jsonResponse.getString("Year")).append("\n");
                finalViewResponse.append("Rated: ").append(jsonResponse.getString("Rated")).append("\n");
                finalViewResponse.append("Released: ").append(jsonResponse.getString("Released")).append("\n");
                finalViewResponse.append("Runtime: ").append(jsonResponse.getString("Runtime")).append("\n");
                finalViewResponse.append("Genre: ").append(jsonResponse.getString("Genre")).append("\n");
                finalViewResponse.append("Director: ").append(jsonResponse.getString("Director")).append("\n");
                finalViewResponse.append("Writer: ").append(jsonResponse.getString("Writer")).append("\n");
                finalViewResponse.append("Actors: ").append(jsonResponse.getString("Actors")).append("\n");
                finalViewResponse.append("Plot: ").append(jsonResponse.getString("Plot")).append("\n");
                finalViewResponse.append("Language: ").append(jsonResponse.getString("Language")).append("\n");
                finalViewResponse.append("Country: ").append(jsonResponse.getString("Country")).append("\n");
                finalViewResponse.append("Awards: ").append(jsonResponse.getString("Awards")).append("\n");
                finalViewResponse.append("Ratings: ").append("\n");
                JSONArray ratingsArray = jsonResponse.getJSONArray("Ratings");
                for (int i = 0; i < ratingsArray.length(); i++) {
                    JSONObject eachRatingObject = ratingsArray.getJSONObject(i);
                    finalViewResponse.append("      Source: ").append(eachRatingObject.getString("Source")).append("\n");
                    finalViewResponse.append("      Value: ").append(eachRatingObject.getString("Value")).append("\n");
                }
                finalViewResponse.append("Metascore: ").append(jsonResponse.getString("Metascore")).append("\n");
                finalViewResponse.append("imdbRating: ").append(jsonResponse.getString("imdbRating")).append("\n");
                finalViewResponse.append("imdbVotes: ").append(jsonResponse.getString("imdbVotes")).append("\n");
                finalViewResponse.append("imdbID: ").append(jsonResponse.getString("imdbID")).append("\n");
                finalViewResponse.append("Type: ").append(jsonResponse.getString("Type")).append("\n");
                finalViewResponse.append("DVD: ").append(jsonResponse.getString("DVD")).append("\n");
                finalViewResponse.append("BoxOffice: ").append(jsonResponse.getString("BoxOffice")).append("\n");
                finalViewResponse.append("Production: ").append(jsonResponse.getString("Production")).append("\n");
                finalViewResponse.append("Website: ").append(jsonResponse.getString("Website")).append("\n");
                finalViewResponse.append("Response: ").append(jsonResponse.getString("Response")).append("\n");
                finalViewResponse.append("Poster: ").append(jsonResponse.getString("Poster")).append("\n");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalViewResponse.toString();
    }


    public String series_json_data(String series_response) {
        JSONObject jsonResponse = null;
        StringBuilder seriesViewResponse = new StringBuilder();
        try {
            jsonResponse = new JSONObject(series_response);
            if (jsonResponse.has("Error")) {
                String error = jsonResponse.getString("Error");
                seriesViewResponse.append(error).append("\n");
            }
            else {
                JSONArray searchArray = jsonResponse.getJSONArray("Search");
                for (int i = 0; i < searchArray.length(); i++) {
                    JSONObject eachRatingObject = searchArray.getJSONObject(i);
                    seriesViewResponse.append("\n");
                    seriesViewResponse.append("Title: ").append(eachRatingObject.getString("Title")).append("\n");
                    seriesViewResponse.append("Year: ").append(eachRatingObject.getString("Year")).append("\n");
                    seriesViewResponse.append("imdbID: ").append(eachRatingObject.getString("imdbID")).append("\n");
                    seriesViewResponse.append("Type: ").append(eachRatingObject.getString("Type")).append("\n");
                    seriesViewResponse.append("Poster: ").append(eachRatingObject.getString("Poster")).append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seriesViewResponse.toString();
    }

}
