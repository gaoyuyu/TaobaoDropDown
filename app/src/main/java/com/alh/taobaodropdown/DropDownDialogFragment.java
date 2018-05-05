package com.alh.taobaodropdown;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.alh.taobaodropdown.ui.DropDownMultiPagerAdapter;
import com.alh.taobaodropdown.ui.DropDownMultiPagerItem;
import com.alh.taobaodropdown.ui.MultiViewPager;
import com.alh.taobaodropdown.ui.transformer.ZoomPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class DropDownDialogFragment extends DialogFragment
{

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Dialog dialog = createDialog();
        return dialog;
    }

    @NonNull
    private Dialog getCustomDialog()
    {
        Dialog dialog = new Dialog(getContext(), android.R.style.Theme_Translucent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        return dialog;
    }

    @NonNull
    private Dialog createDialog()
    {
        Dialog dialog = getCustomDialog();
        dialog.setContentView(R.layout.dialog_dropdownfootprint);
        MultiViewPager pager = dialog.findViewById(R.id.pager);
        LinearLayout parent = dialog.findViewById(R.id.parent);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);

        Window dialogWindow = dialog.getWindow();
        assert dialogWindow != null;
        dialogWindow.setGravity(Gravity.TOP);
        dialogWindow.setWindowAnimations(R.style.DropDown);

        pager.setPageTransformer(true, new ZoomPageTransformer());

        final List<View> list = new ArrayList<>();
        int[] bgs = {R.mipmap.bg1, R.mipmap.bg2, R.mipmap.bg3, R.mipmap.bg4, R.mipmap.bg5};
        for (int i = 0; i < bgs.length; i++)
        {
            DropDownMultiPagerItem item = new DropDownMultiPagerItem(getContext(), bgs[i]);
            list.add(item);
        }
        final DropDownMultiPagerAdapter adapter = new DropDownMultiPagerAdapter(list);
        pager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        parent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dismiss();
            }
        });


        return dialog;
    }
}
