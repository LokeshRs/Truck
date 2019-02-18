package adefault.loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import adefault.loginscreen.model.Planet;

public class PlanetDetails extends AppCompatActivity {

    TextView rotation_period, climate, population,title,diamter,gravity,surface_water;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);
        rotation_period = findViewById(R.id.rotationPeriod);
        climate = findViewById(R.id.climate);
        population = findViewById(R.id.population);
        title=findViewById(R.id.title);
        rotation_period.setText(getIntent().getStringExtra("rotation_period"));
        climate.setText(getIntent().getStringExtra("climate"));
        population.setText(getIntent().getStringExtra("population"));
        title.setText(getIntent().getStringExtra("title"));
        Planet planet = (Planet) getIntent().getSerializableExtra("planet");


    }
}
