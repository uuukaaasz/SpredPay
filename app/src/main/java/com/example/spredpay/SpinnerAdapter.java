package com.example.spredpay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter<String> {
    Context context;
    String[] names;
    int[] images;

    public SpinnerAdapter(Context context, String[] names, int[] images) {
        super(context, R.layout.swap_spinner, names);
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.swap_spinner, null);
        TextView t1 = row.findViewById(R.id.spinner_txt_bank);
        ImageView i1 = row.findViewById(R.id.spinner_img_bank);

        t1.setText(names[position]);
        i1.setImageResource(images[position]);

        return row;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.swap_spinner, null);
        TextView t1 = row.findViewById(R.id.spinner_txt_bank);
        ImageView i1 = row.findViewById(R.id.spinner_img_bank);

        t1.setText(names[position]);
        i1.setImageResource(images[position]);

        return row;
    }
}
