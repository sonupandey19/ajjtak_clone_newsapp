package com.example.ajjatak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;
BottomNavigationView bnview;
TabLayout tabLayout;
TabItem findia,fworld,fvideos,fentertainment,ftechnology,fsports,fwebstories,fbusiness,fdhrma,fexplained, flifestyle,ftrending,fauto,fphotos;
PageAdapter pageAdapter;
Button darkmode, lightmode;



    String apikey="09dea45fcbd64eb2ab55e6c8fd633e17";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.my_drawer_layouts);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        bnview = findViewById(R.id.bottomnavigatyionview);
        findia = findViewById(R.id.india);
        fworld = findViewById(R.id.World);
        fvideos = findViewById(R.id.video);
        fentertainment = findViewById(R.id.entertainment);
        ftechnology = findViewById(R.id.Technology);
        fsports = findViewById(R.id.sports);
        fwebstories = findViewById(R.id.web_stories);
        fbusiness = findViewById(R.id.bussiness);
        fdhrma = findViewById(R.id.dharm);
        fexplained = findViewById(R.id.explained);
        flifestyle = findViewById(R.id.lifestyle);
        ftrending = findViewById(R.id.trending);
        fauto = findViewById(R.id.auto);
        fphotos = findViewById(R.id.photos);
        tabLayout = findViewById(R.id.include);





       ViewPager viewPager= findViewById(R.id.fragmentcontainer);
        tabLayout= findViewById(R.id.include);

        pageAdapter=new PageAdapter(getSupportFragmentManager(), 0x12);
        viewPager.setAdapter(pageAdapter );


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5)
                {
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));









        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id==R.id.Home){
                    loadfrag(new HomeFragment(),true);
                    Toast.makeText(MainActivity.this,"Home",Toast.LENGTH_SHORT).show();

                }else if (id==R.id.newsreel){
                    loadfrag(new NewsReelsFragment(),false);

                }else if (id==R.id.livetv){
                    loadfrag(new LivetvFragment(),false);

                }else if (id==R.id.game){
                    loadfrag(new GamesFragment(),false);

                }else{
                    loadfrag(new DarkModeFragment(),false);
                }



                return false;
            }
        });

        bnview.setSelectedItemId(R.id.Home);

        setSupportActionBar(toolbar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

       // loadfragment(new HomeFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id==R.id.Home){
                    loadfragment(new HomeFragment());
                    Toast.makeText(MainActivity.this,"Home",Toast.LENGTH_SHORT).show();
                }else if (id==R.id.india){
                    Toast.makeText(MainActivity.this, "India", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.web_stories){

                }else if (id==R.id.entertainment){

                }else if (id==R.id.sports){

                }else if (id==R.id.World){

                }else if (id==R.id.explained){

                }else if (id==R.id.bussiness){

                }else if (id==R.id.dharm){

                }else if (id==R.id.Technology){

                }else if (id==R.id.lifestyle){

                }else if (id==R.id.trending){

                }else if (id==R.id.photos){

                }else if(id==R.id.video){

                }else {

                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;

            }
        });
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        {
            super.onBackPressed();
        }
    }

    private void loadfragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.commit();
    }

    private void loadfrag(Fragment fragment, boolean flag) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag)
            ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);
        ft.commit();
    }

}
