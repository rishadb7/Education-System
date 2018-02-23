package pk.edu.bisedik.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import pk.edu.bisedik.Fragments.Hom_Fragment;
import pk.edu.bisedik.Fragments.Map_Fragmet;
import pk.edu.bisedik.Fragments.Noti_Fragment;
import pk.edu.bisedik.R;
import pk.edu.bisedik.ViewPager_Adapter;
import softpro.naseemali.ShapedNavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    // implements NavigationView.OnNavigationItemSelectedListener{

    private ShapedNavigationView navigationView;

   // private SectionsPagerAdapter mSectionsPagerAdapter;

    final String TAG = this.getClass().getName();
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager mViewPager;
    ViewPager_Adapter viewPager_adapter;
    Context context;

    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.pager);

        viewPager_adapter=new ViewPager_Adapter(getSupportFragmentManager());

        viewPager_adapter.addFragments(new Hom_Fragment(),"Home");
        viewPager_adapter.addFragments(new Map_Fragmet(),"Map");
        viewPager_adapter.addFragments(new Noti_Fragment(),"Notification");

        mViewPager.setAdapter(viewPager_adapter);
        tabLayout.setupWithViewPager(mViewPager);

         mViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
         tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                 mViewPager.setCurrentItem(tab.getPosition());

                 switch (tab.getPosition()) {


                     case 0:

                       /*  try{
                             fragment =new Hom_Fragment();
                             final FragmentTransaction transaction0 = fragmentManager.beginTransaction();
                             transaction0.replace(R.id.fragmentHolder, fragment).commit();

                         }catch (Exception e)
                         {
                             e.printStackTrace();
                         }*/

                     break;


                 }




             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
        });

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
       // mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
       // mViewPager = (ViewPager) findViewById(R.id.container);
      //  mViewPager.setAdapter(mSectionsPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (ShapedNavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }





    //Drawer layout
    boolean twice;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();

            Log.d(TAG, "Click");
            if (twice == true) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
            }
            twice = true;
            Log.d(TAG, "twice" + twice);
            // super.onBackPressed();
            Toast.makeText(MainActivity.this, "Pres BACK again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    twice = false;
                    Log.d(TAG, "twice" + twice);

                }
            }, 3000);
        }
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    //Drawer layout
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.waves:
                navigationView.getSettings().setShapeType(ShapedViewSettings.WAVES);
                break;
            case R.id.waves_indefinite:
                navigationView.getSettings().setShapeType(ShapedViewSettings.WAVES_INDEFINITE);
                break;
           *//* case R.id.rounded_bottom:
                navigationView.getSettings().setShapeType(ShapedViewSettings.BOTTOM_ROUND);
                break;
            case R.id.full_rounded:
                navigationView.getSettings().setShapeType(ShapedViewSettings.FULL_ROUND);
                break;*//**//**//**//*
            case R.id.arcConvex:
                navigationView.getSettings().setShapeType(ShapedViewSettings.ARC_CONVEX);
                break;
            case R.id.arcConcave:
                navigationView.getSettings().setShapeType(ShapedViewSettings.ARC_CONCAVE);
                break;
           *//**//**//**//* case R.id.rounded_corners:
                navigationView.getSettings().setShapeType(ShapedViewSettings.ROUNDED_RECT);
                break;*//**//**//**//*
            case R.id.normal:
                navigationView.getSettings().setShapeType(ShapedViewSettings.NORMAL);
                break;*//*
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
*/
    //Drawer layout
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * A placeholder fragment containing a simple view.
     */
   /* public static class PlaceholderFragment extends Fragment {
        *//**
         * The fragment argument representing the section number for this
         * fragment.
         *//*
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        *//**
         * Returns a new instance of this fragment for the given section
         * number.
         *//*
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.home_label);

           // textView.setTextColor(Color.WHITE);
            *//*textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));*//*
            return rootView;
        }
    }*/

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    /*public class SectionsPagerAdapter extends FragmentPagerAdapter {*/

       /* public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }*/


}
