package Dao;

import Entities.Operator;

/**
 * Created by vankayab on 8/3/2017.
 */
public interface OperatorDAO {
    public boolean validate(Operator operator);
    public boolean createSerevicesDone(ServicesDoneDAO servicesDoneDAO);

}
