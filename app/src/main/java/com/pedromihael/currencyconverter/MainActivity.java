package com.pedromihael.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private Currency mCurrencyConverter = new Currency();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.mInputValue = findViewById(R.id.edit_input_value);
        this.mViewHolder.mDollarValue = findViewById(R.id.text_dollar_output);
        this.mViewHolder.mEuroValue = findViewById(R.id.text_euro_output);
        this.mViewHolder.mButtonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.mButtonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency(view);
            }
        });
    }

    public void convertCurrency(View view) {
        Double dollarValue = Double.parseDouble(this.mViewHolder.mInputValue.getText().toString()) * 4;
        Double euroValue = Double.parseDouble(this.mViewHolder.mInputValue.getText().toString()) * 5;
        this.mViewHolder.mDollarValue.setText("U$" + dollarValue.toString());
        this.mViewHolder.mEuroValue.setText("EU$" + euroValue.toString());
    }

    private class ViewHolder {
        EditText mInputValue;
        TextView mDollarValue;
        TextView mEuroValue;
        Button mButtonCalculate;
    }
}
