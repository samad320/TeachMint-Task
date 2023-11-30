package com.example.teachminttask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContributorAdapter extends RecyclerView.Adapter<ContributorAdapter.ViewHolder> {

    private List<Contributor> contributorList;

    public ContributorAdapter() {
        this.contributorList = contributorList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contributorView = inflater.inflate(R.layout.item_contributor, parent, false);
        return new ViewHolder(contributorView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contributor contributor = contributorList.get(position);

        holder.tvContributorLogin.setText(contributor.getLogin());
    }

    @Override
    public int getItemCount() {
        return contributorList.size();
    }

    public void submitList(Object contributors) {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvContributorLogin;

        public ViewHolder(View itemView) {
            super(itemView);
            tvContributorLogin = itemView.findViewById(R.id.tvContributorLogin);
        }
    }
}
