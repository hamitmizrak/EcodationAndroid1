package hamitmizrak.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    //Global Variable
    ImageView imageViewGlide;

    //ornek
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

        //AlertDialog
        AlertDialog.Builder alertBuilder=new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("Başlık");
        alertBuilder.setMessage("Mesaj Bölgesi");
        alertBuilder.show();

        //Toast
        Toast.makeText(getApplicationContext(),"Merhabalar",Toast.LENGTH_LONG).show();

        //confirm: positiveButton
        AlertDialog.Builder alertBuilder2=new AlertDialog.Builder(MainActivity.this);
        alertBuilder2.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Evet Onay verdiniz",Toast.LENGTH_LONG).show();
            }
        });
        //confirm: negativeButton
        alertBuilder2.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Hayır Onay vermedinizzzz.",Toast.LENGTH_LONG).show();
            }
        });
        alertBuilder2.show();

        //Glide:internetteki resimleri almak için kullanıyoruz
        imageViewGlide=findViewById(R.id.imageViewGlide);
        String URL="https://img-c.udemycdn.com/user/200_H/47717582_5cbb_2.jpg";
        Glide.with(getApplicationContext()).load(URL).into(imageViewGlide);

        //id almamız
        textView=findViewById(R.id.textViewExam1);
        editText=findViewById(R.id.editTextExamp1);
        button=findViewById(R.id.buttonExamp1);
        imageView=findViewById(R.id.imageViewExam1);
        imageView.setImageResource(R.drawable.flowers);
         //onClickListener
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