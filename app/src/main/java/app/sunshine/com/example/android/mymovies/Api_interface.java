package app.sunshine.com.example.android.mymovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_interface {
    //    String BASE_URL ="http://api.themoviedb.org/3/movie/top_rated?api_key=600908f259c6e4fe3bbba5ce046ee937";
    String Apikey = "600908f259c6e4fe3bbba5ce046ee937";

    @GET("popular")
    Call<serverResponse> getMostPopularData(
            @Query("api_key") String api_key);
    @GET("top_rated")
    Call<serverResponse> getTopRatedData(
            @Query("api_key") String api_key);




}



