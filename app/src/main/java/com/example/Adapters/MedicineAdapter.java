package com.example.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dawaiwala.Models.medicinesModel;
import com.example.dawaiwala.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;


public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.viewHolder>
    {
        ArrayList<medicinesModel> list;
        Context context;

        public MedicineAdapter(ArrayList<medicinesModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_recyclerview,parent,false);
            return new viewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull viewHolder holder, int position) {

            medicinesModel model=list.get(position);

            holder.imageView.setImageResource(model.getPic());
            holder.textView.setText(model.getText());
            holder.priceTag.setText("$"+model.getPrice());
            HashMap<String , String > mp=new HashMap<>();

            mp.put("Name", model.getText());
            mp.put("Price",model.getPrice());


            holder.addToCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    DatabaseReference dbref= FirebaseDatabase.getInstance().getReference();
                    FirebaseAuth mauth=FirebaseAuth.getInstance();
                    FirebaseUser user=mauth.getCurrentUser();
                    String uid=user.getUid();

                    dbref.child("medicine").child(uid).push().setValue(mp);
                    Toast.makeText(view.getContext(), ""+model.getText(), Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public static class viewHolder extends RecyclerView.ViewHolder{

            public View democard;

         Button addToCard;
            ImageView imageView;
        TextView textView;
        TextView priceTag;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.med1);
            textView=itemView.findViewById(R.id.medName1);
            priceTag=itemView.findViewById(R.id.price1);

            democard=itemView.findViewById(R.id.democard);
               addToCard=itemView.findViewById(R.id.addToCard);


        }
    }


}
