package hamitmizrak.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {

    //camera izni almak: ==> kullanıcı tarafından camera izni verilmiş mi verilmemiş mi ?
    public void isPermissionCamera() {
        //izin verilmemişse   GRANTED:izin verilmiş anlamına gelir
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //String,requestCode==> eşleşmek için kullanıyoruz.
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 44);
            Toast.makeText(getApplicationContext(), "Kamera İzin Verilmemiştir eşleşme yapılması gerekiyor", Toast.LENGTH_SHORT).show();
        } else {//izin verilmişse
            Toast.makeText(getApplicationContext(), "Kamera İzni Verilmiştir", Toast.LENGTH_SHORT).show();
        }
    }

    //camera requestCode karşılaştırmasını sağlanacak metot
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //KAMERA
        //isPermissionCamera ==> requestCode yani 44 sayısını karşılaştıracağım
        if (requestCode == 44 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Kamera 44 eşleşmesi yapıldı", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "!!!! Kamera 44 eşleşmesi yapılmadı", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //Camera izni
        if(Build.VERSION.SDK_INT>=23){
            Toast.makeText(getApplicationContext(), "Android SDK 23 veya üstünde sürüm kullanıyorsunuz", Toast.LENGTH_SHORT).show();
            isPermissionCamera();
        }else{
            Toast.makeText(getApplicationContext(), "Zaten İzin almadan Kamerayı kullanabilirsiniz", Toast.LENGTH_SHORT).show();
        }
    }
}