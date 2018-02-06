package com.dmc.punetravellogue.adapter;

import com.dmc.punetravellogue.R;
import com.dmc.punetravellogue.activity.TestFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TestFragmentAdapter extends FragmentPagerAdapter  {
    private int[] offerImages = {
            R.drawable.pune,
            R.drawable.pune_tw,
            R.drawable.pune_three,
            R.drawable.pune_four,
            R.drawable.pune_five,
    };

    private int mCount = offerImages.length;

    public TestFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new TestFragment(offerImages[position]);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}
