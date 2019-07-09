package main.java.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import main.java.util.Parents;

/*
 * 字符串练习
*/
public class StringArrayTest extends Parents {

	public static void main(String[] ages)  { 
		Date[] dateArr = new Date [9];
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1= new SimpleDateFormat("HHmmss");
        try {
        	Date d1 = df.parse("1970-1-1 00:00:00");
            Date d2 = df.parse("2000-1-1 00:00:00");
            for(int i = 0; i < 9; i++) {
            	long random = (long)(Math.random()*(d2.getTime()-d1.getTime()))+d1.getTime();
            	dateArr[i] = new Date(random);
            }
            
            for(Date i : dateArr) {
           	 prints( "排序前 "+ df.format(i));
           }
            
            for(int i = 0; i < 9; i++) {
            	for(int j = 0; j < 9; j++) {
                	if( Integer.parseInt(df1.format(dateArr[i])) < Integer.parseInt(df1.format(dateArr[j]))) {
                		Date temp = dateArr[i];
                		dateArr[i] = dateArr[j];
                		dateArr[j] = temp;
                	}
                }
            }
            for(Date i : dateArr) {
            	 prints( "排序后 "+ df.format(i));
            }
            
            Calendar c = Calendar.getInstance();
            prints(df.format(c.getTime()));
            c.add(Calendar.MONTH , 2);
            prints(df.format(c.getTime()));
            c.set(Calendar.DATE , -2);
            prints(df.format(c.getTime()));
            
            
            
        } catch (ParseException e) {
        	e.printStackTrace();
        }
        
	}

}
