package com.bignerdranch.administrator.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2018/3/23 0023.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }

}
