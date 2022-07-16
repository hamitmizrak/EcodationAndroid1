package hamitmizrak.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //projemiz açıldığında ilk görünen sayfadır.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("onCreate","ilk açılan");
    }

    //uygulamaladan çıkıp geri geldiğimde
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart","başladı");
    }

    //uygulamaladan çıktığımız an çalışan metot
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop","bitti");
    }

    //uygulamaladan çıktığımız an çalışan metot
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause","pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy","öldü");
    }
}