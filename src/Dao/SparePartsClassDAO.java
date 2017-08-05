package Dao;

import Entities.SparePartsClass;

import java.util.ArrayList;

/**
 * Created by vankayab on 8/4/2017.
 */
public interface SparePartsClassDAO {
    public boolean addSpareparts(SparePartsClass sparePartsClass);
    public ArrayList<SparePartsClass> listSpareparts();
}
