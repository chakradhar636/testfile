package Dao;

import Entities.Operator;
import Entities.ServiceOrder;

/**
 * Created by vankayab on 8/3/2017.
 */
public interface OperatorDAO {
    public boolean validate(String username,String password);

    public boolean createServicesDone(ServicesDoneDAO servicesDoneDAO);

}

