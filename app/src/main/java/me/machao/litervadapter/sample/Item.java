package me.machao.litervadapter.sample;

import android.widget.TextView;

import me.machao.litervadapter.LiteModel;
import me.machao.litervadapter.ViewCache;

/**
 * Date  2018/11/23
 *
 * @author charliema
 */
public class Item implements LiteModel {

    public String text ;

    @Override
    public void bind(ViewCache c) {
        ((TextView)c.get(R.id.tv)).setText(text);
    }
}
