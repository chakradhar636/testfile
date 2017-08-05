package Entities;

/**
 * Created by vankayab on 8/2/2017.
 */
public class Operator {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String Username;
    String Password;

    public Operator() {
    }

    public Operator(String username, String password) {

        Username = username;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public void createServiceOrder()
    {

    }
    public void createServicesDone()
    {

    }
}
