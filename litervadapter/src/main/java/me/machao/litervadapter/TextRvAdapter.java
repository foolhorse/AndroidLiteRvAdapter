package me.machao.litervadapter;

import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TextRvAdapter extends RecyclerView.Adapter {

    private LiteRvAdapter mLiteRvAdapter;

    private List<TextItem> textList;

    @ColorInt
    private
    int color;
    private float size;
    private int[] padding;


    public TextRvAdapter(List<String> textList) {
        this.textList = textItemFrom(textList);
        mLiteRvAdapter = new LiteRvAdapter(this.textList);
    }

    public TextRvAdapter(List<?> list, String field) throws NoSuchFieldException, IllegalAccessException {
        this.textList = textItemFrom(list, field);
        mLiteRvAdapter = new LiteRvAdapter(this.textList);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return mLiteRvAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        mLiteRvAdapter.onBindViewHolder((LiteRvAdapter.VH) viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return mLiteRvAdapter.getItemCount();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (recyclerView.getLayoutManager() == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
    }

    private TextItem textItemFrom(String text) {
        return new TextItem(text);
    }

    private List<TextItem> textItemFrom(List<String> textList) {
        List<TextItem> list = new ArrayList<>();
        for (String str : textList) {
            list.add(textItemFrom(str));
        }
        return list;
    }

    private List<TextItem> textItemFrom(List<?> objList, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        List<TextItem> list = new ArrayList<>();
        for (Object obj : objList) {
            Class<?> clz = obj.getClass();
            Field field = clz.getField(fieldName);
//                if(!field.isAccessible()) {
//                    field.setAccessible(true);
//                }
            String str = (String) field.get(obj);
            list.add(textItemFrom(str));
        }
        return list;
    }

    public void color(@ColorInt int color) {
        this.color = color;
    }

    public void size(float spSize) {
        this.size = spSize;
    }

    public void padding(int left, int top, int right, int bottom) {
        this.padding = new int[]{left, top, right, bottom};
    }


    private class TextItem implements LiteLayoutModel {

        String text;

        private TextItem(String text) {
            this.text = text;
        }

        @Override
        public int getLayoutRes() {
            return R.layout.litervadapter_item_text;
        }

        @Override
        public void bind(ViewCache c) {
            TextView tv = c.get(R.id.tv);
            if (color != 0x0) {
                tv.setTextColor(color);
            }
            if (size != 0) {
                tv.setTextSize(size);
            }
            if (padding != null) {
                tv.setPadding(padding[0], padding[1], padding[2], padding[3]);
            }
            tv.setText(text);
        }
    }
}
