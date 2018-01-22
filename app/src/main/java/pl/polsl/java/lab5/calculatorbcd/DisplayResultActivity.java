package pl.polsl.java.lab5.calculatorbcd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Class displays information to the user - the result of addition or subtraction, exceptions from
 * the model, information about incorrect completion of the form.
 *
 * @author Lukasz Nowak
 * @version 5.0
 */

public class DisplayResultActivity extends AppCompatActivity {

    /**
     * Method initializes class DisplayResultActivity.
     *
     * @param savedInstanceState Bundle object
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //downloading the result of calculations and displaying it on the screen
        TextView result = (TextView)findViewById(R.id.resultTextView);
        result.setText(getIntent().getStringExtra("result"));
    }
}
