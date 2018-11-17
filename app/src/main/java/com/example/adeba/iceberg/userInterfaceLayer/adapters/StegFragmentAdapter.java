package com.example.adeba.iceberg.userInterfaceLayer.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.adeba.iceberg.userInterfaceLayer.fragments.DecryptFragment;
import com.example.adeba.iceberg.userInterfaceLayer.fragments.EncryptFragment;

public class StegFragmentAdapter extends FragmentPagerAdapter
{
    private static final int NUM_ITEMS = 2;
    public StegFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return EncryptFragment.newInstance("Encrypt");

            case 1:
                return DecryptFragment.newInstance("Decrypt");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Encrypt";
            case 1:
                return  "Decrypt";
            default:
                return "Tab";
        }
    }
}
