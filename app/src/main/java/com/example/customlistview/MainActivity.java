package com.example.customlistview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ArrayList<Phone> list = new ArrayList<>();
        list.add(new Phone("Galaxy S4", "Samsung"));
        list.add(new Phone("Galaxy S3", "Samsung"));
        list.add(new Phone("Galaxy Mega", "Samsung"));
        list.add(new Phone("Galaxy Note", "Samsung"));
        list.add(new Phone("Iphone", "Apple"));
        list.add(new Phone("HTC One", "HTC"));
        list.add(new Phone("Nexus 5", "LG"));
        list.add(new Phone("Nexus 4", "LG"));
        list.add(new Phone("LG G2", "LG"));
        list.add(new Phone("Moto x", "Motorola"));
        list.add(new Phone("Sony Xperia 5V", "Sony"));
        list.add(new Phone("BlackBerry Curve 8300", "BlackBerry"));
        list.add(new Phone("Huawei P50 Pro", "Huawei"));
        list.add(new Phone("Huawei Nova 9", "Huawei"));
        list.add(new Phone("Huawei Mate 30 Pro", "Huawei"));
        list.add(new Phone("Pavilion 14", "HP"));
        list.add(new Phone("Probook X360", "HP"));
        list.add(new Phone("ROG Phone 6", "Asus"));
        list.add(new Phone("ROG Phone 7", "Asus"));
        list.add(new Phone("Zenfone 10", "Asus"));
        ListAdapter adapter = new ListAdapter(this, list);
        ListView listView = findViewById((R.id.id_list));
        listView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}