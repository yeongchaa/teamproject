package com.example.capstone_donkki;

import android.content.ClipData;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Searchtag_Adapter extends RecyclerView.Adapter<Searchtag_Adapter.TagViewHolder> {

    private List<SearchtagData> SearchtagList;

    public Searchtag_Adapter(List<SearchtagData> SearchtagList) {
        this.SearchtagList = SearchtagList;
    }

    public static class TagViewHolder extends RecyclerView.ViewHolder {
        public TextView Searchtag;

        public TagViewHolder(View itemView) {
            super(itemView);
            Searchtag = itemView.findViewById(R.id.tv_searchtag);
        }
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View TagView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag_main, viewGroup, false);

        return new TagViewHolder(TagView);
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder tagViewHolder, int i) {
        SearchtagData searchtag = SearchtagList.get(i);
        tagViewHolder.Searchtag.setText(searchtag.getSearchtag());
    }

    @Override
    public int getItemCount() {
        return SearchtagList.size();
    }
}
