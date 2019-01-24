package adefault.loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button n = (Button)findViewById(R.id.button_login);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = (EditText) findViewById(R.id.email_id);
                EditText pwd =(EditText) findViewById(R.id.pass_id);
                if(email.getText().toString().equals("abc@123") && pwd.getText().toString().equals("1234")) {
                    Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                }
                else
                {
                    Intent myIntent = new Intent(MainActivity.this, loginFailed.class);
                    startActivity(myIntent);
                }
            }
        });
    }
}
