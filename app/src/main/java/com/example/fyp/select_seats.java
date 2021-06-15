package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class select_seats extends AppCompatActivity {

    LinearLayout linear;
    Double seatPrice = 900.00;
    Double totalCost = 0.0;
    int totalSeats = 0;
    TextView totalBookedSeats, totalPrice;
    Button buttonBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seats);


        //firebaseAuth= FirebaseAuth.getInstance();
        //databaseReference = FirebaseDatabase.getInstance().getReference();

        linear = (LinearLayout) findViewById(R.id.linear);
        totalBookedSeats = (TextView) findViewById(R.id.total_seats);
        totalPrice = (TextView) findViewById(R.id.total_cost);
        buttonBook = (Button) findViewById(R.id.btnBook);

        //Set Event;
        //setToggleEvent(linear);
        //final  String nameBus=getIntent().getStringExtra("NAME_BUS");
        //final String dateBus=getIntent().getStringExtra("DATE_BUS");
        //final String conditionBus=getIntent().getStringExtra("CONDITION_BUS");

        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String totalPriceI=totalPrice.getText().toString().trim();
                String totalBookedSeatsI=totalBookedSeats.getText().toString().trim();

                PaymentDetail paymentDetail=new PaymentDetail(totalPriceI,totalBookedSeatsI);

                //FirebaseUser user=firebaseAuth.getCurrentUser();
                //databaseReference.child(user.getUid()).child("SeatDetails").setValue(paymentDetail);

                Intent intent=new Intent(select_seats.this,PaymentActivity.class);
                intent.putExtra("TOTALCOST",totalPriceI);
                intent.putExtra("TOTALSEAT",totalBookedSeatsI);


                startActivity(intent);

            }
        });

    }


    private void setToggleEvent(LinearLayout linear) {
        //Loop all child item of Main Grid
        for (int i = 0; i < linear.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) linear.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#00FF00"));
                        totalCost += seatPrice;
                        ++totalSeats;
                        Toast.makeText(select_seats.this, "You Selected Seat Number :" + (finalI + 1), Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        totalCost -= seatPrice;
                        --totalSeats;
                        Toast.makeText(select_seats.this, "You Unselected Seat Number :" + (finalI + 1), Toast.LENGTH_SHORT).show();
                    }
                    totalPrice.setText("" + totalCost+"0");
                    totalBookedSeats.setText("" + totalSeats);
                }
            });
        }
    }}



