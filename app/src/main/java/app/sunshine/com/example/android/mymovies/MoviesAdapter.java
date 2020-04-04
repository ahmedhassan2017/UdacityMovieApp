package app.sunshine.com.example.android.mymovies;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {
    /*
    الميثود onCreateViewHolder  ويتم استدعائها اثناء إنشاء الـ ViewHolder  وترجع لنا بـ ViewHolder

الميثود onBindViewHolder  ويتم استدعائها عند عمل Bind او ملىء او ربط الـ ViewHolder

الـ getItemCount تقوم بحساب عدد الصفوف فى الـ Recycler فقط
*/

    Context context;
    List<Movies> movieslist;
    final private ListItemClickListener mOnClickListener;


    public MoviesAdapter(Context context, ArrayList<Movies> movieslist, ListItemClickListener mOnClickListener) {
        this.context = context;
        this.movieslist = movieslist;

        this.mOnClickListener = mOnClickListener;
    }


    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row2,parent,false);


        MovieHolder holder =new MovieHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

//        Movie movie =movieslist.get(position);
//        holder.movie_title.setText(movie.title);
//        holder.movie_Rate.setText("("+movie.vote_average+" / 10)");
//        holder.movie_desc.setText(movie.overview);

//        String poster="http://image.tmdb.org/t/p/w342/"+movie.poster_path;
//        Picasso.with(context).load(poster).into(holder.poster);

        holder.bind(movieslist.get(position), mOnClickListener);

    }

    @Override
    public int getItemCount() {
        return movieslist.size();
    }
    public void updateMovies(ArrayList<Movies> movie_list) {
        this.movieslist= movie_list;
        this.notifyDataSetChanged();
    }

    class MovieHolder extends RecyclerView.ViewHolder  {

        TextView movie_title ;
        ImageView poster;

        public MovieHolder(View itemView) {
            super(itemView);

            movie_title =itemView.findViewById(R.id.movietitleTV);
//            movie_Rate=itemView.findViewById(R.id.movieratTV);
//            movie_desc=itemView.findViewById(R.id.moviedescTV);
            poster=itemView.findViewById(R.id.movieposteIMG);


        }

        public void bind(final Movies item, final ListItemClickListener listener) {
            movie_title.setText(item.title);
            String posterUri="http://ima ge.tmdb.org/t/p/w342/"+item.poster_path;
            Picasso.with(context).load(posterUri).into(poster);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onListItemClick(item);
                }
            });
        }

//        @Override
//        public void onClick(View view) {
//            Movie movie = getAdapterPosition();
//            mOnClickListener.onListItemClick(clickedPosition);
//        }
    }

    public interface ListItemClickListener {
        void onListItemClick(Movies movieitem);
    }
}
