package com.example.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cngnt.intentsss.R;
import com.example.modle.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<Contact> contacts;
    private Context context;
    private LayoutInflater inflater;
    public ContactAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewm = inflater.inflate(R.layout.item_layout, viewGroup,false);
        return new ContactViewHolder(viewm);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder contactViewHolder, int i) {
        Contact contact = contacts.get(i);
        contactViewHolder.tvFullName.setText(contact.getmFullname());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        itemView.setClickable(true);
        tvFullName = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
