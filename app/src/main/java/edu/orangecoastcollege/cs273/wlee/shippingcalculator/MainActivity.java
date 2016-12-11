package edu.orangecoastcollege.cs273.wlee.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ShipItem shipItem;
    private EditText weightEditText;
    private TextView baseCostTextView;
    private TextView addedCostTextView;
    private TextView totlaCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shipItem = new ShipItem();

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        baseCostTextView = (TextView) findViewById(R.id.baseCostTextView);
        addedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        totlaCostTextView = (TextView) findViewById(R.id.totalCostTextView);

    }

    private TextWatcher weightTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            double weight = Double.parseDouble(s.toString()) / 100.0;
            shipItem.setWeight(weight);

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
