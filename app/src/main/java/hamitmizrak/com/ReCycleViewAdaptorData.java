package hamitmizrak.com;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


//RecyclerViewHolder: subClass oluşturacağız.
public class ReCycleViewAdaptorData extends RecyclerView.Adapter<ReCycleViewAdaptorData.RecyclerViewHolder> {

    //Array listem
    ArrayList<Message> list;

    //parametreli contructor
    public ReCycleViewAdaptorData(ArrayList<Message> list) {
        this.list = list;
    }

    //SUB CLASS
    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        //parametreli sub class consttructor
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImageView);
            textView = itemView.findViewById(R.id.itemTextView);
        }
    }

    //Resim çizmek yani görüntü oluşturmak
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new RecyclerViewHolder(view);
    }

    // listedeki her bir elemanın göstermek
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
    holder.textView.setText(list.get(position).getName());
    holder.imageView.setImageResource(list.get(position).getPhoto());
    }

    //listede eleman kadar ekranda göster
    @Override
    public int getItemCount() {
        return list.size();
    }


}
