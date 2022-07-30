package hamitmizrak.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SomePageDataActivity extends AppCompatActivity {

    //global variable
    Button fragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some_page_data);
        // start codes

        //Fragment
        //R.id.frameLayout ==> activity_main.xml
        //SpecialFragment1 ==> class
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SpecialFragment1()).commit();
        fragmentButton = findViewById(R.id.fragementButtonId);
        fragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SpecialFragment2()).commit();
            }
        });
        //end codes
    }
}