package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.recyclerview.adapter.MovieAdapter;
import com.example.recyclerview.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MovieAdapter adapter;
    RecyclerView rv;
    List<MovieModel> listMovie = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    public void initRecyclerView(){
        adapter = new MovieAdapter(this);
        rv = findViewById(R.id.rv_movie);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setNestedScrollingEnabled(false);
        rv.hasFixedSize();
        adapter.setOnItemClickListener(new
                                               MovieAdapter.OnItemClickListener() {
                                                   @Override
                                                   public void onClick(int position) {
                                                       Intent i = new Intent(MainActivity.this,
                                                               DetailMovieActivity.class);
                                                       i.putExtra("name",listMovie.get(position).getName());
                                                       i.putExtra("rating",listMovie.get(position).getRating());
                                                       i.putExtra("jadwal",listMovie.get(position).getJadwal());
                                                       i.putExtra("deskripsi",listMovie.get(position).getDesCription());
                                                       startActivity(i);
                                                   }
                                               });
        loadItem();
    }

    public void loadItem() {

        listMovie.add(new MovieModel("Nama : Nasi Timbel", "Harga : Rp.40000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Tutug Oncom", "Harga : Rp.30000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Karedok", "Harga : Rp.15000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Soto", "Harga : Rp.20000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Doclang", "Harga : Rp.25000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Lotek", "Harga : Rp.30000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Liwet", "Harga : Rp.40000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Pepes", "Harga : Rp.20000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Empal", "Harga : Rp.30000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Maranggi", "Harga : Rp.45000", "Lauk Lauk Tambahan", "Description "));
        listMovie.add(new MovieModel("Nama : Kupat", "Harga : Rp.30000", "Lauk Lauk Tambahan0", "Description "));

        adapter.addAll(listMovie);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.profile){
            startActivity(new Intent(this, profile.class));
        } else if (item.getItemId() == R.id.change_language) {
            startActivity(new Intent(this, change_language.class));
        }

        return true;
    }


}
