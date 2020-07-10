package com.example.instragram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.w3c.dom.Text;

public class PostsDetailActivity extends AppCompatActivity {
    public static final String TAG = "PostsDetailActivity";
    private TextView tvUsername;
    private TextView tvCaption;
    private TextView tvDate;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_detail);

        // Finding views
        Log.i(TAG, "finding views");
        tvUsername = findViewById(R.id.tvName);
        tvCaption = findViewById(R.id.tvCap);
        tvDate = findViewById(R.id.tvDate);
        ivImage = findViewById(R.id.ivPhoto);

        //retrieves object id
        String id = getIntent().getExtras().getString("ID");
        Log.i(TAG, "THE ID IS: " + id);

        // retrieve post object
        ParseQuery query = ParseQuery.getQuery(Post.class);
        try {
            Post post = (Post) query.get(id);
            ParseUser user = post.getUser();
            String username = user.fetch().getUsername();
            tvUsername.setText(username);
            String description = post.getDescription();
            tvCaption.setText(description);
            String date = post.getRelativeTime();
            tvDate.setText(date);
            ParseFile image = post.getImage();
            if(image != null)
                Glide.with(this).load(image.getUrl()).into(ivImage);

//            ParseObject post = query.get(id);
//            String i = (String) post.get("description");
//            Log.i(TAG, "DESCRIPTION: " + i);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}