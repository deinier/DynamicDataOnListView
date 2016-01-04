package com.indeit.android.listviewexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.indeit.android.listviewexample.R;

/**
 * Created by dmorales on 1/4/2016.
 */
public class DynamicAdapter extends ArrayAdapter<DataRow>
{
    private final Context context;

    private final DataRow[] data;

    public DynamicAdapter(Context context, DataRow[] data)
    {
        super(context, R.layout.row_layout, data);

        this.context = context;

        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row_layout, parent, false);

        // Get a listview reference
        LinearLayout linearLayoutRow = (LinearLayout) rowView.findViewById(R.id.coreLinear);

        if(position < data.length)
        {
            // Put text on header
            TextView textHeader = (TextView) rowView.findViewById(R.id.coreHeader);

            // Set the header for this row
            textHeader.setText(data[position].GetHeader());

            // Creating a vertical linear layout to put the data row
            LinearLayout linearLayoutData = new LinearLayout(context);
            linearLayoutData.setOrientation(LinearLayout.VERTICAL);

            // Get column amount for this row.
            int columnAmount = data[position].GetColumnsSize();

            for(int i = 0; i < columnAmount; i++)
            {
                TextView dynamicData = new TextView(context);

                dynamicData.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

                dynamicData.setText(data[position].GetDataAt(i));

                linearLayoutData.addView(dynamicData);
            }

            linearLayoutRow.addView(linearLayoutData);
        }

        return rowView;
    }
}
