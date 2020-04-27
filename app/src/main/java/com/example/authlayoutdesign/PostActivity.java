package com.example.authlayoutdesign;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PostActivity extends AppCompatActivity {

    Button homeBtnPost, postBtn;
    EditText postText;
    RadioButton relief,query;
    String postType= "QUERY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        homeBtnPost = findViewById(R.id.home_button_new_post_page);
        postBtn = findViewById(R.id.btn_post);
        postText = findViewById(R.id.editText_post);
        query = findViewById(R.id.radBtnQuery);
        relief = findViewById(R.id.radBtnRelief);

        homeBtnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postBody = postText.getText().toString();
                if(postBody.length()==0)
                {
                    postText.setError("Post body can not be empty!");
                }
                else
                {
                    //Post It
                    if(relief.isActivated()) { postType = "RELIEF"; }
                    Post post = new Post();


                    finish();
                }
            }
        });

    }
}
