package com.example.calvinwang.textify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextDetector;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Bitmap bitmap;

    Uri imageUri;

    ImageView imageView;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//aaa

    public void openGallery(View view) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, 1);
    }

    public void takepicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    public void detect(View view) {
        if (bitmap == null) {
            Toast.makeText(getApplicationContext(), "Bitmap is null", Toast.LENGTH_LONG).show();
        } else {
            FirebaseVisionImage firebaseVisionImage = FirebaseVisionImage.fromBitmap(bitmap);
            FirebaseVisionTextDetector firebaseVisionTextDetector = FirebaseVision.getInstance().getVisionTextDetector();
            firebaseVisionTextDetector.detectInImage(firebaseVisionImage)
                    .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                        @Override
                        public void onSuccess(FirebaseVisionText firebaseVisionText) {
                            process_text(firebaseVisionText);
                        }
                    });
        }
    }

    private void process_text(FirebaseVisionText firebaseVisionText) {
        List<FirebaseVisionText.Block> blocks = firebaseVisionText.getBlocks();
        if (blocks.size() == 0) {
            Toast.makeText(getApplicationContext(), "no textd detected", Toast.LENGTH_LONG).show();
        }
        else {
            for (FirebaseVisionText.Block block: firebaseVisionText.getBlocks()) {
                String text = block.getText();
                textView = findViewById(R.id.textView);
                textView.setText(text);
                imageView.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageView = findViewById(R.id.imageView);
        if (resultCode == RESULT_OK && requestCode == 1) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                imageView = findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (requestCode == 0) {
            bitmap = (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);

        }
    }
}
