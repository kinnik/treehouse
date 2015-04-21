package com.swifthorseman.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.swifthorseman.interactivestory.R;
import com.swifthorseman.interactivestory.model.Choice;
import com.swifthorseman.interactivestory.model.Page;
import com.swifthorseman.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {

    public static final String TAG = ActionBarActivity.class.getSimpleName();
    private Story story = new Story();
    private ImageView imageView;
    private TextView textView;
    private Button choice1, choice2;
    private String name;
    private Page currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));
        Log.d(TAG, name);

        imageView = (ImageView) findViewById(R.id.storyImageView);
        textView  = (TextView) findViewById(R.id.storyTextView);
        choice1 = (Button) findViewById(R.id.choiceButton1);
        choice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    private void loadPage(int choice) {
        currentPage = story.getPage(choice);
        Drawable drawable = getResources().getDrawable(currentPage.getImageId());

        imageView.setImageDrawable(drawable);
        // add the name if placeholder included; won't add if there is no placeholder
        String pageText = String.format(currentPage.getText(), name);
        textView.setText(pageText);

        if (currentPage.isFinal()) {
            choice1.setVisibility(View.INVISIBLE);
            choice2.setText("PLAY AGAIN");
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            choice1.setText(currentPage.getChoice1().getText());
            choice2.setText(currentPage.getChoice2().getText());

            choice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = currentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = currentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }
    }
}
