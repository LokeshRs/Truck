package adefault.loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyActivity extends AppCompatActivity {

    ListView volley_list;
    TextView volley_resp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        volley_list=(ListView)findViewById(R.id.volley_lists);
        volley_resp=(TextView)findViewById(R.id.volley_resp);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url="https://swapi.co/api/planets/";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        volley_resp.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volley_resp.setText("That didn't work!");
            }
        });

    }
}
