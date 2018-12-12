package com.example.calvinwang.textify;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextDetector;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

//    Bitmap bitmap;
//
//    Uri imageUri;
//
//    ImageView imageView;
//
//    TextView textView;
//
//    private TextToSpeech mTTs;
//
//    private SeekBar mSeekBarPitch;
//
//    private SeekBar mSeekBarSpeed;
//
//    private Button mButtonSpeak;
//
//
//    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotosecondpage(View view) {
        Intent intent = new Intent(this, secondpage.class);
        startActivity(intent);
    }
//
//        mButtonSpeak = findViewById(R.id.buttonSpeak);
//        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if (status == TextToSpeech.SUCCESS) {
//                    int result = mTTs.setLanguage(Locale.ENGLISH);
//                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                        Log.e("TTS", "Language not supported");
//                    } else {
//                        mButtonSpeak.setEnabled(true);
//                    }
//                } else {
//                    Log.e("TTS", "Initialization failed.");
//                }
//
//            }
//        });
//        textView = findViewById(R.id.textView);
//        mSeekBarPitch = findViewById(R.id.seekBarPitch);
//        mSeekBarSpeed = findViewById(R.id.seekBarSpeed);
//        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                speak();
//            }
//        });
//    }
//
//    private void speak() {
//        String text = textView.getText().toString();
//        float pitch = (float) mSeekBarPitch.getProgress() / 50;
//        if (pitch <= 0) {
//            pitch = 0.1f;
//        }
//        float speed = (float) mSeekBarSpeed.getProgress() / 50;
//        if (speed <= 0) {
//            speed = 0.1f;
//        }
//        mTTs.setPitch(pitch);
//        mTTs.setSpeechRate(speed);
//        mTTs.speak(text, TextToSpeech.QUEUE_FLUSH, null);
//    }
//
//    @Override
//    protected void onDestroy() {
//        if (mTTs != null) {
//            mTTs.stop();
//            mTTs.shutdown();
//        }
//        super.onDestroy();
//    }
//
//    public void openGallery(View view) {
//        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        startActivityForResult(gallery, 1);
//    }
//
//    public void takePicture(View view) {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, 0);
//    }
//
//    public void detect(View view) {
//        if (bitmap == null) {
//            Toast.makeText(getApplicationContext(), "Bitmap is null", Toast.LENGTH_LONG).show();
//        } else {
//            FirebaseVisionImage firebaseVisionImage = FirebaseVisionImage.fromBitmap(bitmap);
//            FirebaseVisionTextDetector firebaseVisionTextDetector = FirebaseVision.getInstance().getVisionTextDetector();
//            firebaseVisionTextDetector.detectInImage(firebaseVisionImage)
//                    .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
//                        @Override
//                        public void onSuccess(FirebaseVisionText firebaseVisionText) {
//                            process_text(firebaseVisionText);
//                        }
//                    });
//        }
//    }
//
//    private void process_text(FirebaseVisionText firebaseVisionText) {
//        List<FirebaseVisionText.Block> blocks = firebaseVisionText.getBlocks();
//        if (blocks.size() == 0) {
//            textView.setText("No text detected");
//            imageView.setVisibility(View.INVISIBLE);
//        }
//        else {
//            for (FirebaseVisionText.Block block: firebaseVisionText.getBlocks()) {
//                String text = block.getText();
//                textView = findViewById(R.id.textView);
//                textView.setText(text);
//                imageView.setVisibility(View.GONE);
//            }
//        }
//
//    }
//
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        imageView = findViewById(R.id.imageView);
//        if (resultCode == RESULT_OK && requestCode == 1) {
//            Uri uri = data.getData();
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
//                imageView.setImageBitmap(bitmap);
//                imageView.setVisibility(View.VISIBLE);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else if (requestCode == 0) {
//            bitmap = (Bitmap)data.getExtras().get("data");
//            imageView.setImageBitmap(bitmap);
//            imageView.setVisibility(View.VISIBLE);
//        }
//    }
}