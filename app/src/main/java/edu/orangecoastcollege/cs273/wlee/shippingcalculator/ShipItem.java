package edu.orangecoastcollege.cs273.wlee.shippingcalculator;

public class ShipItem {

    private double mBaseCost;
    private double mWeight;
    private double mAddedCost;
    private double mTotalCost;
    private final double BASE_COST = 3.00;
    private final double COST_INCREMENT = 0.5;
    private final double BASE_WEIGHT = 16;


    public ShipItem(){
        mBaseCost = BASE_COST;
        mWeight = 0.0;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
    }

    public double getmBaseCost(){
        return mBaseCost;
    }

    public double getmWeight(){
        return mWeight;
    }

    public double getmAddedCost(){
        return mAddedCost;
    }

    public double getmTotalCost(){
        return mTotalCost;
    }

    public void setWeight(double weight) {
        mWeight = weight;

        if (mWeight > BASE_WEIGHT) {
            mAddedCost = (mWeight - BASE_WEIGHT) / 4 * COST_INCREMENT;
            mTotalCost = mBaseCost + mAddedCost;
        }
    }

}
