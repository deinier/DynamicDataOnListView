package com.indeit.android.listviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.indeit.android.listviewexample.adapter.DataRow;
import com.indeit.android.listviewexample.adapter.DynamicAdapter;

public class MainActivity extends AppCompatActivity
{
    private DynamicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Simulating variable data per row. Array Adapter instead Cursor Adapter for simplicity
        final DataRow[] data =
                {
                        new DataRow("Spider Man", new String[] {"3|10%", "5|25%"}),
                        new DataRow("Spider Man Brother", new String[] {"3|20%"}),
                        new DataRow("Other Spider Man", new String[] {"3|22%", "1|12%", "4|7%"})
                };

        // Assign data to adapter
        adapter = new DynamicAdapter(this, data);

        // Getting reference to ListView
        ListView listViewData = (ListView) findViewById(R.id.listViewData);

        // Setting adapter to listView
        listViewData.setAdapter(adapter);
    }
}
