package app.sunshine.com.example.android.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    List<Movies> movieslist = new ArrayList<>();
    Context context;
    ListItemClickListener listItemClickListener;


    public MovieListAdapter(Context context, ListItemClickListener listItemClickListener) {
        this.context = context;
        this.listItemClickListener = listItemClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row2, parent, false), listItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.movie_title.setText(movieslist.get(position).getTitle());
//        Glide.with(context).load(movieslist.get(position).getPoster_path()).into(holder.poster);
        String posterUri = "https://image.tmdb.org/t/p/w342/" + movieslist.get(position).getPoster_path();
        Picasso.with(context).load(posterUri).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movieslist.size();

    }

    public void setList(ArrayList<Movies> movie_list) {
        this.movieslist = movie_list;
        this.notifyDataSetChanged();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {  // to be clickable
        TextView movie_title;
        ImageView poster;
        // to be clickable
        ListItemClickListener listItemClickListener;

        public MovieViewHolder(@NonNull View itemView, ListItemClickListener listItemClickListener) {
            super(itemView);
            movie_title = itemView.findViewById(R.id.movietitleTV);
            poster = itemView.findViewById(R.id.movieposteIMG);

            // to be clickable
            this.listItemClickListener = listItemClickListener;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            listItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    // to be clickable
    public interface ListItemClickListener {
        void onListItemClick(int pos);
    }
}
