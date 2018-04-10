package com.idjmao.easypiclib.showlist;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.idjmao.easypiclib.R;

import java.util.List;

/**
 * Created by 1djmao on 2017/9/11.
 */

public class ShowPics {
    public static void show(final Context context, final List<String> list, int position) {

        Dialog fullscreenDialog = new Dialog(context, R.style.DialogFullscreen);
        fullscreenDialog.setContentView(R.layout.dialog_view_pager);

        final TextView posTv= (TextView) fullscreenDialog.findViewById(R.id.tv_pos);
        final ViewPager viewPager = (ViewPager) fullscreenDialog.findViewById(R.id.pager);
//        viewPager.setPageMargin((int) (mContext.getResources().getDisplayMetrics().density * 15));
        viewPager.setAdapter(new ImgListPagerAdapter(context, list));
        viewPager.setBackgroundColor(Color.BLACK);
        viewPager.setCurrentItem(position);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                posTv.setText(position+1+" / "+viewPager.getAdapter().getCount());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        posTv.setText(position+1+" / "+viewPager.getAdapter().getCount());
        fullscreenDialog.show();
    }

}
