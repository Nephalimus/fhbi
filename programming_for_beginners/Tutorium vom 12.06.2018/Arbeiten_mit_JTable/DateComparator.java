package Arbeiten_mit_JTable;

import java.util.Comparator;
import java.util.Date;

class DateComparator implements Comparator<Date>
{
    public int compare(Date date1, Date date2) 
    {

            return date1.compareTo(date2);
    }
}
