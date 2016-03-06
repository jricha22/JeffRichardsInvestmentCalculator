package edu.westga.jeffrichardsinvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

import edu.westga.jeffrichardsinvestmentcalculator.model.InvestmentCalculator;

public class MainActivity extends AppCompatActivity {

    private InvestmentCalculator calculator;
    private EditText paymentText;
    private EditText rateText;
    private EditText periodText;
    private TextView resultLabel;
    private TextView messageLabel;
    private NumberFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.paymentText = (EditText) findViewById(R.id.txtPayment);
        this.rateText = (EditText) findViewById(R.id.txtRate);
        this.periodText = (EditText) findViewById(R.id.txtPeriods);
        this.resultLabel = (TextView) findViewById(R.id.lblResult);
        this.messageLabel = (TextView) findViewById(R.id.lblMessage);
        this.calculator = new InvestmentCalculator();
        this.formatter = NumberFormat.getCurrencyInstance();
        this.initializeValues();
        this.setEventHandlers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeValues() {
        this.paymentText.setText(String.format("%.2f", calculator.getPayment()));
        this.rateText.setText(String.format("%.3f", calculator.getRate()));
        this.periodText.setText(String.format("%d", calculator.getPeriods()));
        this.resultLabel.setText(formatter.format(calculator.getResult()));
        this.messageLabel.setText("");
    }

    private void setEventHandlers() {
        this.paymentText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    MainActivity.this.onPaymentChange();
                }
            }
        });
        this.rateText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    MainActivity.this.onRateChange();
                }
            }
        });
        this.periodText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    MainActivity.this.onPeriodChange();
                }
            }
        });

        this.periodText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Clear focus here from edittext
                    MainActivity.this.onPeriodChange();
                }
                return false;
            }
        });
    }

    private void onPaymentChange() {
        this.calculator.setPayment(Double.parseDouble(this.paymentText.getText().toString()));
        this.paymentText.setText(String.format("%.2f", this.calculator.getPayment()));
        this.resultLabel.setText(formatter.format(calculator.getResult()));
    }

    private void onRateChange() {
        this.calculator.setRate(Double.parseDouble(this.rateText.getText().toString()) / 100.0);
        this.rateText.setText(String.format("%.3f", this.calculator.getRate() * 100.0));
        this.resultLabel.setText(formatter.format(calculator.getResult()));
    }

    private void onPeriodChange() {
        this.calculator.setPeriods(Integer.parseInt(this.periodText.getText().toString()));
        this.resultLabel.setText(formatter.format(calculator.getResult()));
    }
}
