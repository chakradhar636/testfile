package Entities;

/**
 * Created by bholar on 8/3/2017.
 */
public class SparePartsClass {
    private int id;
    String sparepartName;
    long cost;

    public SparePartsClass() {
    }

    public SparePartsClass(String sparepartName, long cost) {
        this.sparepartName = sparepartName;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSparepartName() {
        return sparepartName;
    }

    public void setSparepartName(String sparepartName) {
        this.sparepartName = sparepartName;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
