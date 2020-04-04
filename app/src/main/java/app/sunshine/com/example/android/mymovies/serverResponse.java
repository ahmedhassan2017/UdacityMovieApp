package app.sunshine.com.example.android.mymovies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class serverResponse {
    @SerializedName("results")
    private ArrayList<Movies> movies;

    public ArrayList<Movies> getMovies() {
        return movies;
    }
}
