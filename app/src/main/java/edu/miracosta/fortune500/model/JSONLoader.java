package edu.miracosta.fortune500.model;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class loads Company data from a formatted JSON (JavaScript Object Notation) file.
 * Populates data model (Company) with data.
 */

public class JSONLoader {

    public static final String TAG = JSONLoader.class.getSimpleName();

    /**
     * Loads JSON data from a file in the assets directory.
     * @param context The activity from which the data is loaded.
     * @throws IOException If there is an error reading from the JSON file.
     */
    public static List<Company> loadJSONFromAsset(Context context) throws IOException {
        List<Company> allCompanies = new ArrayList<>();
        String json;
            InputStream is = context.getAssets().open("Fortune500.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            //DONE: Complete the name of the root object in the JSON file
            JSONArray allCompaniesJSON = jsonRootObject.getJSONArray("Fortune500");
            int num = allCompaniesJSON.length();

            // DONE: Loop through the root object array and
            for (int i = 0; i < num; i++) {
                JSONObject eventJ = allCompaniesJSON.getJSONObject(i);
                Company event = new Company();

                event.setName(eventJ.getString("Name"));
                event.setEmployees(eventJ.getInt("Employees"));
                event.setImageName(eventJ.getString("ImageName"));
                event.setMarketValue(eventJ.getDouble("MarketValue") * 1000000);
                event.setProfitChange(eventJ.getDouble("ProfitChange"));
                event.setRank(eventJ.getInt("Rank"));
                event.setProfits(eventJ.getDouble("Profits") *1000000);

                allCompanies.add(event);


            }
            // DONE: Extract each single Company from the JSON file.
            // DONE: Create an object to represent each company, then
            // DONE: add each Company to the list.
        }
        catch (JSONException e)
        {
            Log.e(TAG, e.getMessage());
        }

        return allCompanies;
    }
}
