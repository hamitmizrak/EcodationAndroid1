package hamitmizrak.com;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RealtimeDatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime_database);

        //databaseReference: Firebase sitesinde ==> Database ==> Data referans alacaktır.
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("secretID").child("username");
        //username verisindeki veriyi verecek
        Log.e("Direk KEY: ", databaseReference.getKey());


        //username alt tarafına random unique bir key ve değer ekleyelim
        DatabaseReference databaseReference2=databaseReference.push();
        databaseReference2.setValue("x deneme");


        //Ana branch bütün KEY
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.e("Bütün KEY",snapshot.getKey());
               // Log.e("Bütün ValueVALUE: ",snapshot.getValue().toString());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}