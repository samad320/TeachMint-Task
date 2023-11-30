package com.example.teachminttask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepoAdapter extends ListAdapter<YourDataModel, RepoAdapter.ViewHolder> {

    private OnItemClickListener listener;

    public RepoAdapter(OnItemClickListener listener) {
        super(new DiffUtil.ItemCallback<YourDataModel>() {
            @Override
            public boolean areItemsTheSame(@NonNull YourDataModel oldItem, @NonNull YourDataModel newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull YourDataModel oldItem, @NonNull YourDataModel newItem) {
                return oldItem.equals(newItem);
            }
        });
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View repoView = inflater.inflate(R.layout.item_repo, parent, false);
        return new ViewHolder(repoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        YourDataModel repo = getItem(position);

        holder.tvRepoName.setText(repo.getName());
        holder.tvRepoDescription.setText(repo.getDescription());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(repo);
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(YourDataModel repo);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRepoName;
        TextView tvRepoDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            tvRepoName = itemView.findViewById(R.id.tvRepoName);
            tvRepoDescription = itemView.findViewById(R.id.tvRepoDescription);
        }
    }
}
