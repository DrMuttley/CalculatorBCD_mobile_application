package pl.polsl.java.lab5.calculatorbcd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import pl.polsl.java.lab5.model.Model;
import pl.polsl.java.lab5.model.ModelException;

/**
 * Main class of application - manages the flow of control.
 *
 * @author Lukasz Nowak
 * @version 5.0
 */

public class MainActivity extends AppCompatActivity {

    /**
     * Model object
     */
    private Model model;

    /**
     * Method initializes class MainActivity.
     *
     * @param savedInstanceState Bundle object
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of the model
        model = new Model();
    }

    /**
     * Method performs calculations (addition or subtraction) on numbers provided by the user.
     *
     * @param view View object
     */

    public void calculate(View view) {

        //getting the first number from the user
        EditText editTextFirstNumber = (EditText)findViewById(R.id.firstNumberEditText);
        String firstNumber = editTextFirstNumber.getText().toString();

        //getting the second number from the user
        EditText editTextSecondNumber = (EditText)findViewById(R.id.secondNumberEditText);
        String secondNumber = editTextSecondNumber.getText().toString();

        //creating variable for result
        String result = new String();

        //veryifying the numbers provided by the user
        if(firstNumber != null && secondNumber != null && !firstNumber.equals("") && !secondNumber.equals("")){

            final RadioGroup group= (RadioGroup) findViewById(R.id.radioGroup);

            int id = group.getCheckedRadioButtonId();

            switch (id){
                case R.id.radioButtonAdd:
                    try{
                        result = model.addition(firstNumber, secondNumber);
                    }catch(ModelException e){
                        result = e.getMessage();
                    }
                    break;
                case R.id.radioButtonSub:
                    try{
                        result = model.subtraction(firstNumber, secondNumber);
                    }catch(ModelException e){
                        result = e.getMessage();
                    }
                    break;
                default:
                    result = "You must choose add or subtract. Go back and try again.";
                    break;
            }
        }else{
            result = "None of numbers can't by empty. Go back and try again.";
        }
        //forwarding the result to DisplayResultActivity
        Intent intent = new Intent(view.getContext(),DisplayResultActivity.class);
        intent.putExtra("result",result);
        startActivity(intent);
    }
}
