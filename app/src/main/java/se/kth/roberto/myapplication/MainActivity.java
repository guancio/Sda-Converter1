package se.kth.roberto.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import se.kth.roberto.myapplication.controller.AddressBookController;
import se.kth.roberto.myapplication.controller.ConverterController;

public class MainActivity extends AppCompatActivity {

    private AddressBookController controller;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new AddressBookController();

        Spinner spinner = (Spinner) findViewById(R.id.names);
        // Create an ArrayAdapter using the string list and a default spinner layout
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, controller.getAllNames());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        
        // comment
    }

    public void addName(View view) {
        View textArea1 = findViewById(R.id.input_value_from_user);
        EditText textArea = (EditText)textArea1;
        String res = textArea.getText().toString();
        controller.addName(res);
        adapter.notifyDataSetChanged();
    }

    public void remove(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.names);
        String value = (String) spinner.getItemAtPosition(spinner.getSelectedItemPosition());
        controller.removeName(value);
        adapter.notifyDataSetChanged();
    }

/*
    public void convert(View view)  {



        Spinner spinner = (Spinner) findViewById(R.id.type_of_conversion);
        String value = (String) spinner.getItemAtPosition(spinner.getSelectedItemPosition());

        String toDisplay = null;
        try {
            if ("Convert G to Kg".equals(value)) {
                toDisplay = controller.convertFromGtoKg(res);
            }
            else if ("Convert Kg to G".equals(value)) {
                toDisplay = controller.convertFromKgToG(res);
            }
            /*
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

        Toast t = Toast.makeText(this,
                toDisplay, Toast.LENGTH_SHORT);
        t.show();
    }
    */
}
