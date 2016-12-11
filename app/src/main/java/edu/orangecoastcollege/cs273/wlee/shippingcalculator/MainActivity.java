package edu.orangecoastcollege.cs273.wlee.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Displays the total cost whenever the user changes the weight.
 * @author Wonseop
 */
public class MainActivity extends AppCompatActivity {

    private ShipItem shipItem;
    private EditText weightEditText;
    private TextView baseCostTextView;
    private TextView addedCostTextView;
    private TextView totalCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shipItem = new ShipItem();

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        baseCostTextView = (TextView) findViewById(R.id.baseCostTextView);
        addedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        totalCostTextView = (TextView) findViewById(R.id.totalCostTextView);

        weightEditText.addTextChangedListener(weightTextChangeListener);
    }

    private TextWatcher weightTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                shipItem.setWeight(Double.parseDouble(s.toString()));
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                baseCostTextView.setText(currency.format(shipItem.getBaseCost()));
                addedCostTextView.setText(currency.format(shipItem.getAddedCost()));
                totalCostTextView.setText(currency.format(shipItem.getTotalCost()));
            }
            catch (NumberFormatException e)
            {
                shipItem.setWeight(0);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
