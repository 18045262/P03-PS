package sg.edu.rp.c346.billplease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    TextView displayAmount;
    EditText totalAmount;
    TextView pax;
    EditText numPax;
    TextView gst;
    ToggleButton gstInclude;
    TextView payPer;
    EditText payPerPerson;
    TextView service;
    ToggleButton serviceCharge;
    TextView discount;
    EditText discountPercentage;
    ToggleButton getDiscount;
    Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        totalAmount = findViewById(R.id.editText);
        numPax= findViewById(R.id.editText4);
        gstInclude = findViewById(R.id.gstButton);
        getDiscount = findViewById(R.id.discountButton);
        payPerPerson = findViewById(R.id.payPerEdit);
        calculate = findViewById(R.id.button);
        serviceCharge = findViewById(R.id.serviceToogle);
        discountPercentage = findViewById(R.id.discountPercentage);



        getDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getDiscount.isChecked()) discountPercentage.setEnabled(true);
                else{
                    discountPercentage.setEnabled(false);
                }

            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalAmount.getText().toString();
                numPax.getText().toString();
                payPerPerson.getText().toString();
                double payment;
                double amount= Double.parseDouble(totalAmount.getText().toString());
                int numberPax = Integer.parseInt(numPax.getText().toString());
                double discountAmount=Double.parseDouble(discountPercentage.getText().toString());

                if(gstInclude.isChecked()){
                    amount *= 1.07;
                }
                if(serviceCharge.isChecked()){
                    amount *=1.10;
                }
                if (getDiscount.isChecked()){
                    amount *=(1*discountAmount);
                }
                if (numberPax>1){
                    payment=amount/numberPax;
                    String perPayment = String.format("%.2f", payment);
                    payPerPerson.setText(perPayment);
                }
                else {
                    String eachPayment = Double.toString(amount);
                    payPerPerson.setText(eachPayment);
                }

            }
        });

    }
}
