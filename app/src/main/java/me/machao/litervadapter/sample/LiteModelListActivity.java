package me.machao.litervadapter.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.machao.litervadapter.LiteRvAdapter;

public class LiteModelListActivity extends AppCompatActivity {

    private List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_model_list);

        initData();
        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(new LiteRvAdapter(R.layout.item_1, items));
    }

    private void initData() {
        for (int i = 0; i < 100; i = i + 1) {
            Item item = new Item();
            item.text = "Hey LiteModel " + i;
            items.add(item);
        }
    }
}
