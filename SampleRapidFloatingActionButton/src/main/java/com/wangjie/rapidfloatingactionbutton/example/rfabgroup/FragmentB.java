package com.wangjie.rapidfloatingactionbutton.example.rfabgroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.example.R;
import com.wangjie.rapidfloatingactionbutton.listener.OnRapidFloatingButtonSeparateListener;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 5/4/15.
 */
public class FragmentB extends BaseFragment implements OnRapidFloatingButtonSeparateListener {

    private RapidFloatingActionButton rfaButton;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rfab_group_sample_fragment_b, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (null == rfaButton) {
            return;
        }
        rfaButton.setOnRapidFloatingButtonSeparateListener(this);
    }

    @Override
    public void onInitialRFAB(RapidFloatingActionButton rfab) {
        this.rfaButton = rfab;
        if (null == rfaButton) {
            return;
        }
        rfaButton.setOnRapidFloatingButtonSeparateListener(this);
    }

    @Override
    public String getRfabIdentificationCode() {
        return getString(R.string.rfab_identification_code_fragment_b);
    }

    @Override
    public String getTitle() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void onRFABClick() {
        showToastMessage("B RFAB clicked");
    }
}
