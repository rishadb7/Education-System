package pk.edu.bisedik;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import pk.edu.bisedik.Fragments.Hom_Fragment;
import pk.edu.bisedik.Fragments.Map_Fragmet;
import pk.edu.bisedik.Fragments.Noti_Fragment;

/**
 * Created by Abdul Basit Danish on 11/21/2017.
 */

public class ViewPager_Adapter extends FragmentPagerAdapter {


    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> tabTitles=new ArrayList<>();
    Context context;

    public  void addFragments(Fragment fragment,String titles){
        this.fragments.add(fragment);
        this.tabTitles.add(titles);
    }
    public ViewPager_Adapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {

      //  Fragment fragment = null;
        if (position == 0)
        {

           return new Hom_Fragment();
        }
        else if (position == 1)
        {
            return new Map_Fragmet();
        }
        else if (position == 2)
        {
            return new Noti_Fragment();
        }
        return new Hom_Fragment();

       // return fragments.get(position);
    }

    @Override
    public int getCount() {

        return 3;
      //  return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}
