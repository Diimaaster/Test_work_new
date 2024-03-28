package test_work.card_item;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.khdev.test_work.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HelperAdapter extends RecyclerView.Adapter< HelperAdapter.MyViewClass > {
    ArrayList< String > Name;
    ArrayList< String > Sostav;
    ArrayList< String > Image;
    Context context;

    public HelperAdapter(ArrayList< String > Name, ArrayList< String > Sostav, ArrayList< String > Image, Context context) {
        this.Name = Name;
        this.Sostav = Sostav;
        this.Image = Image;
        this.context = context;
        Log.d("TEST_API", ("" + Name + Image));
    }
    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new MyViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {
        holder.Name.setText(Name.get(position));
        holder.Sostav.setText(Sostav.get(position));
        Picasso.get().load(Image.get(position)).into(holder.Image);
        //holder.Image.setText(Image.get(position));

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public int getItemCount() {
        return Name.size();
    }

    public static class MyViewClass extends RecyclerView.ViewHolder{
        TextView Name;
        TextView Sostav;
        ImageView Image;
        public MyViewClass(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.name);
            Sostav = itemView.findViewById(R.id.sostav);
            Image = itemView.findViewById(R.id.image);
        }
    }

}