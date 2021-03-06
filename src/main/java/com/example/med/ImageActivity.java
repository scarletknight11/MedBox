package com.example.medbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.couchbase.lite.Attachment;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;

import java.io.IOException;
import java.io.InputStream;
import android.widget.ZoomButton;

public class ImageActivity extends AppCompatActivity {
    public static final String INTENT_TASK_DOC_ID = "image";
    ZoomButton zoom;
    ImageView img;
    ZoomButton zoom2;
    ImageView img2;
    private String mTaskDocId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState != null)
            mTaskDocId = savedInstanceState.getString(INTENT_TASK_DOC_ID);
        else
            mTaskDocId = getIntent().getStringExtra(INTENT_TASK_DOC_ID);

        Application application = (Application) getApplication();
        Database database = application.getDatabase();
        Document document = database.getDocument(mTaskDocId);
        Attachment attachment = document.getCurrentRevision().getAttachment("image");
        if (attachment == null)
            return;
        Bitmap image = null;
        InputStream is = null;
        try {
            is = attachment.getContent();
            image = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            Log.e(Application.TAG, "Cannot display the attached image", e);
        } finally {
            if (is != null) try { is.close(); } catch (IOException e) { }
        }
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        zoom = (ZoomButton) findViewById(R.id.zoomButton1);
        img = (ImageView) findViewById(R.id.image);

        zoom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                float x = img.getScaleX();
                float y = img.getScaleY();

                img.setScaleX(x+2);
                img.setScaleY(y+2);
            }
        });

    zoom = (ZoomButton) findViewById(R.id.zoomButton2);
    img = (ImageView) findViewById(R.id.image);

        zoom.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            float x = img.getScaleX();
            float y = img.getScaleY();

            img.setScaleX(x-2);
            img.setScaleY(y-2);
        }
    });
}

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(INTENT_TASK_DOC_ID, mTaskDocId);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
