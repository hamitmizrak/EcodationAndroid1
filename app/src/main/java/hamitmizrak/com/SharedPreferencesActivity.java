package hamitmizrak.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity {

    //global variable
    EditText editTextPreferencesId;
    Button buttonReferences;
    TextView textViewPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        //start codes

        //id almak
        editTextPreferencesId = findViewById(R.id.editTextPreferencesId);
        textViewPreferences = findViewById(R.id.textViewPreferences);
        buttonReferences = findViewById(R.id.buttonReferences);

        //NOT:
        //sadece bu activity için çalış
        //final SharedPreferences sharedPreferences2=this.getPreferences();

        //bütün activity kullanabilir
        // final SharedPreferences sharedPreferences = this.getSharedPreferences("sharedPreferences", MODE_PRIVATE);

        //sharered Preferences
        final SharedPreferences sharedPreferences = this.getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        final String data=sharedPreferences.getString("key_references","defaulttaki veriler 44");

        //textView dodlurmak
        textViewPreferences.setText(data);

        //button Onclick
        buttonReferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kullanıcıdan alınan veriyi almak için
                String  value44=editTextPreferencesId.getText().toString();
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("key_references",value44);
                editor.apply();
            }
        });
        //end codes
    }
}