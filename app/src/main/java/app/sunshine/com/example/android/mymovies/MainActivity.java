package app.sunshine.com.example.android.mymovies;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.navDrawer)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout myDrawerlayout;

    private ActionBarDrawerToggle myToggle;

    ArrayList<Movies> moviesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myToggle = new ActionBarDrawerToggle(this, myDrawerlayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        myDrawerlayout.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        fetchPopularData();

        Popular_Fragment popular_fragment = new Popular_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, popular_fragment, "").commit();


        navigationView = (NavigationView) findViewById(R.id.navDrawer);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();

                switch (title) {
                    case "Most Rated":
                        MostRated_Fragment mostRated_fragment = new MostRated_Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, mostRated_fragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
                    case "Popular":
                        Popular_Fragment popular_fragment = new Popular_Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, popular_fragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
                    case "Favorites":
                        Favorites_Fragment favorites_fragment = new Favorites_Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, favorites_fragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
                    case "Logout":
                        // intent to login activity
                        break;
                    case "Profile":
                        profile_Fragment profileFragment = new profile_Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, profileFragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
                    case "Settings":
                        // intent to settings
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (myToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }



}

