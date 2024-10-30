package example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv1, tv2;
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.weight);
        et2 = (EditText) findViewById(R.id.height);
        tv1 = (TextView) findViewById(R.id.imc);
        tv2 = (TextView) findViewById(R.id.result);
        bt1 = (Button) findViewById(R.id.calculate_imc);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imc();
            }
        });
    }

    private void imc() {
        double calculate = Integer.parseInt(et1.getText().toString()) / (Double.parseDouble(et2.getText().toString()) * Double.parseDouble(et2.getText().toString()));
        tv1.setText(String.valueOf(calculate));

        if (calculate < 18.49) {
            tv2.setText("Estas demasiado flaco bro, como más...");
        } else if (calculate >= 18.49 && calculate <= 22.99) {
            tv2.setText("Tas bien chamo, bien ahí");
        } else if (calculate > 24.99) {
            tv2.setText("Cierra el hocico chamo, tas waton");
        }
    }
}