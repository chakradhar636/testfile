package Dao;

import java.util.Map;

/**
 * Created by vankayab on 8/3/2017.
 */
public interface ServiceOrderDAO {
    public boolean addServiceOrder(String regno,String opcode);
    public Map<String,Integer> getServiceOrder(String regno);
}
