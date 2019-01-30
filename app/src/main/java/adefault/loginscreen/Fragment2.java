package adefault.loginscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.plus.PlusOneButton;

import java.io.InputStream;
import java.net.URL;

public class Fragment2 extends Fragment {

    Button async_btn;
    ImageView async_img;
    String url="http://www.pngall.com/wp-content/uploads/2017/05/Congratulation-Download-PNG.png";
    Bitmap abit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        async_btn = (Button)view.findViewById(R.id.async_btn);
        async_img = (ImageView) view.findViewById(R.id.async_img);
        async_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoadImg().execute();
            }
        });


        return view;
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
            async_img.setImageBitmap(abit);


        }


    }

}