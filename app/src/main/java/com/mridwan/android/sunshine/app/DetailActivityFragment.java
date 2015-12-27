package com.mridwan.android.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

//        String forecastData = savedInstanceState.getString(Intent.EXTRA_TEXT);
        Intent intent = getActivity().getIntent();
        TextView textView = (TextView)view.findViewById(R.id.detail_text);
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            textView.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
        } else {
            textView.setText("forecastData");
        }

        return view;
    }
}
