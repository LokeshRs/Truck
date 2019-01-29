package adefault.loginscreen;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

import static android.content.ContentValues.TAG;


public class FirstFragment extends Fragment {

    View v;
    Button picasso_btn;
    Button async_btn;
    ImageView picasso_img;
    ImageView async_img;
    Bitmap abit;
    String url = "http://www.pngall.com/wp-content/uploads/2017/05/Congratulation-Download-PNG.png";


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        picasso_img = (ImageView)v.findViewById(R.id.picasso_img);
        async_img =(ImageView)v.findViewById(R.id.async_btn);
        picasso_btn=(Button)v.findViewById(R.id.picasso_btn);
        async_btn=(Button)v.findViewById(R.id.async_btn);
        async_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoadImg().execute();
            }
        });
        return inflater.inflate(R.layout.first_fragment, container, false);
    }

    final class LoadImg extends AsyncTask<Void, Void, Void> {

            protected Void doInBackground(Void... voids) {
                try {
                    abit = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());


                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Log.i(TAG ,"Successful");
                async_img.setImageBitmap(abit);


            }


        }

    }


