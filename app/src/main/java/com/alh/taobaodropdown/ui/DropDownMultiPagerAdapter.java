package com.alh.taobaodropdown.ui;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zhaoyong
 * on 2016/8/2.
 */
public class DropDownMultiPagerAdapter extends PagerAdapter
{

    private List<View> list;

    public DropDownMultiPagerAdapter(List<View> list)
    {
        this.list = list;
    }

    public void setList(List<View> list)
    {
        this.list = list;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position)
    {
        container.addView(list.get(position), 0);

        DropDownMultiPagerItem item = (DropDownMultiPagerItem) list.get(position);
        item.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("click", String.valueOf(position));
            }
        });
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView(list.get(position));
    }

    @Override
    public int getItemPosition(Object object)
    {
        return POSITION_NONE;
    }
}
