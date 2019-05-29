package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.models.Anunt;
import com.example.myapplication.service.AnuntServiceImpl;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


   // int []images={};
  //  String [] txts={};
   // int []aux={R.drawable.ic_menu_camera, R.drawable.ic_audiotrack_dark, R.drawable.ic_audiotrack_light};
   /* Anunt a1=new Anunt( aux,100,"yes");
    Anunt a2=new Anunt( aux,100,"yes");
    Anunt a3=new Anunt( aux,100,"yes");
    Anunt a4=new Anunt( aux,100,"yes");
    Anunt a5=new Anunt( aux,100,"yes");*/

    AnuntServiceImpl anuntService=new AnuntServiceImpl();
    List<com.example.myapplication.models.Anunt> listaAnunturi=anuntService.getAnunturi();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView= findViewById(R.id.listview);
       /* listaAnuntur.adaugareAnunt(a1);
        listaAnuntur.adaugareAnunt(a2);
        listaAnuntur.adaugareAnunt(a3);
        listaAnuntur.adaugareAnunt(a4);
        listaAnuntur.adaugareAnunt(a5);
       // images=listaAnuntur.getImaginiLista();
    //    txts=listaAnuntur.getTxtLista();*/









        customAdapter adapt=new customAdapter();
        listView.setAdapter(adapt);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Anunt aux=listaAnunturi.get(position);
                Intent intent=new Intent(MainActivity.this,AnuntGrafic.class);
                intent.putExtra("anuntul",aux);
                startActivity(intent);
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_tools) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class customAdapter extends BaseAdapter {



        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater;

            View view=getLayoutInflater().inflate(R.layout.customayout,null);

            ImageView img= view.findViewById(R.id.imgLayout);
            TextView txt= view.findViewById(R.id.txtLayout);

            img.setImageResource(images[position]);
            txt.setText(txts[position]);
            return view;
        }
    }
}
