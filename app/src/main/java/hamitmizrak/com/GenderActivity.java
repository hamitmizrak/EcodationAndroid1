package hamitmizrak.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class GenderActivity extends AppCompatActivity {

    //radio Button
    Button buttonRadio;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;

    //Gelen Activity data
    Intent intent;
    TextView textViewIndentKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        //Gelen activity datasını almak
        intent=getIntent();
        String inputData=intent.getStringExtra("key_activity");
        textViewIndentKey=findViewById(R.id.textViewIndentKey);
        textViewIndentKey.setText(inputData);

        // Ödev Register Form
        // 1.adım ==> RegisterActivity adında activity oluşturalım
        // 2.adım ==> EditText attributes: username,userSurname,userPassword,email olsun.
        // 3.adım ==>


        //RadioButton
        radioGroup = findViewById(R.id.radioGroupId);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton1 = findViewById(R.id.radioButton2);
        buttonRadio = findViewById(R.id.buttonRadioId);

        buttonRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioCheckButtonId = radioGroup.getCheckedRadioButtonId();
                switch (radioCheckButtonId) {
                    case R.id.radioButton1:
                        String value1 = "Bayan Seçildi";
                        System.out.println("Bayan Seçildi");
                        Toast.makeText(getApplicationContext(), value1, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radioButton2:
                        System.out.println("Erkek Seçildi");
                        String value2 = "Erkek Seçildi";
                        Toast.makeText(getApplicationContext(), value2, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}