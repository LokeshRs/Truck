package adefault.loginscreen;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import adefault.loginscreen.adapters.PlanetAdapter;
import adefault.loginscreen.model.Planet;
import static android.view.View.inflate;

public class VolleyActivity extends AppCompatActivity {

    ListView volley_list;
    ArrayList<Planet> planetsList = new ArrayList<>();
    PlanetAdapter adapter;
    Context context = VolleyActivity.this;
    Button next;
    Button previous;
    String next_url;
    String previous_url;
    RequestQueue queue;
    Pagination listextract;
    String n="";
    int count=1;
    TextView page_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        volley_list = findViewById(R.id.volley_lists);
        queue = Volley.newRequestQueue(this);
        listextract = new Pagination();
        String url = "https://swapi.co/api/planets/?page=1";

        listextract.listExtract(url);
        View footerView = inflate(context, R.layout.list_footer, null);
        Log.d("Inflater", "footer sucessfull");
        volley_list.addFooterView(footerView);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        page_no = findViewById(R.id.page_no);
        Log.d("URL CHECK", "" + next_url);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();
                listextract.listExtract(next_url);
                buttonEnable();
                count = count + 1;
                page_no.setText("Page No. - " + count);

            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();
                listextract.listExtract(previous_url);
                buttonEnable();
                count = count - 1;
                page_no.setText("Page No. - " + count);
            }
        });
        Log.d("URL CHECK", "" + previous_url);

        page_no.setText("Page No. - " + count);
    }
        public void buttonEnable () {
            if (next_url == n)
                next.setEnabled(false);
            else
                next.setEnabled(true);
            if (previous_url == n)
                previous.setEnabled(false);
            else
                previous.setEnabled(true);
        }

    class Pagination {
        public void listExtract(String url) {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.d("OnResponse",
                                        response.toString());
                                Log.d("OnResponse", "" + response.getInt("count"));
                                JSONArray planets = response.getJSONArray("results");
                                for (int i = 0; i < planets.length(); i++) {


                                    JSONObject o = planets.getJSONObject(i);
                                    Planet p = new Planet();
                                    p.name = o.getString("name");
                                    p.climate = o.getString("climate");
                                    p.rotationPeriod = o.getString("rotation_period");
                                    p.population = o.getString("population");
                                    Log.d("Planet", p.toString());
                                    planetsList.add(p);
                                }
                                next_url = response.getString("next");
                                previous_url = response.getString("previous");
                                Log.d("next URL", next_url);
                                Log.d("previous URL", previous_url);
                                // set Adapter here
                                Log.d("PlanetsList", "" + planetsList.size());
                                adapter = new PlanetAdapter(context, planetsList);
                                volley_list.setAdapter(adapter);

                                volley_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        Intent a = new Intent(VolleyActivity.this, PlanetDetails.class);
                                        Planet name = (Planet) adapterView.getItemAtPosition(i);
                                        a.putExtra("title", name.name);
                                        a.putExtra("climate", "Climate : " + name.climate);
                                        a.putExtra("rotation_period", "Roation Period : " + name.rotationPeriod);
                                        a.putExtra("population", "Population : " + name.population);
                                        a.putExtra("name", name);
                                        startActivity(a);

                                    }
                                });


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            queue.add(jsonObjectRequest);

        }
    }
}
           /* public void nextURL(String nurl){
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, nurl, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    Log.d("OnResponse",
                                            response.toString());
                                    Log.d("OnResponse", "" + response.getInt("count"));
                                    JSONArray planets = response.getJSONArray("results");
                                    for (int i = 0; i < planets.length(); i++) {


                                        JSONObject o = planets.getJSONObject(i);
                                        Planet p = new Planet();
                                        p.name = o.getString("name");
                                        p.climate = o.getString("climate");
                                        p.rotationPeriod = o.getString("rotation_period");
                                        p.population = o.getString("population");
                                        Log.d("Planet", p.toString());
                                        planetsList.add(p);
                                    }
                                    next_url = response.getString("next");
                                    previous_url = response.getString("previous");
                                    Log.d("next URL",next_url);
                                    Log.d("previous URL",previous_url);
                                    // set Adapter here
                                    Log.d("PlanetsList", "" + planetsList.size());
                                    volley_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                            Intent a = new Intent(VolleyActivity.this, PlanetDetails.class);
                                            Planet name = (Planet) adapterView.getItemAtPosition(i);
                                            a.putExtra("title", name.name);
                                            a.putExtra("climate", "Climate : " + name.climate);
                                            a.putExtra("rotation_period", "Roation Period : " + name.rotationPeriod);
                                            a.putExtra("population", "Population : " + name.population);
                                            a.putExtra("name", name);
                                            startActivity(a);

                                        }
                                    });


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
                queue.add(jsonObjectRequest);

            }
            } */







