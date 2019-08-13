package com.example.observabledemo.activity;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.example.observabledemo.R;
import com.example.observabledemo.Utils.GridSpacingItemDecoration;
import com.example.observabledemo.adapter.PostsAdapter;
import com.example.observabledemo.databinding.ActivityMainBinding;
import com.example.observabledemo.model.Post;
import com.example.observabledemo.model.User;
import com.example.observabledemo.model.UserViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PostsAdapter.PostsAdapterListener {

    private MyClickHandlers handlers;
    private PostsAdapter postsAdapter;
    private RecyclerView recyclerView;
    private ActivityMainBinding activityMainBinding;
    private User user;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Toolbar toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.toolbar_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        handlers = new MyClickHandlers(this);

        renderProfile();

        initRecyclerView();
    }

    private void renderProfile() {
        user = new User();
        user.setName("Peter Parker");
        user.setEmail("peter.parker@hotmail.com");
        user.setProfileImage("https://vignette.wikia.nocookie.net/spidermanps4/images/b/b5/Spider-Man_from_MSM_screen.jpg/revision/latest/scale-to-width-down/1000?cb=20180914043126");
        user.setAbout("Avenger");

        user.numberOfPosts.set(34000L);
        user.numberOfFollowers.set(24000L);
        user.numberOfFollowing.set(3455L);

        activityMainBinding.setUser(user);

        activityMainBinding.content.setHandlers(handlers);
    }

    private void initRecyclerView() {
        recyclerView = activityMainBinding.content.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        postsAdapter = new PostsAdapter(getPosts("https://vignette.wikia.nocookie.net/spidermanps4/images/b/b5/Spider-Man_from_MSM_screen.jpg/revision/latest/scale-to-width-down/1000?cb=20180914043126"), this);
        recyclerView.setAdapter(postsAdapter);
    }

    private ArrayList<Post> getPosts(String url) {
        ArrayList<Post> posts = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Post post = new Post();
            post.setImageUrl(url);
            posts.add(post);
        }
        return posts;
    }

    @Override
    public void onPostClicked(Post post) {
        Toast.makeText(getApplicationContext(), "Post clicked! " + post.getImageUrl(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public class MyClickHandlers {

        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onProfileFabClicked(View view) {
            user.setName("Barry Allen");
            user.setAbout("Member of Justice League");
            user.setProfileImage("https://hips.hearstapps.com/digitalspyuk.cdnds.net/18/36/1536068719-the-flash-season-5-poster.jpg?resize=768:*");
            postsAdapter = new PostsAdapter(getPosts("https://hips.hearstapps.com/digitalspyuk.cdnds.net/18/36/1536068719-the-flash-season-5-poster.jpg?resize=768:*"), MainActivity.this);
            recyclerView.setAdapter(postsAdapter);

            user.numberOfPosts.set(5550L);
            user.numberOfFollowers.set(4283L);
            user.numberOfFollowing.set(3492L);
        }

        public boolean onProfileImageLongPress(View view) {
            Toast.makeText(getApplicationContext(), "Profile image long pressed!", Toast.LENGTH_LONG).show();
            return false;
        }

        public void onFollowersClicked(View view) {
            Toast.makeText(context, "Followers is clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onFollowingClicked(View view) {
            Toast.makeText(context, "Following is clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onPostsClicked(View view) {
            Toast.makeText(context, "Posts is clicked!", Toast.LENGTH_SHORT).show();
        }
    }
}
