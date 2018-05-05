package com.alh.taobaodropdown.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.alh.taobaodropdown.R;

/**
 * Created by YaphetZhao
 * on 2016/12/12.
 */

@SuppressLint("ViewConstructor")
public class DropDownMultiPagerItem extends LinearLayout
{

    private View view;
    private RelativeLayout itemLayout;

    public DropDownMultiPagerItem(Context context, int num)
    {
        super(context);
        view = LayoutInflater.from(context).inflate(R.layout.item_dropdownfootprint, this);
        itemLayout = (RelativeLayout) findViewById(R.id.item_layout);
//        ((TextView) findViewById(R.id.item_num)).setText(String.valueOf(num));
        ((ImageView) findViewById(R.id.item_img)).setImageDrawable(getResources().getDrawable(num));
    }


}
