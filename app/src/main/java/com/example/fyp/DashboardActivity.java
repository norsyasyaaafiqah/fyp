package com.example.fyp;
import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class DashboardActivity extends AppCompatActivity {

    Button  search;
    EditText From, To,Date ;
    String HttpURL = "http://192.168.1.108/BusQR/destination.php";
    String From_Holder, To_Holder,DateHolder;
    String finalResult ;
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    //Button LogOut;
    //TextView EmailShow;
    //String EmailHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        From= (EditText)findViewById(R.id.from);
        To = (EditText)findViewById(R.id.to);
        Date=  (EditText)findViewById(R.id.date);
        search = (Button)findViewById(R.id.search_bus);

       search.setOnClickListener(new View.OnClickListener() {
         @Override
           public void onClick(View view) {
             Intent intent = new Intent(DashboardActivity.this, listbus.class);
             startActivity(intent);


         //                   Toast.makeText(DashboardActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

        //                }

        //            }
        //        });
       //     }
       //     public void CheckEditTextIsEmptyOrNot(){
       //     From_Holder = From.getText().toString();
      //      To_Holder = To.getText().toString();
      //     DateHolder = Date.getText().toString();

      //      if(TextUtils.isEmpty(From_Holder) || TextUtils.isEmpty(To_Holder) || TextUtils.isEmpty(DateHolder))
      //      {
       //         CheckEditText = false;
     //       }
     //       else {
     //           CheckEditText = true ;
    //        }
   // }

   // public void UserDashboardFunction(final String From, final String To, final String Date){
     //   class UserlistbusClass extends AsyncTask<String,Void,String> {
        //    @Override
       //     protected void onPreExecute() {
     //           super.onPreExecute();
     //           progressDialog = ProgressDialog.show(DashboardActivity.this,"Loading Data",null,true,true);
    //        }

     //       @Override
     //       protected void onPostExecute(String httpResponseMsg) {
      //          super.onPostExecute(httpResponseMsg);

       //         progressDialog.dismiss();

      //          if(httpResponseMsg.equalsIgnoreCase("Data Matched")){
      //              finish();

      //              Intent intent = new Intent(DashboardActivity.this, listbus.class);


       //             startActivity(intent);

     //           }
     //           else{
     //               Toast.makeText(DashboardActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
    //            }

     //       }

    //        @Override
     //       protected String doInBackground(String... params) {

   //             hashMap.put("From",params[0]);

   //             hashMap.put("To",params[1]);

     //           hashMap.put("Data",params[2]);

    //            finalResult = httpParse.postRequest(hashMap, HttpURL);

    //            return finalResult;
    //       }
    //    }

   //     UserlistbusClass userlistbusClass = new UserlistbusClass();

     //   userlistbusClass.execute(From,To,Date);
    }

});

    }
}






    //LogOut = (Button)findViewById(R.id.button);
        //EmailShow =(TextView)findViewById(R.id.EmailShow);


        //Intent intent = getIntent();
        //EmailHolder = intent.getStringExtra(login.UserEmail);
        //EmailShow.setText(EmailHolder);


        //LogOut.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {

               // finish();

              //  Intent intent = new Intent(DashboardActivity.this, login.class);

                //startActivity(intent);

                //Toast.makeText(DashboardActivity.this, "Log Out Successfully", Toast.LENGTH_LONG).show();

            //}

        //});


