package edu.miracosta.fortune500.model;

import java.util.Objects;

/**
 * The <code>Company</code> class maintains information about a Fortune 500 company,
 * including its name, rank, employees, profits, profit change and market value.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class Company {

    //Member variables
    private String mName;
    private int mRank;
    private int mEmployees;
    private double mProfits;
    private double mProfitChange;
    private double mMarketValue;
    private String mImageName;

    public Company() {}

    public Company (String name, int rank, double profitChange)
    {
        this(name, rank, -1, -1, profitChange, -1, "Company.png");
    }
    
    public Company(String name, int rank, int employees, double profits, double profitChange, double marketValue, String imageName) {
        mName = name;
        mRank = rank;
        mEmployees = employees;
        mProfits = profits;
        mProfitChange = profitChange;
        mMarketValue = marketValue;
        mImageName = imageName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getRank() {
        return mRank;
    }

    public void setRank(int rank) {
        mRank = rank;
    }

    public int getEmployees() {
        return mEmployees;
    }

    public void setEmployees(int employees) {
        mEmployees = employees;
    }

    public double getProfits() {
        return mProfits;
    }

    public void setProfits(double profits) {
        mProfits = profits;
    }

    public double getProfitChange() {
        return mProfitChange;
    }

    public void setProfitChange(double profitChange) {
        mProfitChange = profitChange;
    }

    public double getMarketValue() {
        return mMarketValue;
    }

    public void setMarketValue(double marketValue) {
        mMarketValue = marketValue;
    }

    public String getImageName() {
        return mImageName;
    }

    public void setImageName(String imageName) {
        mImageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return mRank == company.mRank &&
                mEmployees == company.mEmployees &&
                Double.compare(company.mProfits, mProfits) == 0 &&
                Double.compare(company.mProfitChange, mProfitChange) == 0 &&
                Double.compare(company.mMarketValue, mMarketValue) == 0 &&
                Objects.equals(mName, company.mName) &&
                Objects.equals(mImageName, company.mImageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mRank, mEmployees, mProfits, mProfitChange, mMarketValue, mImageName);
    }

    @Override
    public String toString() {
        return "Company{" +
                "Name='" + mName + '\'' +
                ", Rank=" + mRank +
                ", Employees=" + mEmployees +
                ", Profits=" + mProfits +
                ", Profit Change=" + mProfitChange +
                ", Market Value=" + mMarketValue +
                ", ImageName='" + mImageName + '\'' +
                '}';
    }
}
