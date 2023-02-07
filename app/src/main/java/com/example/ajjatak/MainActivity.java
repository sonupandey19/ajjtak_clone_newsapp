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
import android.view.Gravity;
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
BottomNavigationView bnview;
TabLayout tabLayout;
TabItem findia,fvideos,fsports,fphotos;
PageAdapter pageAdapter;

String apikey="09dea45fcbd64eb2ab55e6c8fd633e17";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.my_drawer_layouts);
        bnview = findViewById(R.id.bottomnavigatyionview);
        findia = findViewById(R.id.india);
        fvideos = findViewById(R.id.video);
        tabLayout = findViewById(R.id.include);
        ViewPager viewPager= findViewById(R.id.fragmentcontainer);


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
                  //  Toast.makeText(MainActivity.this,"Home",Toast.LENGTH_SHORT).show();
                }else if (id==R.id.Photo_gallery){
                    loadfrag(new NewsReelsFragment(),false);

                }else if (id==R.id.livetv){
                    loadfrag(new LivetvFragment(),false);

                }else if (id==R.id.game){
                    loadfrag(new GamesFragment(),false);

                } else if (id==R.id.btm_more) {
                    loadfrag(new MoreFragment(),false);
                }
                return false;
            }
        });



        //navigation action bar
       /* ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
*/
       // loadfragment(new HomeFragment());

    }



    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.Home:
                fragmentClass = HomeFragment.class;
                tabLayout.getTabAt(0).select();
                break;
            case R.id.india:
                fragmentClass = IndiaFragment.class;
                tabLayout.getTabAt(1).select();
                break;

            case R.id.video:
                fragmentClass = VideoFragment.class;
                tabLayout.getTabAt(2).select();
                break;

            case R.id.sports:
                fragmentClass = SportsFragment.class;
                tabLayout.getTabAt(3).select();
                break;


            default:
                fragmentClass = HomeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawers();
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
        ft.replace(R.id.container,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

}
