package com.shubham.devilapp;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputText, sourceLang, targetLang;
    Button translateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        sourceLang = findViewById(R.id.sourceLang);
        targetLang = findViewById(R.id.targetLang);
        translateButton = findViewById(R.id.translateButton);

        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = inputText.getText().toString();
                String source = sourceLang.getText().toString();
                String target = targetLang.getText().toString();

                // Ensure the user has entered all fields
                if (!text.isEmpty() && !source.isEmpty() && !target.isEmpty()) {
                    // Format Google Translate URL
                    String url = "https://translate.google.com/?sl=" + source + "&tl=" + target + "&text=" + Uri.encode(text) + "&op=translate";

                    // Open the URL in a web browser
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            }
        });
    }
}
