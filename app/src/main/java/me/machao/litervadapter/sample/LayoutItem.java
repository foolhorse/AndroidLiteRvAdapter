package me.machao.litervadapter.sample;

import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.machao.litervadapter.LiteLayoutModel;
import me.machao.litervadapter.ViewCache;

/**
 * Date  2018/11/23
 *
 * @author charliema
 */
public class LayoutItem implements LiteLayoutModel {

    public String text;

    @Override
    public int getLayoutRes() {
        return R.layout.litervadapter_item_text;
    }

    @Override
    public void bind(ViewCache c) {
        c.root().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
        TextView tv = c.get(R.id.tv);
        tv.setText(text);
        Drawable d = tv.getResources().getDrawable(R.mipmap.ic_launcher_round);
        tv.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
        tv.setCompoundDrawablePadding(32);
        tv.setGravity(Gravity.CENTER_VERTICAL);
    }
}
