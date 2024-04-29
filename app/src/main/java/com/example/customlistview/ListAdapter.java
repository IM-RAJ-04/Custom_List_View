package com.example.customlistview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Phone> { // 1. Perbaikan generic type di kelas ArrayAdapter

    private final ArrayList<Phone> list; // 2. Menyesuaikan tipe data ArrayList
    private final Activity act;

    // 3. Menambahkan badan konstruktor dengan parameter
    public ListAdapter(Activity context, ArrayList<Phone> objects) {
        super(context, R.layout.item, objects);
        this.list = objects;
        this.act = context;
    }

    static class ViewHolder {
        protected ImageView icon;
        protected TextView nama;
        protected TextView keterangan;
    }

    // 4. Menambahkan @Override untuk menandai bahwa ini adalah penggantian metode dari superclass
    @SuppressLint("InflateParams")
    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        // Inisialisasi holder
        if (view == null) {
            LayoutInflater inflater = act.getLayoutInflater();
            view = inflater.inflate(R.layout.item, null);

            holder = new ViewHolder();
            holder.icon = view.findViewById(R.id.item_icon);
            holder.nama = view.findViewById(R.id.item_nama);
            holder.keterangan = view.findViewById(R.id.item_keterangan);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Set data ke holder
        Phone phone = list.get(position);
        holder.icon.setImageResource(R.drawable.ico);
        holder.nama.setText(phone.getName());
        holder.keterangan.setText(phone.getBrand());

        return view;
    }
}