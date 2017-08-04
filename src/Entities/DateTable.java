package Entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bholar on 8/2/2017.
 */
public class DateTable {
    public int id;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public Date today = new Date();
    Date dt = formatter.parse(formatter.format(today));
    public int slotcnt;


    public DateTable() throws ParseException {
    }

    public DateTable( Date dt, int slotcnt) throws ParseException {
        this.dt = dt;
        this.slotcnt = slotcnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(DateFormat formatter) {
        this.formatter = formatter;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public int getSlotcnt() {
        return slotcnt;
    }

    public void setSlotcnt(int slotcnt) {
        this.slotcnt = slotcnt;
    }
}
