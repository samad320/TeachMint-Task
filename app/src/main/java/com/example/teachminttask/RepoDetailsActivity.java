package com.example.teachminttask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RepoDetailsActivity extends AppCompatActivity {
    private RepoDetailsViewModel viewModel;
    private ContributorAdapter contributorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);


        RecyclerView recyclerViewContributors = findViewById(R.id.recyclerViewContributors);

        contributorAdapter = new ContributorAdapter();
        recyclerViewContributors.setAdapter(contributorAdapter);
        recyclerViewContributors.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getContributors().observe(this, contributors -> contributorAdapter.submitList(contributors));

        String repoName = null;
        if (repoName != null) {
            viewModel.fetchRepoDetails(repoName);
        }
    }

    private void updateUI(RepoDetails repoDetails) {
    }
}
