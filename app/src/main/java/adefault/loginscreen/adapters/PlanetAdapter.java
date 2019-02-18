package adefault.loginscreen.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import adefault.loginscreen.ListsActivity;
import adefault.loginscreen.LokeshActivity;
import adefault.loginscreen.R;
import adefault.loginscreen.VolleyActivity;
import adefault.loginscreen.model.Planet;

import static android.support.v4.content.ContextCompat.startActivity;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    private LayoutInflater inflater;
    ListView listview;
    View v;
    public PlanetAdapter(Context context, ArrayList<Planet> planets){
        super(context, R.layout.planet_item, planets);
        inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        Planet planet = getItem(position);
        convertView = inflater.inflate(R.layout.planet_item,null);
        TextView title= convertView.findViewById(R.id.title);
        TextView population = convertView.findViewById(R.id.population);
        TextView climate = convertView.findViewById(R.id.climate);
        title.setText(planet.name);
        String pop = String.format("Population: &s",planet.population);
        population.setText(pop);
        climate.setText("Climate : "+planet.climate);

        return convertView;
    }
}
