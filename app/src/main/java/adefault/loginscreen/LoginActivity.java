package adefault.loginscreen;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class LoginActivity extends AppCompatActivity {


    boolean start,stop;
    int pbvalue;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final ProgressBar pb = (ProgressBar)findViewById(R.id.progrees_bar);
        Button strt = (Button)findViewById(R.id.start_button);
        Button stp = (Button)findViewById(R.id.stop_button);

        strt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);
            }
        });
        stp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             pb.setVisibility(View.GONE);
            }
        });

    }
}
