package com.example.android.app.View;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.app.Others.User;
import com.example.android.githubUsers.R;


import java.util.List;

/**
 * Created by admin on 09.01.2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;
    private Activity activity;

    public UserAdapter(List<User> users, Activity activity) {
        this.users = users;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        User user = users.get(position);
        Glide.with(activity).load(user.getAvatarUrl()).dontAnimate().into(holder.userImage);
        holder.userLogin = user.getLogin();
        holder.userName.setText(user.getName());
        holder.userLocation.setText(user.getLocation());
        Integer reposCount = user.getPublicRepos();
        if(reposCount != null)
            holder.userCountOfRepos.setText(reposCount.toString());
        holder.userCompany.setText(user.getCompany());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView userImage;
        public TextView userName;
        public TextView userLocation;
        public TextView userCompany;
        public TextView userCountOfRepos;
        public String userLogin;

        public ViewHolder(android.view.View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.card_text_name);
            userLocation = (TextView) itemView.findViewById(R.id.card_text_location);
            userCompany = (TextView) itemView.findViewById(R.id.card_text_company);
            userCountOfRepos = (TextView) itemView.findViewById(R.id.card_text_repos_count);
            userImage = (ImageView) itemView.findViewById(R.id.card_image_user);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            RepoFragment fragment = RepoFragment.newInstance(this.userLogin);
            FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.recycler_container, fragment);
            fragmentTransaction.addToBackStack("myRepoFragment");
            fragmentTransaction.commit();
        }
    }

    public void addAll(List<User> users) {
        int length = this.users.size();
        this.users = users;
        notifyItemInserted(length);
    }

    public void addSingle(User user, int position) {
        //ProgressBar progressBar = (ProgressBar)activity.findViewById(R.id.card_progressbar);
        //progressBar.setVisibility(View.INVISIBLE);
        users.set(position, user);
        notifyItemChanged(position);
    }
}
