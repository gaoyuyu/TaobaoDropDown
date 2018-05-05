package com.alh.taobaodropdown.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alh.taobaodropdown.R;
import com.alh.taobaodropdown.ui.transformer.ZoomPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YaphetZhao
 * on 2016/12/12.
 */
@SuppressLint({"SetTextI18n", "InflateParams"})
public class DropDownMultiPagerView extends Dialog
{


    private Context context;
    private MultiViewPager pager;
    private RecyclerView rv;

    public DropDownMultiPagerView(Context context)
    {
        super(context, R.style.DropDown);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_dropdownfootprint, null);

        setContentView(view);
        setCanceledOnTouchOutside(true);
        setCancelable(true);

        Window dialogWindow = getWindow();
        assert dialogWindow != null;
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        lp.width = dm.widthPixels;
        lp.height = dip2px(context, 300);
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.TOP);
        dialogWindow.setWindowAnimations(R.style.DropDown);

        pager = (MultiViewPager) view.findViewById(R.id.pager);
        pager.setPageTransformer(true, new ZoomPageTransformer());

        final List<View> list = new ArrayList<>();
        int[] bgs = {R.mipmap.bg1, R.mipmap.bg2, R.mipmap.bg3, R.mipmap.bg4, R.mipmap.bg5};
        for (int i = 0; i < bgs.length; i++)
        {
            DropDownMultiPagerItem item = new DropDownMultiPagerItem(context, bgs[i]);
            list.add(item);
        }

        final DropDownMultiPagerAdapter adapter = new DropDownMultiPagerAdapter(list);

        pager.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }

    private int dip2px(Context context, float dpValue)
    {
        try
        {
            return (int) (dpValue * context.getResources().getDisplayMetrics().density + 0.5f);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return (int) (dpValue * 1 + 0.5f);
        }
    }

}
