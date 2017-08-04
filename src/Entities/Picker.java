package Entities;

/**
 * Created by vankayab on 8/3/2017.
 */
public class Picker {
    String id;
    boolean engaged;
    String name;
    String mobileno;

    public Picker() {
    }

    public Picker(String id, String name, String mobileno) {

        this.id = id;
        this.name = name;
        this.mobileno = mobileno;
    }


    public boolean isEngaged() {
        return engaged;
    }

    public void setEngaged(boolean engaged) {
        this.engaged = engaged;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
