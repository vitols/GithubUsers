package com.example.android.app.View;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.TextView;

import com.example.android.app.Model.Repo;
import com.example.android.githubUsers.R;

import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;


/**
 * Created by admin on 21.01.2018.
 */

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    List<Repo> repos;

    public RepoAdapter(List<Repo> repos) {
        this.repos = repos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        android.view.View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repo_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repo repo = repos.get(position);
        holder.repoName.setText(repo.getName().toString());
        holder.repoDate.setText(parseData(repo.getCreatedAt().toString()));
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView repoName;
        public TextView repoDate;
        public ViewHolder(android.view.View itemView) {
            super(itemView);
            repoName = (TextView) itemView.findViewById(R.id.repo_text_name);
            repoDate = (TextView) itemView.findViewById(R.id.repo_text_date);
        }
    }

    public void addAll(List<Repo> repos) {
        int length = this.repos.size();
        this.repos = repos;
        notifyItemInserted(length);
    }

    private String parseData(String dateTime) {
        return ZonedDateTime
                .parse(dateTime)
                .withZoneSameInstant(ZoneId.systemDefault())
                .toLocalDateTime()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
