package edu.miracosta.fortune500;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;

import java.io.IOException;
import java.util.List;

import edu.miracosta.fortune500.model.Company;
import edu.miracosta.fortune500.model.JSONLoader;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText profitChangeEditText;
    private EditText rankEditText;

    private List<Company> companiesList;
    private CompanyListAdapter companiesListAdapter;
    private ListView companiesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        profitChangeEditText = findViewById(R.id.proiftChangeEditText);
        rankEditText = findViewById(R.id.rankEditText);

        try {
            companiesList = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        companiesListView = findViewById(R.id.companyListView) ;
        companiesListAdapter = new CompanyListAdapter(this, R.layout.company_list_item, companiesList) ;
        // DONE: Connect the ListView with the layout
        // DONE:  Populate companies list using the JSONLoader
        // DONE:  Create a new ListAdapter connected to the correct layout file and list
        // DONE:  Connect the ListView with the ListAdapter

        companiesListView.setAdapter(companiesListAdapter);
    }


    public void viewCompanyDetails(View view) {

        Company company = (Company) view.getTag() ;

        Intent intent = new Intent(this, CompanyDetailsActivity.class);

        intent.putExtra("Name", company.getName());
        intent.putExtra("Rank", company.getRank());
        intent.putExtra("Employees", company.getEmployees());
        intent.putExtra("MarketValue", company.getMarketValue());
        intent.putExtra("Profits", company.getProfits());
        intent.putExtra("ProfitChange", company.getProfitChange());
        intent.putExtra("ImageName", company.getImageName());

        startActivity(intent);


        // DONE: Extract the clickedCompany from the tag of the view
        // DONE: Use an Intent to start the CompanyDetailsActivity with the data it needs to correctly inflate its views.

    }

    public void addCompany(View view)
    {
        nameEditText = findViewById(R.id.nameEditText);
        profitChangeEditText = findViewById(R.id.proiftChangeEditText) ;
        rankEditText = findViewById(R.id.rankEditText) ;

        Company addMe = new Company();

        addMe.setName(nameEditText.getText().toString());
        addMe.setProfitChange(Double.parseDouble(profitChangeEditText.getText().toString()));
        addMe.setRank(Integer.parseInt(rankEditText.getText().toString()));
        addMe.setImageName("Company.png");

        companiesListAdapter.add(addMe);

        nameEditText.setText("");
        profitChangeEditText.setText("");
        rankEditText.setText("");

        // DONE:  Read information from EditTexts and RatingBar,
        // DONE:  Create a new Company object then add it to the list
        // DONE:  Make sure the list adapter is notified
        // DONE:  Clear all entries the user made (edit texts and rating bar)
    }

}
