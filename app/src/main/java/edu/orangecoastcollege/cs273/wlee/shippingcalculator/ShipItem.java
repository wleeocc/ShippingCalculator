package edu.orangecoastcollege.cs273.wlee.shippingcalculator;

public class ShipItem {

    /**
     * Represents an item to ship.
     */
    private double mBaseCost;
    private double mWeight;
    private double mAddedCost;
    private double mTotalCost;
    private final double BASE_COST = 3.00;
    private final double COST_INCREMENT = 0.5;
    private final double BASE_WEIGHT = 16;
    private final double WEIGHT_STEP_SIZE = 4;

    /**
     * Creates a new item to ship.
     */
    public ShipItem(){
        mBaseCost = BASE_COST;
        mWeight = 0.0;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
    }

    /**
     * Returns the base cost.
     * @return Item's base cost
     */
    public double getBaseCost(){
        return mBaseCost;
    }

    /**
     * Returns the weight.
     * @return Item's weight
     */
    public double getWeight(){
        return mWeight;
    }

    /**
     * Returns the added cost.
     * @return Item's added cost
     */
    public double getAddedCost(){
        return mAddedCost;
    }

    /**
     * Returns the total cost.
     * @return Item's total cost
     */
    public double getTotalCost(){
        return mTotalCost;
    }

    /**
     * Changes the item's weight.
     * @param weight Item's weight
     */
    public void setWeight(double weight) {
        mWeight = weight;

        mBaseCost = BASE_COST;

        if (mWeight == 0) {
            mBaseCost = 0;
            mAddedCost = 0;
        }
        else if (mWeight > BASE_WEIGHT) {
            mAddedCost = Math.ceil((mWeight - BASE_WEIGHT) / WEIGHT_STEP_SIZE) * COST_INCREMENT;
        }
        mTotalCost = mBaseCost + mAddedCost;
    }
}
