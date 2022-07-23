package hamitmizrak.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    //global variable
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //start codes

        listView = findViewById(R.id.listViewId);
        String[] listData = {"Servlet", "JSP", "JSTL", "JSF", "Spring Framework", "SpringBoot"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // counter
            int counter = 1;

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Listem: ", listData[position]);
                Toast.makeText(getApplicationContext(), counter +" kez tıklandı " + listData[position], Toast.LENGTH_LONG).show();
                counter++;
            }
        });

        //end codes
    }
}