package com.example.yunus.trakyadepo.Adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.yunus.trakyadepo.onefragment;
import com.example.yunus.trakyadepo.thirdfragment;
import com.example.yunus.trakyadepo.twofragment;


/**
 * Created by yunus on 11.01.2016.
 */
public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                onefragment tab1 = new onefragment();
                return tab1;
            case 1:
                twofragment tab2 = new twofragment();
                return tab2;
            case 2:
                thirdfragment tab3 = new thirdfragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}