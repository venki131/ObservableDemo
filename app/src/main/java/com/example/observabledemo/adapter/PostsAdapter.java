package com.example.observabledemo.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.observabledemo.R;
import com.example.observabledemo.databinding.PostRowItemBinding;
import com.example.observabledemo.model.Post;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    private List<Post> postList;
    private LayoutInflater layoutInflater;
    private PostsAdapterListener adapterListener;

    public PostsAdapter(List<Post> postList, PostsAdapterListener adapterListener) {
        this.postList = postList;
        this.adapterListener = adapterListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        PostRowItemBinding itemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.post_row_item, viewGroup, false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int pos) {
        myViewHolder.rowItemBinding.setPost(postList.get(pos));
        myViewHolder.rowItemBinding.imgThumbnail.setOnClickListener(v -> {
            if (adapterListener != null) {
                adapterListener.onPostClicked(postList.get(pos));
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final PostRowItemBinding rowItemBinding;

        public MyViewHolder(PostRowItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }

    public interface PostsAdapterListener {
        void onPostClicked(Post post);
    }
}
