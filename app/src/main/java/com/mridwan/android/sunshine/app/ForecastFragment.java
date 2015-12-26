package com.mridwan.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment implements AdapterView.OnItemClickListener{

    private ArrayAdapter<String> forecastAdapter;

    public ForecastFragment() {
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

        forecastAdapter = new ArrayAdapter<String>(
                                this.getActivity(),
                                R.layout.list_item_forecast,
                                R.id.list_item_forecast_textview,
                                weekForecast);

        ListView listView = (ListView)view.findViewById(R.id.listview_forecast);
        listView.setAdapter(forecastAdapter);
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.forecastfragment,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String city = "Jakarta";
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            // kick off weather task
            FetchWeatherTask fetchWeatherTask = new FetchWeatherTask(forecastAdapter);
            fetchWeatherTask.execute(city);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Implement click listener
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        Toast toast = Toast.makeText(this.getContext(),textView.getText(),Toast.LENGTH_SHORT);
        toast.show();
    }
}
