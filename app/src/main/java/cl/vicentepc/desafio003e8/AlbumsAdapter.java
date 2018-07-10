package cl.vicentepc.desafio003e8;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AlbumsAdapter extends FirebaseRecyclerAdapter<Album, AlbumsAdapter.AlbumHolder> {


    public AlbumsAdapter(@NonNull FirebaseRecyclerOptions<Album> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AlbumHolder holder, int position, @NonNull Album model) {
        holder.band.setText(model.getBand());
        holder.gender.setText(model.getGender());
        holder.name.setText(model.getName());
        holder.release.setText(model.getRelease());
    }

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_album, parent,false);
        return new AlbumHolder(view);
    }

    public static class AlbumHolder extends RecyclerView.ViewHolder{

        private TextView band, gender, name, release;

        public AlbumHolder(View itemView) {
            super(itemView);
            band = itemView.findViewById(R.id.bandTv);
            gender = itemView.findViewById(R.id.genderTv);
            name = itemView.findViewById(R.id.nameTv);
            release = itemView.findViewById(R.id.releaseTv);
        }
    }

}
