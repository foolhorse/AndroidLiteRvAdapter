package me.machao.litervadapter;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;

/**
 * Date  2018/11/23
 *
 * @author charliema
 */
public class Utils {

    public static <V extends View> V $(Window w, @IdRes int id) {
        return (V)w.findViewById(id);
    }

    public static <V extends View> V $(Activity a, @IdRes int id) {
        return $(a.getWindow(), id);
    }

    public static <V extends View> V $(Fragment f, @IdRes int id) {
        return $(f.getActivity(), id);
    }


}
