package se.kth.roberto.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import se.kth.roberto.myapplication.controller.ConverterController;

public class MainActivity extends AppCompatActivity {

    private ConverterController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ConverterController();
        // comment
    }



    public void convert(View view)  {
        View textArea1 = findViewById(R.id.input_value_from_user);

        EditText textArea = (EditText)textArea1;
        String res = textArea.getText().toString();

        String toDisplay = null;
        try {
            if (view.getId() == R.id.convert_from_g_to_kg) {
                toDisplay = controller.convertFromGtoKg(res);
            } else if (view.getId() == R.id.convert_from_kg_to_g) {
                toDisplay = controller.convertFromKgToG(res);
            }
        }
        catch (NumberFormatException ex ) {
            Toast t = Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT);
            t.show();
            return;
        }

        Toast t = Toast.makeText(this, toDisplay, Toast.LENGTH_SHORT);
        t.show();
    }
}
