package com.pedromihael.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        this.mViewHolder.mInputValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged (CharSequence s, int start, int before, int count) {
                convertCurrency(s);
            }

            @Override
            public void afterTextChanged (Editable s) {}
        });

    }

    public void convertCurrency(CharSequence sequence) {
        String newDollarView, newEuroView;

        if (sequence.length() == 0) {
            newDollarView = "US$0";
            newEuroView = "EU$0";
        } else {
            Double dollarValue = Double.parseDouble(sequence.toString()) / 4;
            Double euroValue = Double.parseDouble(sequence.toString()) / 5;
            newDollarView = "US$" + String.format("%.2f", dollarValue);
            newEuroView = "EU$" + String.format("%.2f", euroValue);
        }

        this.mViewHolder.mDollarValue.setText(newDollarView);
        this.mViewHolder.mEuroValue.setText(newEuroView);
    }

    private class ViewHolder {
        EditText mInputValue;
        TextView mDollarValue;
        TextView mEuroValue;
    }
}
