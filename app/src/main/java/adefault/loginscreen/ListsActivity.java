package adefault.loginscreen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListsActivity extends AppCompatActivity {

    ListView basic_list;
    String[] names = new String[]{"Lokesh", "Vishnu", "Roshan", "XYZ", "ABC"};
    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);
        basic_list = (ListView) findViewById(R.id.basic_list);
        for (int i = 0; i < names.length; i++)
            list.add(names[i]);
        final BasicList adapter = new BasicList(this,android.R.layout.simple_list_item_1,list);
        basic_list.setAdapter(adapter);

    }

    public class BasicList extends ArrayAdapter<String> {
        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public BasicList(Context context, int textViewResourceId, List<String> objects) {

            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }
    }
}
