package hamitmizrak.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Global Variable
    TextView textView;
    EditText editText;
    Button button;
    ImageView imageView;


    //projemiz açıldığında ilk görünen sayfadır.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.e("onCreate", "ilk açılan");

        //id almamız
        textView=findViewById(R.id.textViewExam1);
        editText=findViewById(R.id.editTextExamp1);
        button=findViewById(R.id.buttonExamp1);
        imageView=findViewById(R.id.imageViewExam1);
        imageView.setImageResource(R.drawable.flowers);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Title","Click success");
                String editData=editText.getText().toString();
                textView.setText(editData);
            }
        });
    }

/*    //uygulamaladan çıkıp geri geldiğimde
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "başladı");
    }

    //uygulamaladan çıktığımız an çalışan metot
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "bitti");
    }

    //uygulamaladan çıktığımız an çalışan metot
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "öldü");
    }*/
}