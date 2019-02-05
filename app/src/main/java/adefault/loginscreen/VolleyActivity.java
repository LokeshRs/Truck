package adefault.loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import java.util.List;

import adefault.loginscreen.adapters.PlanetAdapter;
import adefault.loginscreen.model.Planet;

public class VolleyActivity extends AppCompatActivity {

    ListView volley_list;
    TextView volley_resp;
    ArrayList<Planet> planetsList = new ArrayList<>();
    PlanetAdapter adapter;
    Planet p = new Planet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        volley_list = (ListView) findViewById(R.id.volley_lists);
        volley_resp = (TextView) findViewById(R.id.volley_resp);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://swapi.co/api/planets/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
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
                                p.name = o.getString("name");
                                p.climate = o.getString("climate");
                                p.rotationPeriod = o.getString("rotation period");
                                p.population = o.getString("population");
                                Log.d("Planet", p.toString());

                            }
                        } catch (JSONException jsone) {
                            jsone.printStackTrace();
                        }

                        // set Adapter here
                        planetsList.add(p);
                        Log.d("PlanetsList", "" + planetsList.size());
                        adapter = new PlanetAdapter(VolleyActivity.this,R.layout.activity_volley,planetsList);
                        volley_list.setAdapter(adapter);
                        volley_resp.setText("Response is: "+ planetsList);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volley_resp.setText("That didn't work!");
            }
        });
        queue.add(jsonObjectRequest);

    }


}
