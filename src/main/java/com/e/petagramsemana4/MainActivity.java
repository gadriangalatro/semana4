package com.e.petagramsemana4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    Toolbar aBar;
    TabLayout tabLay;
    ViewPager viewPager;
    ArrayList<Fragment> fragments;
    ArrayList<String>nombres;
    ArrayList<Integer>fotos, votos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aBar = findViewById(R.id.aBar);
        setSupportActionBar(aBar);

        tabLay = findViewById(R.id.tablay);
         viewPager = findViewById(R.id.viewPager);

        loadPager(viewPager);
        tabLay.setupWithViewPager(viewPager);

        tabLay.getTabAt(0).setIcon(R.drawable.icons_home);
        tabLay.getTabAt(1).setIcon(R.drawable.icons_dog);
        aBar.setNavigationIcon(R.drawable.huella);

try {


        Bundle bund = getIntent().getExtras();
          // String nom = bund.getString("nom");
        //   int fot = bund.getInt("fot");
           int vot = bund.getInt("vot");
           int pos = bund.getInt("pos");

        //   fotos.add(pos, fot);
       //    nombres.add(pos, nom);
           votos.add(pos, vot);
}catch (Exception e){}
}



    private void loadPager(ViewPager viewPager){
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.addFragment(new MascotasFragment());
        adapter.addFragment(new PerfilesFragment());
        viewPager.setAdapter(adapter);

    }




    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


/*    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.star:

                ArrayList<String> lista = (ArrayList<String>) getIntent().getSerializableExtra("Lista");
                ArrayList<Integer> listaf = (ArrayList<Integer>) getIntent().getSerializableExtra("listaf");
                ArrayList<Integer> votos = (ArrayList<Integer>) getIntent().getSerializableExtra("votos");
                Intent datos = new Intent(this, Ranking.class);

                Collections.sort(mascotas, new Comparator<Pets>() {
                    @Override
                    public int compare(Pets o1, Pets o2) {
                        return new Integer(o2.getVotos()).compareTo(new Integer(o1.getVotos()));
                    }
                });

                for(int i=0; i<mascotas.size(); i++){
                    nombres.add(mascotas.get(i).getNombre());
                    fotos.add(mascotas.get(i).getImagen());
                    votos.add(mascotas.get(i).getVotos());
                }

                datos.putExtra("Lista", lista);
                datos.putExtra("listaf", listaf);
                datos.putExtra("votos", votos);
                startActivity(datos);
                break;

            case R.id.about:
                Intent intabout = new Intent(MainActivity.this, About.class);
                startActivity(intabout);
                break;

            case R.id.contact:
                Intent intconta = new Intent(MainActivity.this, Contacto.class);
                startActivity(intconta);
                break;

        }

        return super.onOptionsItemSelected(item);
    }*/


}