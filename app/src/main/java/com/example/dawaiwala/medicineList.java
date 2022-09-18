package com.example.dawaiwala;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Adapters.MedicineAdapter;
import com.example.dawaiwala.Models.medicinesModel;
import com.example.dawaiwala.databinding.ActivityMedicineListBinding;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class medicineList extends AppCompatActivity {

    RecyclerView recyclerView;
    ActivityMedicineListBinding binding1;
    DatabaseReference patientDbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding1 = ActivityMedicineListBinding.inflate(getLayoutInflater());


        setContentView(binding1.getRoot());



        recyclerView=findViewById(R.id.recyclerView);

        ArrayList<medicinesModel> list=new ArrayList<>();

        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"abc","400"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"cde","600"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"def","700"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"ghi","800"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"jkl","900"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"mno","200"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"pqr","1000"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"stu","7000"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"vwx","850"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"abc","650"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"abc","6750"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"abc","656"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"abc","777"));
        list.add(new medicinesModel(R.drawable.ic_medicines_icon,"abc","206"));

        MedicineAdapter adapter=new MedicineAdapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
          recyclerView.setLayoutManager(layoutManager);




    }
}