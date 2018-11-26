package me.machao.litervadapter;


import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class LiteRvAdapter extends RecyclerView.Adapter<LiteRvAdapter.VH> {

    private List<? extends LiteModel> modelList;

    private int layoutRes;

    public LiteRvAdapter() {

    }

    public LiteRvAdapter(@LayoutRes int layoutRes, List<? extends LiteModel> modelList) {
        set(layoutRes, modelList);
    }

    public LiteRvAdapter(List<? extends LiteLayoutModel> layoutModelList) {
        set(layoutModelList);
    }

    public List<? extends LiteModel> get() {
        return modelList;
    }

    public void set(@LayoutRes int layoutRes, List<? extends LiteModel> modelList) {
        this.layoutRes = layoutRes;
        this.modelList = modelList;

    }

    public void set(List<? extends LiteLayoutModel> layoutModelList) {
        modelList = layoutModelList;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (recyclerView.getLayoutManager() == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
    }

    @NonNull
    @Override
    public LiteRvAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int layoutRes;
        if (this.layoutRes == 0) {
            layoutRes = ((LiteLayoutModel) modelList.get(i)).getLayoutRes();
        } else {
            layoutRes = this.layoutRes;
        }
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layoutRes, viewGroup, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LiteRvAdapter.VH viewHolder, int i) {
        modelList.get(i).bind(viewHolder.cache);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    static class VH extends RecyclerView.ViewHolder {

        ViewCache cache;

        VH(@NonNull View itemView) {
            super(itemView);
            cache = new ViewCache(itemView);
        }
    }
}
