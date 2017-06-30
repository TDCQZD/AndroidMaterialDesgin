package com.example.tablayoutviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tablayoutviewpager.fragment.MyFragment;

import java.util.ArrayList;

/**
 * ViewPager适配器
 *
 * @author ZD
 *         created at 2017/6/30 9:17
 *         description：实现多个Fragment设置
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<MyFragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<MyFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    /**
     * 根据位置返回对应的Fragment
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    /**
     * 得到页面的标题
     *
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();

    }
}
