package Dao;

import Entities.Picker;

/**
 * Created by vankayab on 8/3/2017.
 */
public interface PickerDAO {
    public Picker returnDriver(String name, long mobNumber);
}
