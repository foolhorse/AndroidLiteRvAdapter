package me.machao.litervadapter;

import android.support.annotation.IdRes;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Date  2018/11/23
 *
 * @author charliema
 */
public class ViewCache {

    public static final int MAX_SIZE = 32;

//    private final LruCache<Integer, View> cache;
    private final SparseArray<View> cache;

    private final View view;

    public ViewCache(View view) {
//        cache = new LruCache<>(MAX_SIZE);
        cache = new SparseArray<>();
        this.view = view;
    }

    public View root() {
        return this.view;
    }

    public <V extends View> V get(@IdRes int id) {
        View v = cache.get(id);
        if (v == null) {
            v = view.findViewById(id);
            if (v != null) {
                cache.put(id, v);
            }
        }
        return (V) v;
    }

}
