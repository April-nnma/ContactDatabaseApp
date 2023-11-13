package com.example.contactdatabaseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<ContactModel> contactList;

    public ContactAdapter(List<ContactModel> contactList) {
        this.contactList = contactList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName,textViewDOB, textViewEmail, contactId;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.editTextName);
            textViewDOB = itemView.findViewById(R.id.editTextDOB);
            textViewEmail = itemView.findViewById(R.id.editTextEmail);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel contact = contactList.get(position);
        holder.textViewName.setText("Name: " + contact.getName());
        holder.textViewDOB.setText("DOB: " + contact.getDob());
        holder.textViewEmail.setText("Email: " + contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
