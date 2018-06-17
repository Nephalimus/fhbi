package Arbeiten_mit_JTable;

import java.util.Comparator;


public class IntegerComparator implements Comparator<String>{

	public int compare(String num1, String num2) 
    {

            return Integer.parseInt(num1)-Integer.parseInt(num2);
    }

}
