package ie.ul.pizzaconfigurator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    TextView recap3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> size = new ArrayList<String>();
        size.add("Small");
        size.add("Medium");
        size.add("Large");
        size.add("XL");
        ArrayAdapter<String> adapter_size = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, size);
        adapter_size.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner_size = (Spinner) findViewById(R.id.size_edit);
        spinner_size.setAdapter(adapter_size);
        spinner_size.setOnItemSelectedListener(this);

        List<String> type = new ArrayList<String>();
        type.add("Pepperoni");
        type.add("Tomato");
        ArrayAdapter<String> adapter_type = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
        adapter_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner_type = (Spinner) findViewById(R.id.type_edit);
        spinner_type.setAdapter(adapter_type);
        spinner_type.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id) {
        TextView recap1 = (TextView) findViewById(R.id.recap1);
        TextView recap2 = (TextView) findViewById(R.id.recap2);

        String str = (String) parent.getItemAtPosition(pos);

        if(parent.getId() == R.id.size_edit) {
            recap1.setText(str);
        } else if(parent.getId() == R.id.type_edit) {
            recap2.setText(str);
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    String temp = "";
    public void checkBox(View view) {
        TextView recap3 = (TextView) findViewById(R.id.recap3);
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()){
            case R.id.extra_edit_1:
                if(checked)
                    temp += " Add Cheese\n";
                else
                    temp = temp.replace(" Add Cheese\n", "");
                break;
            case R.id.extra_edit_2:
                if(checked)
                    temp += " Add Bacon\n";
                else
                    temp = temp.replace(" Add Bacon\n", "");
                break;
            case R.id.extra_edit_3:
                if(checked)
                    temp += " Add Mozzarella\n";
                else
                    temp = temp.replace(" Add Mozzarella\n", "");
                break;
        }
        recap3.setText(temp);
    }

    public void sendOrder(View view) {

        Intent intent = new Intent(this, sendOrder.class);

        EditText name_edit = (EditText) findViewById(R.id.name_edit);
        String name = name_edit.getText().toString();
        intent.putExtra("Name", name);

        Spinner size_edit = (Spinner) findViewById(R.id.size_edit);
        String size = size_edit.getSelectedItem().toString();
        intent.putExtra("Size", size);

        Spinner type_edit = (Spinner) findViewById(R.id.type_edit);
        String type = type_edit.getSelectedItem().toString();
        intent.putExtra("Type", type);

        if(((CheckBox) findViewById(R.id.extra_edit_1)).isChecked()) {
            CheckBox extra_1_edit = (CheckBox) findViewById(R.id.extra_edit_1);
            String extra_1 = extra_1_edit.getText().toString();
            intent.putExtra("Extra1", extra_1);
        } else {
            intent.putExtra("Extra1", "");
        }

        if(((CheckBox) findViewById(R.id.extra_edit_2)).isChecked()) {
            CheckBox extra_2_edit = (CheckBox) findViewById(R.id.extra_edit_2);
            String extra_2 = extra_2_edit.getText().toString();
            intent.putExtra("Extra2", extra_2);
        } else {
            intent.putExtra("Extra2", "");
        }

        if(((CheckBox) findViewById(R.id.extra_edit_3)).isChecked()) {
            CheckBox extra_3_edit = (CheckBox) findViewById(R.id.extra_edit_3);
            String extra_3 = extra_3_edit.getText().toString();
            intent.putExtra("Extra3", extra_3);
        } else {
            intent.putExtra("Extra3", "");
        }

        if(((RadioButton) findViewById(R.id.takeaway_edit_1)).isChecked()) {
            RadioButton take_away_yes_edit = (RadioButton) findViewById(R.id.takeaway_edit_1);
            String  take_away_yes = take_away_yes_edit.getText().toString();
            intent.putExtra("TakeAwayYes", take_away_yes);
        } else {
            intent.putExtra("TakeAwayYes", "");
        }

        if(((RadioButton) findViewById(R.id.takeaway_edit_2)).isChecked()) {
            RadioButton take_away_no_edit = (RadioButton) findViewById(R.id.takeaway_edit_2);
            String  take_away_no = take_away_no_edit.getText().toString();
            intent.putExtra("TakeAwayNo", take_away_no);
        } else {
            intent.putExtra("TakeAwayNo", "");
        }

        startActivity(intent);
    }


}
