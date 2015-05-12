package com.wangjie.rapidfloatingactionbutton.example.rfabgroup;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wangjie.androidbucket.utils.ABTextUtil;
import com.wangjie.androidbucket.utils.imageprocess.ABShape;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;
import com.wangjie.rapidfloatingactionbutton.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 5/4/15.
 */
public class FragmentC extends BaseFragment implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentListener {

    private RapidFloatingActionLayout rfaLayout;
    private RapidFloatingActionButton rfaButton;
    private RapidFloatingActionHelper rfabHelper;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rfab_group_sample_fragment_c, container, false);

        rfaLayout = (RapidFloatingActionLayout)view.findViewById(R.id.rfab_group_sample_fragment_c_rfal);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRFAB();

    }

    @Override
    public void onRFACItemLabelClick(int position, RFACLabelItem item) {
        Toast.makeText(getActivity(), "clicked label: " + position, Toast.LENGTH_SHORT).show();
        rfabHelper.toggleContent();
    }

    @Override
    public void onRFACItemIconClick(int position, RFACLabelItem item) {
        Toast.makeText(getActivity(), "clicked icon: " + position, Toast.LENGTH_SHORT).show();
        rfabHelper.toggleContent();
    }

    @Override
    public void onInitialRFAB(RapidFloatingActionButton rfab) {
        this.rfaButton = rfab;
        initRFAB();
    }

    private void initRFAB() {
        if (null == rfaButton) {
            return;
        }

        /*
        // 可通过代码设置属性
        rfaLayout.setFrameColor(Color.RED);
        rfaLayout.setFrameAlpha(0.4f);

        rfaBtn.setNormalColor(0xff37474f);
        rfaBtn.setPressedColor(0xff263238);
        rfaBtn.getRfabProperties().setShadowDx(ABTextUtil.dip2px(context, 3));
        rfaBtn.getRfabProperties().setShadowDy(ABTextUtil.dip2px(context, 3));
        rfaBtn.getRfabProperties().setShadowRadius(ABTextUtil.dip2px(context, 5));
        rfaBtn.getRfabProperties().setShadowColor(0xffcccccc);
        rfaBtn.getRfabProperties().setStandardSize(RFABSize.MINI);
        rfaBtn.build();
        */


        RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(getActivity());
        rfaContent.setOnRapidFloatingActionContentListener(this);
        List<RFACLabelItem> items = new ArrayList<>();
        items.add(new RFACLabelItem<Integer>()
                        .setLabel("Github: wangjiegulu")
                        .setResId(R.mipmap.ico_test_d)
                        .setIconNormalColor(0xff6a1b9a)
                        .setIconPressedColor(0xff4a148c)
                        .setWrapper(0)
        );
        items.add(new RFACLabelItem<Integer>()
                        .setLabel("tiantian.china.2@gmail.com")
                        .setResId(R.mipmap.ico_test_c)
                        .setIconNormalColor(0xff4e342e)
                        .setIconPressedColor(0xff3e2723)
                        .setLabelColor(Color.WHITE)
                        .setLabelSizeSp(14)
                        .setLabelBackgroundDrawable(ABShape.generateCornerShapeDrawable(0xaa000000, ABTextUtil.dip2px(getActivity(), 4)))
                        .setWrapper(1)
        );
        items.add(new RFACLabelItem<Integer>()
                        .setLabel("WangJie")
                        .setResId(R.mipmap.ico_test_b)
                        .setIconNormalColor(0xff056f00)
                        .setIconPressedColor(0xff0d5302)
                        .setLabelColor(0xff056f00)
                        .setWrapper(2)
        );
        items.add(new RFACLabelItem<Integer>()
                        .setLabel("Compose")
                        .setResId(R.mipmap.ico_test_a)
                        .setIconNormalColor(0xff283593)
                        .setIconPressedColor(0xff1a237e)
                        .setLabelColor(0xff283593)
                        .setWrapper(3)
        );
        rfaContent
                .setItems(items)
                .setIconShadowRadius(ABTextUtil.dip2px(getActivity(), 5))
                .setIconShadowColor(0xff888888)
                .setIconShadowDy(ABTextUtil.dip2px(getActivity(), 5))
        ;

        rfabHelper = new RapidFloatingActionHelper(
                getActivity(),
                rfaLayout,
                rfaButton,
                rfaContent
        ).build();
    }


    @Override
    public String getRfabIdentificationCode() {
        return getString(R.string.rfab_identification_code_fragment_c);
    }

    @Override
    public String getTitle() {
        return this.getClass().getSimpleName();
    }

}
