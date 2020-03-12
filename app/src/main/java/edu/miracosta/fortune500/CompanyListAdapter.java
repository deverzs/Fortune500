package edu.miracosta.fortune500;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import edu.miracosta.fortune500.model.Company;

/**
 * Helper class to provide custom adapter for the <code>Company</code> list.
 */
public class CompanyListAdapter extends ArrayAdapter<Company> {

    private Context mContext;
    private List<Company> mCompaniesList;
    private int mResourceId;

    /**
     * Creates a new <code>CompanyListAdapter</code> given a context, resource id and list of Companies.
     *
     * @param c The context for which the adapter is being used (typically an activity)
     * @param rId The resource id (typically the layout file name)
     * @param companiesList The list of companies to display
     */
    public CompanyListAdapter(Context c, int rId, List<Company> companiesList) {
        super(c, rId, companiesList);
        mContext = c;
        mResourceId = rId;
        mCompaniesList = companiesList;
    }

    /**
     * Gets the view associated with the layout.
     * @param pos The position of the Company selected in the list.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content set.
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        LinearLayout custom = view.findViewById(R.id.mainLinearLayout);

        TextView companyListRankTextView = view.findViewById(R.id.companyListRankTextView) ;
        TextView companyListNameTextView = view.findViewById(R.id.companyListNameTextView);
        TextView companyListProfitChangeTextView = view.findViewById(R.id.companyListProfitChangeTextView);
        ImageView companyListImageView = view.findViewById(R.id.companyListImageView) ;



        custom.setTag(pos);
        Company selected = mCompaniesList.get(pos); //AGHHHH   I have this wrong


        AssetManager am = mContext.getAssets();

        InputStream stream = null;
        try {
            stream = am.open(selected.getImageName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable image = Drawable.createFromStream(stream, selected.getImageName()) ;
        companyListImageView.setImageDrawable(image);

        companyListNameTextView.setText(selected.getName());

        companyListProfitChangeTextView.setText(String.format(selected.getProfitChange() + ""));
        companyListRankTextView.setText(selected.getRank());



        //DONE:  Code for getting the view of a list item correctly inflated.
        //DONE:  This should inflate every part of the company_list_item layout
        //TODO:  Be sure to set the tag of the view to the current company (using the list and position)

        return view;
    }
}
