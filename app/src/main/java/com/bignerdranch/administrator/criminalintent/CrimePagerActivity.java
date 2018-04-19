package com.bignerdranch.administrator.criminalintent;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

public class CrimePagerActivity extends AppCompatActivity {

    private static final String EXTRA_CRIME_TD = "com.bignerdranch.android.criminalintent.crime_id";

    private ViewPager mViewPager;
    private List<Crime> mCrimes;

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_TD, crimeId);
        return intent;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        UUID crimed = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_TD);
        //找到ViewPager布局
        mViewPager = (ViewPager) findViewById(R.id.activity_crime_pager_view_pager);
        //获取数据集
        mCrimes = CrimeLab.get(this).getCrimes();
        //获取FragmentManager实例
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
        for (int i = 0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getId().equals(crimed)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

}
