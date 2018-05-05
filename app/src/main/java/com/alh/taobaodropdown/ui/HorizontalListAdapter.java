package com.alh.taobaodropdown.ui;

import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.alh.taobaodropdown.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class HorizontalListAdapter extends BaseQuickAdapter<String, BaseViewHolder>
{

    public HorizontalListAdapter(@Nullable List<String> data)
    {
        super(R.layout.item_dropdownfootprint, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item)
    {
        int position = helper.getAdapterPosition();
        helper.setText(R.id.item_num, item);
        LinearLayout parent = helper.getView(R.id.item_parent);
        if(position == 0)
        {
            parent.setGravity(Gravity.CENTER);
        }
        else
        {
            parent.setGravity(Gravity.RIGHT);
        }
    }
}
