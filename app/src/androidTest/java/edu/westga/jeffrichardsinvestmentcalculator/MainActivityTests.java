package edu.westga.jeffrichardsinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Tests for main activity
 *
 * Created by Jeff on 3/6/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

    private void setAnEditText(int id, String value) {
        MainActivity activity = getActivity();
        final EditText anEditText = (EditText) activity.findViewById(id);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                anEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        // Wow this framework is horrible...  Have to send keypad right commands and keypad backspace
        // to clear existing text?  Why are all Java related frameworks so dang primitive?
        for (int x = 0; x < 20; x++) {
            getInstrumentation().sendCharacterSync(KeyEvent.KEYCODE_DPAD_RIGHT);
            getInstrumentation().sendCharacterSync(KeyEvent.KEYCODE_DEL);
        }
        getInstrumentation().sendStringSync(value);
    }

    public void testSetPayment() {
        MainActivity activity = getActivity();
        this.setAnEditText(R.id.txtPayment, "100.0");
        TextView resultText = (TextView) activity.findViewById(R.id.lblResult);
        assertEquals("$0.00", resultText.getText().toString());
    }

    public void testSetPaymentAndRate() {
        MainActivity activity = getActivity();
        this.setAnEditText(R.id.txtPayment, "100.0");
        this.setAnEditText(R.id.txtRate, "3.0");
        TextView resultText = (TextView) activity.findViewById(R.id.lblResult);
        assertEquals("$0.00", resultText.getText().toString());
    }

    public void testSetPaymentAndRateAndPeriod() {
        MainActivity activity = getActivity();
        this.setAnEditText(R.id.txtPayment, "100.0");
        this.setAnEditText(R.id.txtRate, "3.0");
        this.setAnEditText(R.id.txtPeriods, "12");
        final EditText periodsEdit = (EditText) activity.findViewById(R.id.txtPeriods);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                periodsEdit.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        getInstrumentation().waitForIdleSync();
        TextView resultText = (TextView) activity.findViewById(R.id.lblResult);
        String foo = resultText.getText().toString();
        assertEquals("$1,419.20", resultText.getText().toString());
    }
}