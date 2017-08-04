package Entities;

/**
 * Created by bholar on 8/4/2017.
 */
public class DriverClass {
    private int id;
    private String name;
    private long mobile;

    public DriverClass() {
    }

    public DriverClass(String name, long mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}
