package adefault.loginscreen;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static adefault.loginscreen.R.id.button_login;
import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    Button n;
    EditText email;
    EditText pwd;
    TextView link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n = (Button)findViewById(button_login);

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = (EditText) findViewById(R.id.email_id);
                pwd = (EditText) findViewById(R.id.pass_id);
                if(email.getText().toString().equals("abc@123") && pwd.getText().toString().equals("1234")) {

                    Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                }
                else
                {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.login_fail);
                    builder.setMessage(R.string.msg);
                    builder.show();



                }

            }
        });
        link = findViewById(R.id.link);
        link.setClickable(true);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.truckbrokers.in/#'>WebPage </a>";
        link.setText("For Further Details Click here - "+Html.fromHtml(text));

        }
}
