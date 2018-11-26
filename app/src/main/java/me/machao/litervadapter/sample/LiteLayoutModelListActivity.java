package me.machao.litervadapter.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.machao.litervadapter.LiteRvAdapter;

public class LiteLayoutModelListActivity extends AppCompatActivity {

    private List<LayoutItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_layout_model_list);

        initData();
        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(new LiteRvAdapter(items));
    }

    private void initData() {
        for (int i = 0; i < 100; i = i + 1) {
            LayoutItem item = new LayoutItem();
            item.text = "Hi LiteLayoutModel " + i * 100;
            items.add(item);
        }
    }
}
