package thuchanh.bai03.listviewcoban;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //B1.1. Khai báo listview có tên là lvMonhoc kiểu là ListView
ListView lvMonHoc;
    //B1.3. Tạo một mảng chứa môn học
    ArrayList<String> arrayCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //B1.2. Ánh xạ listviewMonHoc vào lvMonHoc
        lvMonHoc = findViewById(R.id.listviewMonHoc);
        //B1.4. Khởi tạo mới một mảng
        arrayCourse = new ArrayList<>();
        //B2.1. Thêm các môn học vô
        arrayCourse.add("Lập trình Android");
        arrayCourse.add("Ứng dụng Web");
        arrayCourse.add("Lập trình ASP.NET MVC");
        arrayCourse.add("Cơ sở dữ liệu");
        arrayCourse.add("Hệ Quản trị CSDL");
        arrayCourse.add("Lập trình C#");
        arrayCourse.add("Thiết kế và cài đặt mạng");
        arrayCourse.add("Tiếng Anh chuyên ngành");
        arrayCourse.add("Kỹ thuật lập trình");
        arrayCourse.add("Cấu trúc dữ liệu và giải thuật");
        //B3.1 Tạo adapter để hiển thị dữ liệu
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);
        //B4.1 Gán listview để hiển thị ra màn hình
        lvMonHoc.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}