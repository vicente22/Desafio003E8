package cl.vicentepc.desafio003e8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.exampleRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);

        FirebaseRecyclerOptions<Album> options = new FirebaseRecyclerOptions.Builder<Album>()
                .setQuery(new Nodes().albums(), Album.class)
                .build();

        AlbumsAdapter adapter = new AlbumsAdapter(options);
        recyclerView.setAdapter(adapter);

    }
}
