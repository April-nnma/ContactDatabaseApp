package com.example.contactdatabaseapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ViewContactActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
//    private ContactAdapter contactAdapter;
//
//    @SuppressLint("MissingInflatedId")
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        Intent intent = getIntent();
//        if (intent != null && intent.hasExtra("contactList")) {
//            List<ContactModel> contactList = (List<ContactModel>) intent.getSerializableExtra("contactList");
//
//            if (contactList != null && contactList.size() > 0) {
//                // Hiển thị danh sách liên hệ bằng RecyclerView
//                contactAdapter = new ContactAdapter(contactList);
//                recyclerView.setAdapter(contactAdapter);
//            }
//        }
//    }
}
