package com.example.paweg.labocontentprovider;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=(TextView)findViewById(R.id.textView);
        TextView textView1=(TextView)findViewById(R.id.textView2);
        String[] projection=new String[]{
                CalendarContract.Events._ID,
                CalendarContract.Events.TITLE,
                CalendarContract.Events.DTSTART
        };
        Cursor cursor=getContentResolver().query(CalendarContract.Events.CONTENT_URI, projection, null, null, CalendarContract.Events._ID+" ASC");
        if(cursor.moveToFirst()){
            textView.setText(cursor.getString(1));
            long tmpDate=Long.parseLong(cursor.getString(2));
            DateFormat.getDateInstance().format(tmpDate);
            textView1.setText(DateFormat.getDateInstance().format(tmpDate));
        }
    }
}
