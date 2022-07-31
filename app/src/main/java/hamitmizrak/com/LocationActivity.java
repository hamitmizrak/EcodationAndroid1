package hamitmizrak.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity {

    //konum izni
    public void isPermissionLocation(){
        if(  (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
                || (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED) )    {
            //String,requestCode 23==> eşleşmek için kullanıyoruz.
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},23);
            Toast.makeText(getApplicationContext(), "Konum İzin Verilmemiştir eşleşme yapılması gerekiyor", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Konum İzin Alınmıştır.", Toast.LENGTH_SHORT).show();
            //Bizim enlem ve boylamı bulan metot
            getLocationLongitudeLatitude();
        }
    }

    //camera requestCode karşılaştırmasını sağlanacak metot
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //KONUM
        //isPermissionLocation ==> requestCode yani 23 sayısını karşılaştıracağım
        if (requestCode == 23 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Konum 23 eşleşmesi yapıldı", Toast.LENGTH_SHORT).show();
            //eğer eşleşme olursa bizim konumumuzu yani enlem ve boylam gösteren metot çalışsın
            getLocationLongitudeLatitude();
        } else {
            Toast.makeText(getApplicationContext(), "!!!! Konum 23 eşleşmesi yapılmadı", Toast.LENGTH_SHORT).show();
        }

    }

    //Bizim enlem ve boylamı bulan metot
    private void getLocationLongitudeLatitude() {
        //konum izinleri verilmişse
        if( (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
                && (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED)){
            LocationManager locationManager= (LocationManager) getSystemService(LOCATION_SERVICE);
            Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);//bilinen son konum almak

            //enlem
            double latitude=location.getLatitude();
            Toast.makeText(getApplicationContext(), "ENLEM: "+ String.valueOf(latitude), Toast.LENGTH_LONG).show();
            Log.e("ENLEM: ",String.valueOf(latitude));

            //boylam
            double longitude=location.getLongitude();
            Toast.makeText(getApplicationContext(), "BOYLAM: "+ String.valueOf(longitude), Toast.LENGTH_LONG).show();
            Log.e("BOYLAM: ", String.valueOf(longitude));
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        //Camera izni
        if(Build.VERSION.SDK_INT>=23){
            Toast.makeText(getApplicationContext(), "Android SDK 23 veya üstünde sürüm kullanıyorsunuz", Toast.LENGTH_SHORT).show();
            isPermissionLocation();
        }else{
            Toast.makeText(getApplicationContext(), "Zaten İzin almadan Konumu kullanabilirsiniz", Toast.LENGTH_SHORT).show();
        }
    }
}