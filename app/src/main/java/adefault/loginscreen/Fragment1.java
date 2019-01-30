package adefault.loginscreen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.plus.PlusOneButton;
import com.squareup.picasso.Picasso;


public class Fragment1 extends Fragment {


     Button picasso_btn;
     ImageView picasso_img;
     String url="http://www.pngall.com/wp-content/uploads/2017/05/Congratulation-Download-PNG.png";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        picasso_btn = (Button)view.findViewById(R.id.picasso_btn);
        picasso_img = (ImageView)view.findViewById(R.id.picasso_img);
        picasso_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(view.getContext()).load(url).into(picasso_img);
            }
        });

        return view;

    }
}