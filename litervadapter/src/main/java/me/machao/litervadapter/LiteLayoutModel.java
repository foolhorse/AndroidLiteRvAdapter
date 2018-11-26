package me.machao.litervadapter;

import android.support.annotation.LayoutRes;
import android.view.View;

public interface LiteLayoutModel extends LiteModel {
    @LayoutRes
    int getLayoutRes();
}
