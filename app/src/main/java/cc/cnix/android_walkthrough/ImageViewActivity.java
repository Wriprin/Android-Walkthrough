package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIvGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mIvGlide = findViewById(R.id.iv_04);

        Glide.with(this).load("https://www.google.com/logos/doodles/2022/2022-world-cup-semi-finals-dec-13-14-6753651837110008-law.gif").into(mIvGlide);
    }
}