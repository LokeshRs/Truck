package adefault.loginscreen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import adefault.loginscreen.R;
import adefault.loginscreen.model.Planet;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    private LayoutInflater inflater;
    public PlanetAdapter(Context context, ArrayList<Planet> planets){
        super(context, R.layout.planet_item, planets);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        convertView = inflater.inflate(R.layout.planet_item, null);
        Planet planet = getItem(position);
        //TextVier.setTextt(planet.name)
        return convertView;
    }
}
