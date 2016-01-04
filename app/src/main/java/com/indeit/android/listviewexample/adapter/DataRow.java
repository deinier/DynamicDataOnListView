package com.indeit.android.listviewexample.adapter;

/**
 * Created by dmorales on 1/4/2016.
 */
public class DataRow
{
    private String header;

    private String[] dataRow;

    public DataRow(String header, String[] dataRow)
    {
        this.header = header;

        this.dataRow = dataRow;
    }

    public String GetHeader()
    {
        return header;
    }

    public int GetColumnsSize()
    {
        return dataRow.length;
    }

    public String GetDataAt(int position)
    {
        if(position < dataRow.length)
        {
            return dataRow[position];
        }

        return "";
    }
}
