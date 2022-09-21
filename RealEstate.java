/**
 * @author Tess Luba, 2022
 */

public class RealEstate {
    /**
     * the amount of total properties
     */
    private int properties;

    /**
     * amount of duplexes that have been purchased
     */
    private int duplex;

    /**
     * amount of apartment buildings that have been purchased
     */
    private int apartmentBuilding;

    /**
     * amount of high rises that have been purchased
     */
    private int highRise;

    /**
     * Constructor
     * all set to 0
     */
    public RealEstate() {
        this.properties = 0;
        this.duplex = 0;
        this.apartmentBuilding = 0;
        this.highRise = 0;
    }

    /**
     *
     * @return the amount of properties obtained per click
     */
    public int getPropertiesPerClick() {
        int propertiesPerClick;
        return propertiesPerClick = 1 + (100 * highRise) + (10 * apartmentBuilding) + (2 * duplex);
    }

    /**
     *
     * @return the amount of properties
     */
    public int getProperties() {
        return properties;
    }

    /**
     *
     * @param properties - Sets the amount of properties
     */
    public void setProperties(int properties) {
        this.properties = properties;
    }

    /**
     *
     * @return the amount of duplexes
     */
    public int getDuplex() {
        return duplex;
    }

    /**
     *
     * @param duplex - Sets the amount of duplexes
     */
    public void setDuplex(int duplex) {
        this.duplex = duplex;
    }

    /**
     *
     * @return the amount of apartment buildings
     */
    public int getApartmentBuilding() {
        return apartmentBuilding;
    }

    /**
     *
     * @param apartmentBuilding - Sets the amount of apartment buildings
     */
    public void setApartmentBuilding(int apartmentBuilding) {
        this.apartmentBuilding = apartmentBuilding;
    }

    /**
     *
     * @return the amount of high rises
     */
    public int getHighRise() {
        return highRise;
    }

    /**
     *
     * @param highRise - Sets the amount of high rises
     */
    public void setHighRise(int highRise) {
        this.highRise = highRise;
    }

    /**
     *
     * @return adds properties to running total after every click.
     * Duplexes add 2 properties per click, apartment buildings add 10 properties per click, high rises add 100 properties per click
     */
    public int click() {
        if (highRise > 0) {
            return properties = properties + 1 + (100 * highRise) + (10 * apartmentBuilding) + (2 * duplex);
        } else if (apartmentBuilding > 0) {
            return properties = properties + 1 + (10 * apartmentBuilding) + (2 * duplex);
        } else if (duplex > 0) {
            return properties = properties + 1 + (2 * duplex);
        } else {
            return properties = properties + 1;
        }

    }

    /**
     *  Increases the cost of each subsequent duplex purchased
     * @return cost per duplex
     */
    public int getCostPerDuplex() {
        return 100 + (duplex * 100);
    }

    /**
     *  Increases the cost of each subsequent apartment building purchased
     * @return cost per apartment building
     */
    public int getCostPerApartmentBuilding() {
        return 500 + (apartmentBuilding * 500);
    }

    /**
     *  Increases the cost of each subsequent high rise purchased
     * @return cost per high rise
     */
    public int getCostPerHighRise() {
        return 1000 + (highRise * 1000);
    }

    /**
     *
     * @return to String
     */
    @Override
    public String toString() {
        return "You own " + properties + " properties, " + duplex + " duplexes, " + apartmentBuilding + " apartment buildings, and " + highRise + " high rises.";

    }
}
