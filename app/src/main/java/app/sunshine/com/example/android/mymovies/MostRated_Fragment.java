package app.sunshine.com.example.android.mymovies;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MostRated_Fragment extends Fragment implements MoviesAdapter.ListItemClickListener {

    LinearLayoutManager mLayoutManager;
    RecyclerView recyclerView;

    private ArrayList<Movies> moviesArrayList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_most_rated_, container, false);

         recyclerView = root.findViewById(R.id.recyclerView1);
        fetchTopRatedData();


        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(
                2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView



        return root;
    }


    @Override
    public void onListItemClick(Movies movieitem) {
        Detailes_Fragment detailes_fragment = new Detailes_Fragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, detailes_fragment, "").commit();

    }


    public void fetchTopRatedData() {
        String BASE_URL = "https://api.themoviedb.org/3/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_interface api = retrofit.create(Api_interface.class);


        api.getTopRatedData(Api_interface.Apikey)
                .enqueue(new Callback<serverResponse>() {
                    @Override
                    public void onResponse(Call<serverResponse> call, Response<serverResponse> response) {
//                        Toast.makeText(MainActivity.this, "successssssssssssssssssss", Toast.LENGTH_SHORT).show();
                        serverResponse serverResponse = response.body();


                        ArrayList<Movies> items = serverResponse.getMovies();
                        moviesArrayList.addAll(items);


                        MovieListAdapter adapter = new MovieListAdapter(getContext());
                        adapter.setList(moviesArrayList);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<serverResponse> call, Throwable t) {
//                        Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                        Log.i("onFailure: ", t.getMessage());
                        ;
                    }
                });

    }

}




