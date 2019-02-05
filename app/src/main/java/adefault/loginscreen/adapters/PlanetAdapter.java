package adefault.loginscreen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import adefault.loginscreen.R;
import adefault.loginscreen.model.Planet;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    private LayoutInflater inflater;
    ListView listview;
    View v;
    public PlanetAdapter(Context context, int activity_volley, ArrayList<Planet> planets){
        super(context, R.layout.planet_item, planets);
        inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        //convertView = inflater.inflate(R.layout.planet_item, null);
        convertView = inflater.inflate(R.layout.planet_item, null);
        Planet planet = getItem(position);
        //TextView title=v.findViewById(R.id.text1);
        return convertView;
    }
}
