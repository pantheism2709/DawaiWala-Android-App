package com.example.dawaiwala;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyDose extends AppCompatActivity {

    ListView listView;
    private FirebaseAuth auth;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dose);

        listView=findViewById(R.id.myList);

        auth=FirebaseAuth.getInstance();
        ArrayList<String> list=new ArrayList<>();
        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.list_layout,list);
        listView.setAdapter(adapter);

        FirebaseUser user=auth.getCurrentUser();

        DatabaseReference dbref= FirebaseDatabase.getInstance().getReference().child("Patients").child(user.getUid().toString()).child("name");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

//                String s=snapshot.child("name").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        DatabaseReference refrence= FirebaseDatabase.getInstance().getReference().child("medicine").child(user.getUid().toString());
        refrence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    ArrayList<String>temp=new ArrayList<>();
                    for(DataSnapshot snapshot2:snapshot1.getChildren()) {
                        temp.add(snapshot2.getValue().toString());

                    }

                    list.add("Name : " + temp.get(0)+"                 Price : $" + temp.get(1));


                }

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn=findViewById(R.id.setAlarm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyDose.this,AlarmSet.class);
                startActivity(intent);
            }
        });



    }
}