package com.mbarrios.petagram;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;



    @Override
    public View findViewById(@IdRes int id) {
        return super.findViewById(id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById (R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);

    }


    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bruce", R.drawable.imguno, 0));
        mascotas.add(new Mascota("Dash", R.drawable.imgdos, 0));
        mascotas.add(new Mascota("Bella", R.drawable.imgtres, 0));
        mascotas.add(new Mascota("Bob", R.drawable.imgcuatro, 0));
        mascotas.add(new Mascota("Koke", R.drawable.mascotaseis, 0));
        mascotas.add(new Mascota("Drake", R.drawable.imgseis, 0));
        mascotas.add(new Mascota("Buffy", R.drawable.imgsiete, 0));
        mascotas.add(new Mascota("Nieve", R.drawable.imgocho, 0));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
                case R.id.action_mascotas:
                    Toast.makeText(this, getResources().getString(R.string.text_menu), Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_settings:
                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_star:
                    Toast.makeText(this, getResources().getString(R.string.favoritas), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
                    startActivity(intent);
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
