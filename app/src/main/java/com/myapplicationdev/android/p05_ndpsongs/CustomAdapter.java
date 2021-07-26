package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvsong = rowView.findViewById(R.id.tvSong);
        TextView tvsinger = rowView.findViewById(R.id.tvSinger);
        TextView tvstar = rowView.findViewById(R.id.tvStar);
        TextView tvyear = rowView.findViewById(R.id.tvYear);

        Song currentVersion = versionList.get(position);


        // Set values to the TextView to display the corresponding information
        tvsong.setText(currentVersion.getTitle());
        tvsinger.setText(currentVersion.getSingers());
        tvyear.setText(Integer.toString(currentVersion.getYearReleased()));
        tvstar.setText(currentVersion.toString());

        return rowView;
    }
}
