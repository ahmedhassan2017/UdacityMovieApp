package app.sunshine.com.example.android.mymovies;

import com.google.gson.annotations.SerializedName;

class Movies  {
    @SerializedName("popularity")
    String popularity;
    @SerializedName("vote_count")
    String vote_count;
    @SerializedName("poster_path")
    String poster_path;
    @SerializedName("id")
    String id;
    @SerializedName("backdrop_path")
    String backdrop_path;
    @SerializedName("title")
    String title;
    @SerializedName("vote_average")
    String vote_average;
    @SerializedName("overview")
    String overview;
    @SerializedName("release_date")
    String release_date;

    public String getPopularity() {
        return popularity;
    }

    public String getVote_count() {
        return vote_count;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getId() {
        return id;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getTitle() {
        return title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }
}
