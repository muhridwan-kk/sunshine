package com.mridwan.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        String [] sArray = {
                "Today - Sunny - 30/30",
                "Thursday - Foggy - 28/29",
                "Friday - Foggy - 28/30",
                "Saturday - Sunny - 30/31",
                "Sunday - Sunny - 28/30",
                "Monday - Cloudy - 28/30",
                "Tuesday - Cloudy 29/30",
                "Wednesday - Sunny 30/31"
            };
        List<String> weekForecast = new ArrayList<String>(Arrays.asList(sArray));
        ArrayAdapter<String> forecastAdapter = new ArrayAdapter<String>(
                                                this.getActivity(),
                                                R.layout.list_item_forecast,
                                                R.id.list_item_forecast_textview,
                                                weekForecast);

        ListView listView = (ListView)view.findViewById(R.id.listview_forecast);
        listView.setAdapter(forecastAdapter);
        return view;
    }

}
