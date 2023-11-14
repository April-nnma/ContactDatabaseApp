//package com.example.contactdatabaseapp;
//
//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class ViewContactActivity extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private ContactAdapter contactAdapter;
//    private List<ContactModel> contactList;
//    private DatabaseHelper databaseHelper;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_contact);
//
//        databaseHelper = new DatabaseHelper(this);
//        List<ContactModel> contacts = databaseHelper.getAllContacts();
//
//        recyclerView = findViewById(R.id.RVContact);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        contactList = databaseHelper.getAllContacts();
//        contactAdapter = new ContactAdapter(contactList);
//        recyclerView.setAdapter(contactAdapter);
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        reloadList();
//    }
//
//    private void reloadList() {
//        contactList.clear();
//        contactList.addAll(databaseHelper.getAllContacts());
//        contactAdapter.notifyDataSetChanged();
//    }
//}
//
package com.example.contactdatabaseapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewContactActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    private List<ContactModel> contactList;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        recyclerView = findViewById(R.id.RVContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve the contacts from the Intent
        List<ContactModel> contacts = getIntent().<ContactModel>getParcelableArrayListExtra("CONTACT_LIST");

        if (contacts != null) {
            // Log the number of contacts
            Log.d("ContactDatabase", "Number of contacts received: " + contacts.size());

            // Initialize the contact list
            contactList = contacts;
        } else {
            // If the list is null, create an empty list
            Log.e("ContactDatabase", "Contact list is null");
            contactList = new ArrayList<>();
        }

        // Initialize the adapter with the contact list
        contactAdapter = new ContactAdapter(contactList);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(contactAdapter);
    }

// Other existing methods...


    @Override
    protected void onResume() {
        super.onResume();
        reloadList();
    }

    private void reloadList() {
        List<ContactModel> contacts = getIntent().getParcelableArrayListExtra("CONTACT_LIST");
        if (contacts != null) {
            contactList.clear();
            contactList.addAll(contacts);
            contactAdapter.notifyDataSetChanged();
        }
    }
}

