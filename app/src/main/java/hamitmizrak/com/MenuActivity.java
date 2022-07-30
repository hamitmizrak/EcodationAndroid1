package hamitmizrak.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    //menumüzün çalışması için gerekli metot
    @Override
    public boolean onCreateOptionsMenu(Menu tempMenu) {

        //menu.xml dosyasınını inflate etmek
        getMenuInflater().inflate(R.menu.menu,tempMenu);
        return super.onCreateOptionsMenu(tempMenu);
    }

    //menüdeki itemlara tıkladığımda çalışacak metot
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int choice=item.getItemId();
        switch (choice){
            case R.id.menu1:
                Toast.makeText(getApplicationContext(), "Menu 1 Seçildi", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(), "Menu 2 Seçildi", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), "seçim yapılmadı", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Proje açıldığında ilk açılacak method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}