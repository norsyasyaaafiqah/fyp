package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listbus extends AppCompatActivity {

    //test comment
    ListView listView;
    EditText From, To, Date;
    Button search;
    String HttpURL = "http://192.168.1.108/BusQR/destination.php";
    String From_Holder, To_Holder, DateHolder;
    String finalResult;
    Boolean CheckEditText;
    ProgressDialog progressDialog;
    HashMap<String, String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listbus);

        listView = (ListView) findViewById(R.id.listviewbus);
        From = (EditText) findViewById(R.id.from);
        To = (EditText) findViewById(R.id.to);
        Date = (EditText) findViewById(R.id.date);
        search = (Button) findViewById(R.id.search_bus);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Teluk Intan to Melaka 12 January 2021 12:00-2:00 ");
        arrayList.add("Teluk Intan to Sabak Bernam 13 Januari 2021 1200-2:00");
        arrayList.add("Teluk Intan to Sabak Bernam 05 June 2021 1200-2:00");
        arrayList.add("Teluk Intan to Bagan Datuk 01 September 2021 2:00-3:00");
        arrayList.add("Teluk Intan to Johor 10 October 2021 10:00-5:00");



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(listbus.this, "clicked item:" + i + " "
                        + arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

