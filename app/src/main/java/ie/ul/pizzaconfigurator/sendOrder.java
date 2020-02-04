package ie.ul.pizzaconfigurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class sendOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);

        Intent intent = getIntent();

        String name = intent.getStringExtra("Name");
        TextView textName = findViewById(R.id.name);
        textName.setText(name);

        String size = intent.getStringExtra("Size");
        TextView textSize = findViewById(R.id.size);
        textSize.setText(size);

        String type = intent.getStringExtra("Type");
        TextView textType = findViewById(R.id.type);
        textType.setText(type);

        String extra1 = intent.getStringExtra("Extra1");
        String extra2 = intent.getStringExtra("Extra2");
        String extra3 = intent.getStringExtra("Extra3");

        String extra = "No extra";
        String temp = "";
        if(!(extra1.equals(""))) {
            temp += extra1;
            temp += " ";
        }
        if(!(extra2.equals(""))) {
            temp += extra2;
            temp += " ";
        }
        if(!(extra3.equals(""))) {
            temp += extra3;
        }

        TextView textExtra = findViewById(R.id.extra);

        if(temp.equals("")) {
            textExtra.setText(extra);
        } else {
            textExtra.setText(temp);
        }

        String tay = intent.getStringExtra("TakeAwayYes");
        String tan = intent.getStringExtra("TakeAwayNo");

        TextView textTa = findViewById(R.id.takeaway);

        if(tay.equals("")) {
            textTa.setText(tan);
        } else {
            textTa.setText(tay);
        }








    }
}
