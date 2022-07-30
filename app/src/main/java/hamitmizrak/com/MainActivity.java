package hamitmizrak.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    //Global Variable


    //Menu Button
    Button menuButtonId;

    //local storage
    Button localStorageButton;

    //realtime Database
    Button realtimeDatabase;

    //ReCycleView Button
    Button reCycleViewId;

    //ListViewIndent
    Button otherListViewButton;

    //Diğer Activity veri taşımak
    EditText editTextOtherActivityDataSubmit;
    Button buttonOtherActivityData;

    //Diğer Activity Geçiş
    Button otherActivityButton;

    //firebase login Telephone
    FirebaseAuth firebaseAuth;
    EditText editTextValidationPhoneNumber;
    EditText editTextValidationCodeNumber;
    Button editTextValidationButton;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks myCallBack;
    String verificationId;

    //Doğrulamayı başlatan metot
    public void startVerification() {
        //60saniye boyunca girebilsin yoksa  kod iptal olur
        PhoneAuthProvider.getInstance().verifyPhoneNumber(editTextValidationPhoneNumber.getText().toString(), 60, TimeUnit.SECONDS, this, myCallBack);
    }

    //ProgressBar
    ProgressBar progressBar;

    //FAB
    FloatingActionButton floatingActionButton;

    //Glide:internetteki resimleri almak
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

       //menuButton
        menuButtonId = findViewById(R.id.menuButtonId);
        menuButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent=new Intent(getApplicationContext(),MenuActivity.class);
                Toast.makeText(getApplicationContext(),"Menu Activity Geçiş yapıldı",Toast.LENGTH_SHORT);
                startActivity(menuIntent);
            }
        });

        //localStorage
        localStorageButton = findViewById(R.id.localStorageButton);
        localStorageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent localStorage = new Intent(getApplicationContext(), LocalStorageView.class);
                Toast.makeText(getApplicationContext(), "Local Storage Giriliyor", Toast.LENGTH_LONG);
                startActivity(localStorage);
            }
        });

        //realtimeDatabase
        realtimeDatabase = findViewById(R.id.realtimeDatabase);
        realtimeDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reCycleIntent = new Intent(getApplicationContext(), RealtimeDatabaseActivity.class);
                Toast.makeText(getApplicationContext(), "Realtime database Activity Geçiş yapıldı", Toast.LENGTH_LONG).show();
                startActivity(reCycleIntent);
            }
        });

        //reCycleView
        reCycleViewId = findViewById(R.id.reCycleViewId);
        reCycleViewId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reCycleIntent = new Intent(getApplicationContext(), ReCycleViewActivity.class);
                Toast.makeText(getApplicationContext(), "Re Cycle View Activity Geçiş yapıldı", Toast.LENGTH_LONG).show();
                startActivity(reCycleIntent);
            }
        });

        //ListViewButton
        otherListViewButton = findViewById(R.id.otherListView);
        otherListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewIntent = new Intent(getApplicationContext(), ListViewActivity.class);
                String data = "ListView Activity Geçiş yapıldı";
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
                startActivity(listViewIntent);
            }
        });

        //Diğer Activity arasında veri göndermek
        editTextOtherActivityDataSubmit = findViewById(R.id.editTextOtherActivityDataSubmit);
        buttonOtherActivityData = findViewById(R.id.buttonOtherActivityData);
        buttonOtherActivityData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GenderActivity.class);
                String editData = editTextOtherActivityDataSubmit.getText().toString();
                intent.putExtra("key_activity", editData);
                Toast.makeText(getApplicationContext(), "Diğer Activity'e gödnerildi", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        //Diğer Activity Geçiş
        otherActivityButton = findViewById(R.id.otherActivityRadioGroupId);
        otherActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GenderActivity.class);
                String data = "Cinsiyet Activity Geçiş yapıldı";
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        //Telephone Login
        firebaseAuth = FirebaseAuth.getInstance();
        editTextValidationPhoneNumber = findViewById(R.id.validationPhoneNumber);
        editTextValidationCodeNumber = findViewById(R.id.validationCodeNumber);
        editTextValidationButton = findViewById(R.id.validationButton);

        //myCallBackFunction
        myCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            //koda gerek duymadan giriş yapmak
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                firebaseAuth.signInWithCredential(phoneAuthCredential);
                Toast.makeText(getApplicationContext(), "Kodsuz Giriş Yapıldı", Toast.LENGTH_SHORT).show();
            }

            //Koda giriş yaparken hata olduğunda
            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Log.e("TAG", e.getLocalizedMessage());
                Toast.makeText(getApplicationContext(), " giriş yaparken hata olduğunda", Toast.LENGTH_SHORT).show();
            }

            //kod gönderildikten sonra çalışacak kod
            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationId = s;
                editTextValidationButton.setText("Validation Code ");
                Toast.makeText(getApplicationContext(), " Kod Gönderildi", Toast.LENGTH_SHORT).show();
            }
        };

        //firebase button Listener
        editTextValidationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificationId != null) {
                    //sisteme giriş yapalım
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, editTextValidationCodeNumber.getText().toString());
                    firebaseAuth.signInWithCredential(phoneAuthCredential);
                    //sistem kendisi telefon olmadığı için firebase sitesinde test code oluşturmalıyım.
                } else {
                    //sistem kendisi telefon olmadığı için firebase sitesinde test code oluşturmalıyım.
                    Toast.makeText(getApplicationContext(), "startVerification çalıştı", Toast.LENGTH_SHORT).show();
                    startVerification();
                }
            }
        });

        //prograssbar
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        //fab
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Fab çalıştı", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        //AlertDialog
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("Başlık");
        alertBuilder.setMessage("Mesaj Bölgesi");
        alertBuilder.show();

        //Toast
        Toast.makeText(getApplicationContext(), "Merhabalar", Toast.LENGTH_LONG).show();

        //confirm: positiveButton
        AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(MainActivity.this);
        alertBuilder2.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Evet Onay verdiniz", Toast.LENGTH_LONG).show();
            }
        });
        //confirm: negativeButton
        alertBuilder2.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Hayır Onay vermedinizzzz.", Toast.LENGTH_LONG).show();
            }
        });
        alertBuilder2.show();

        //Glide:internetteki resimleri almak için kullanıyoruz
        imageViewGlide = findViewById(R.id.imageViewGlide);
        String URL = "https://img-c.udemycdn.com/user/200_H/47717582_5cbb_2.jpg";
        Glide.with(getApplicationContext()).load(URL).into(imageViewGlide);

        //id almamız
        textView = findViewById(R.id.textViewExam1);
        editText = findViewById(R.id.editTextExamp1);
        button = findViewById(R.id.buttonExamp1);
        imageView = findViewById(R.id.imageViewExam1);
        imageView.setImageResource(R.drawable.flowers);
        //onClickListener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Title", "Click success");
                String editData = editText.getText().toString();
                Toast.makeText(getApplicationContext(), editData, Toast.LENGTH_LONG).show();
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