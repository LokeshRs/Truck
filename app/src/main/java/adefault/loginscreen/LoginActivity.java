package adefault.loginscreen;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {


    boolean start, stop;
    int pbvalue;
    Button load_img;
    ImageView img;
    Bitmap bit;
    String url = "http://www.pngall.com/wp-content/uploads/2017/05/Congratulation-Download-PNG.png";
    Button next;
    Button list;
    Button volley;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       /* img = (ImageView) findViewById(R.id.url_image);
        load_img = (Button) findViewById(R.id.load_button);*/
        next = (Button) findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(LoginActivity.this, FragmentActivity.class);
                startActivity(myIntent);
            }
        });

        list=(Button)findViewById(R.id.list_button);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent2 = new Intent(LoginActivity.this, ListsActivity.class);
                startActivity(myIntent2);
            }
        });
        volley=(Button) findViewById(R.id.volley_button);
        volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent3= new Intent(LoginActivity.this,VolleyActivity.class);
                startActivity(myIntent3);
            }
        });
    }
}
