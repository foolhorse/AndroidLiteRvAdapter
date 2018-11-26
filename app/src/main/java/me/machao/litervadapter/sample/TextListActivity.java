package me.machao.litervadapter.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.machao.litervadapter.TextRvAdapter;

public class TextListActivity extends AppCompatActivity {

    private List<String> textList = new ArrayList<>();
    private List<Pojo> pojoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_list);

        initData();

        final RecyclerView rv = findViewById(R.id.rv);

        findViewById(R.id.btnString).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextRvAdapter adapter = new TextRvAdapter(textList);
                adapter.color(0xFF000000);
                adapter.size(32);
                adapter.padding(16,16,16,16);
                rv.setAdapter(adapter);
            }
        });

        findViewById(R.id.btnObj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rv.setAdapter(new TextRvAdapter(pojoList,"name"));
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 100; i = i + 1) {
            textList.add("Hello 😊" + i);
            pojoList.add(new Pojo("sup " + i));
        }
    }

    private static class Pojo {
        public String name;

        Pojo(String name) {
            this.name = name;
        }
    }


}
