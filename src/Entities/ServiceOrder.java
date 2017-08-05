package Entities;

/**
 * Created by vankayab on 8/2/2017.
 */
public class ServiceOrder {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String regno;
    String opcode;

    public ServiceOrder() {
    }

    public ServiceOrder(String regno, String opcode) {
        this.regno = regno;
        this.opcode = opcode;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getOpcode() {
        return opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }
}
