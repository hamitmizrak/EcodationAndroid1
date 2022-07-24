package hamitmizrak.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ReCycleViewActivity extends AppCompatActivity {

    //global varaible
    ReCycleViewAdaptorData adaptor;
    ArrayList<Message> list;
    RecyclerView recyclerView;

    //message fake loading
    public void fakeMessageLoading(){
        String dataStr="Lorem Ipsum is simply dummy   an unknown printer took a galley of type and scrambled it to make a type specimen book";
        Message message1=new Message("Çiçek "+dataStr,R.drawable.flowers);
        list.add(message1);

        Message message2=new Message("Otobüs "+dataStr,R.drawable.car);
        list.add(message2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_cycle_view);

        //instance oluşturduk
        list=new ArrayList<>();
        adaptor=new ReCycleViewAdaptorData(list);
        recyclerView=findViewById(R.id.recyclerViewId);

        //sıralamak
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adaptor);
        fakeMessageLoading();
    }
}