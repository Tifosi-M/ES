package com.esyoung.exchangeskill.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esyoung.exchangeskill.R;

/**
 * Created by chenzw on 2015/7/13.
 */
public class DisplayWallFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.exchange_display_fragment, container, false);
    }

}
