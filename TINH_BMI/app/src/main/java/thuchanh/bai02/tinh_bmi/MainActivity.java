package thuchanh.bai02.tinh_bmi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText weightEditText;
    private EditText heightEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightEditText = findViewById(R.id.canNang);
        heightEditText = findViewById(R.id.chieuCao);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100; // Chuyê cm ----> m

            float bmi = weight / (height * height);

            String result = String.format("BMI: %.2f", bmi);
            resultTextView.setText(result);

            String category = getBMICategory(bmi);
            resultTextView.append("\n" + category);
        } else {
            resultTextView.setText("Vui lòng nhập cân nặng và chiều cao");
        }
    }

    private String getBMICategory(float bmi) {
        if (bmi < 18.5) {
            return "Thân hình hơi gầy một chút, đề nghị ăn bồi bổ thêm";
        } else if (bmi < 25) {
            return "Thân hình bình thường.";
        } else if (bmi < 30) {
            return "Thân hình hơi béo, đề nghị ăn giảm cân và tập luyện nhiều";
        } else {
            return "Béo phì, đề nghị ăn giảm cân và tập luyện nhiều";
        }
    }
}