package edu.miracosta.fortune500;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class CompanyDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);

        ImageView companyImageView = findViewById(R.id.companyDetailsImageView);
        TextView nameTextView = findViewById(R.id.companyDetailsNameTextView);
        RatingBar rankRatingBar = findViewById(R.id.companyDetailsRankRatingBar);
        TextView employeesTextView = findViewById(R.id.companyDetailsEmployeesTextView);
        TextView profitsTextView = findViewById(R.id.companyDetailsProfitsTextView);
        TextView marketValueTextView = findViewById(R.id.companyDetailsMarketValueTextView);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
        // DONE:  Use the Intent object sent from MainActivity to populate the Views on

        Intent intent = getIntent();

        String name = intent.getStringExtra("Name");
        int rank = intent.getIntExtra("Rank", 0);
        int employees = intent.getIntExtra("Employees", 0);
        double profits = intent.getDoubleExtra("Profits", 0.0) ;
        double profitChange = intent.getDoubleExtra("ProfitChange", 0.0) ;
        double market = intent.getDoubleExtra("MarketValue", 0.0) ;
        String imageName = intent.getStringExtra("ImageName") ;

        nameTextView.setText(name);
        rankRatingBar.setNumStars(rank);
        rankRatingBar.setRating(rank);
        employeesTextView.setText(employees);
        profitsTextView.setText(String.format(profits + ""));
        marketValueTextView.setText(String.format((market + "")));


        try {
            InputStream stream = getAssets().open(imageName);
            Drawable image = Drawable.createFromStream(stream, imageName);
            companyImageView.setImageDrawable(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // DONE:  this layout, including the TextViews, RatingBar and ImageView with the Company details.
        // DONE:  Ensure the rankRatingBar has both its rating AND number of stars
        // DONE:  set to the rank of the company.

    }
}
