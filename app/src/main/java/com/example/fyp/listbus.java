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

    Connection connect;
    String connectionResult = "";
    Boolean isSuccess = false;

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
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        retrieveData();

        /*
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckEditTextIsEmptyOrNot();

                if (CheckEditText) {

                    UserLoginFunction(From_Holder, To_Holder);

                } else {

                    Toast.makeText(listbus.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

            }
        });

         */
    }

    /*
    public void CheckEditTextIsEmptyOrNot() {

        From_Holder = From.getText().toString();
        To_Holder = To.getText().toString();

        if (TextUtils.isEmpty(From_Holder) || TextUtils.isEmpty(To_Holder) || TextUtils.isEmpty(DateHolder)) {
            CheckEditText = false;
        } else {

            CheckEditText = true;
        }
    }

     */

    public void retrieveData() {

        class UserLoginClass extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(listbus.this, "Loading Data", null, true, true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                // if not empty
                if (httpParse.bufferedReader.read())
                if (httpResponseMsg.equalsIgnoreCase("Data Matched")) {

                    //finish();


                    Intent intent = new Intent(listbus.this, listbus.class);

                    //intent.putExtra(UserEmail, email);

                    startActivity(intent);

                } else {

                    Toast.makeText(listbus.this, "There are no buses!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            protected String doInBackground(String... params) {

                try {
                    httpParse.bufferedReader.read();
                    id
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while(httpParse.)
                hashMap.put("from", params[0]);

                hashMap.put("to", params[1]);

                hashMap.put("date", params[2]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(email, password);
    }

}





                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
@Override
public void onItemClick(AdapterView<?> parent,View view,int i,long id){
        Toast.makeText(listbus.this,"clicked item:"+i+" "
        +arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
        }
        });
        }

