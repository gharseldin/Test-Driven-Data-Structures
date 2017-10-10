import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SecondClass {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scanner = new Scanner(System.in);
        
        MyDate actual = aquireDate(scanner);
        MyDate expected = aquireDate(scanner);
        
        scanner.close();
        
        // if the book was returned on time
        if(actual.earlierOrEqual(expected))
            System.out.println(0);
        
        // We are sure the book is late at this point
        else{
            // if its only days late
            System.out.println(actual.calculateFine(expected));      
        }
    }
    
    private static MyDate aquireDate (Scanner scanner){

        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        return new MyDate(day, month, year);

    }
}



class MyDate {
    
    final static int DAY_FINE = 15;
    final static int MONTH_FINE = 500;
    final static int YEAR_FINE = 10000;
    
    int day;
    int month;
    int year;
    
    MyDate(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }
    
    boolean isSameMonthAndYear(MyDate other){
        if((other.year == year)&&(other.month == month))
            return true;
        return false;
    }
    
    boolean isSameYear(MyDate other){
        if(other.year == year)
            return true;
        return false;
    }
    
    boolean earlierOrEqual(MyDate other){
        if ((year <= other.year)&&(month <= other.month) && (day <= other.day))
            return true;
        return false;
    }
    
    int calculateFine(MyDate expected){
        int fine = 0;
        
        // only days late
        if(isSameMonthAndYear(expected))
            fine = DAY_FINE * (day-expected.day);
        else if (isSameYear(expected))
            fine = MONTH_FINE * (month - expected.month);
        else 
            fine = YEAR_FINE ;
        
        return fine;
    }
}