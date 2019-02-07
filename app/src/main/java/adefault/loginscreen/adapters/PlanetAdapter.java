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
    public PlanetAdapter(Context context, int activity_volley, ArrayList<Planet> planets){
        super(context, R.layout.planet_item, planets);
        inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        Planet planet = getItem(position);
        convertView = inflater.inflate(android.R.layout.simple_list_item_1,null);
        //convertView = inflater.inflate(R.layout.support_simple_spinner_dropdown_item, null);
        listview = v.findViewById(R.id.volley_lists);
        return convertView;
    }
}
