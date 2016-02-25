package com.example.yggdralisk.flyhighconference;

import android.content.ClipData;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yggdralisk on 25.02.16.
 */
public class DrawerAdapter extends ArrayAdapter<DrawerItem> {
    private Context context;
    private List<DrawerItem> items;
    private int textViewResourceId = -1;

    public DrawerAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public DrawerAdapter(Context context, int textViewResourceId, List<DrawerItem> items) {
        super(context, textViewResourceId, items);

        this.context = context;
        this.items = items;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView;
        if (textViewResourceId != -1)
            rowView = inflater.inflate(textViewResourceId, parent, false);
        else
            rowView = inflater.inflate(R.layout.drawer_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.drawer_item_text);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.drawer_item_image);
        textView.setText(items.get(position).text);
        imageView.setImageResource(items.get(position).iconId);

        return rowView;
    }

    public DrawerItem getItemAt(int position)
    {
        return items.get(position);
    }
}