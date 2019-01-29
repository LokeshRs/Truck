package adefault.loginscreen;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

import static android.content.ContentValues.TAG;

public class FragmentActivity extends AppCompatActivity {

   Button picasso_btn;
   Button async_btn;
   ImageView picasso_img;
   ImageView async_img;
    Bitmap abit;
    String url = "http://www.pngall.com/wp-content/uploads/2017/05/Congratulation-Download-PNG.png";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

    }

}
