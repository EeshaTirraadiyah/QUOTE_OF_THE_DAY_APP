package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button refreshButton, shareButton, favoriteButton;

    private String[] quotes = {
            "The only way to do great work is to love what you do. - Steve Jobs",
            "Believe you can and you're halfway there. - Theodore Roosevelt",
            "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt"
            // Add more quotes here
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        refreshButton = findViewById(R.id.refreshButton);
        shareButton = findViewById(R.id.shareButton);
        favoriteButton = findViewById(R.id.favoriteButton);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRandomQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFavorites();
            }
        });

        showRandomQuote();
    }

    private void showRandomQuote() {
        Random random = new Random();
        int index = random.nextInt(quotes.length);
        quoteTextView.setText(quotes[index]);
    }

    private void shareQuote() {
        String currentQuote = quoteTextView.getText().toString();

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, currentQuote);

        startActivity(Intent.createChooser(shareIntent, "Share Quote"));
    }

    private void saveToFavorites() {
                String currentQuote = quoteTextView.getText().toString();

    }
}
