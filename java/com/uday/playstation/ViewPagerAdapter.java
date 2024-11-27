package com.uday.playstation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    ArrayList<String> tabtitle=new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        //single argumnet ahyet
        super(fm);
    }

    public void addFragment(Fragment fragment,String tab)
    {
        this.fragmentArrayList.add(fragment);//size 3
        this.tabtitle.add(tab);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitle.get(position);
    }
}
