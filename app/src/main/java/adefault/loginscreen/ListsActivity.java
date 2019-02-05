package adefault.loginscreen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView basic_list;
    String[] names = new String[]{"Lokesh", "Vishnu", "Roshan", "XYZ", "ABC"};
  //  NameAdapter adapter;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> defaultAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);
        basic_list = (ListView) findViewById(R.id.basic_list);


        //Why you need to do this you can pass String array
        for (int i = 0; i < names.length; i++)
            list.add(names[i]);
        //Put adapter as instance variable
       // final BasicList adapter = new BasicList(this, android.R.layout.simple_list_item_1, list);
       // basic_list.setAdapter(adapter);
       // adapter = new NameAdapter(this, android.R.layout.simple_list_item_single_choice, basic_list);
        defaultAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        //basic_list.setAdapter(adapter);
        basic_list.setOnItemClickListener(this);
       // basic_list.setAdapter(defaultAdapter);

    }

    @NonNull
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent a = new Intent(ListsActivity.this,LokeshActivity.class);
        String name = (String)adapterView.getItemAtPosition(i);
        a.putExtra("title", name);
        startActivity(a);
    }

    // Use name as ListAdapter o
    //BaseAdapter
   /* public class NameAdapter extends ArrayAdapter<String> {
        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

       /* public NameAdapter(Context context, int textViewResourceId, ListView objects) {

            super(context,textViewResourceId,objects);
            for (int i = 0; i < objects.getScrollBarSize(); ++i) {
                mIdMap.put(((List<String>) objects).get(i), i);
            }
        }

     @NonNull
     @Override
     public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
         String name = getItem(position);
         convertView = getLayoutInflater().inflate(android.R.layout.simple_list_item_single_choice, null);
         TextView title = convertView.findViewById(android.R.id.text1);
         title.setText(name);
         title.setAllCaps(true);
         if (position == 2){
             title.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
         }
         else
         title.setTextColor(getResources().getColor(android.R.color.holo_purple));
         return convertView;
     }


    }
    */
}
