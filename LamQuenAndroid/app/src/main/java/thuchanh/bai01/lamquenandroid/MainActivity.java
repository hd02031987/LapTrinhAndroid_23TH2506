package thuchanh.bai01.lamquenandroid;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonResult;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.etA);
        editTextB = findViewById(R.id.etB);
        buttonAdd = findViewById(R.id.btnAdd);
        buttonSubtract = findViewById(R.id.btnSubtract);
        buttonMultiply = findViewById(R.id.btnMultiply);
        buttonDivide = findViewById(R.id.btnDivide);
        buttonResult = findViewById(R.id.btnCalculate);
        textViewResult = findViewById(R.id.tvResult);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult.setText("");
            }
        });
    }

    private void calculate(char operator) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                } else {
                    textViewResult.setText("Không thể chia cho 0");
                    return;
                }
                break;
        }

        textViewResult.setText(String.valueOf(result));
    }
}