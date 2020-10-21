package e3;

import java.lang.management.PlatformManagedObject;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Clock {


    public int hours;
    public int minutes;
    public int seconds;
    public enum Period{
        PM,
        AM
    }
    public Period period;
    /**
     * Creates a Clock instance parsing a String .
     * @param s The string representing the hour in 24h format (17:25:15) or in
     * 12h format (05:25:15 PM ).
     * @throws IllegalArgumentException if the string is not a valid hour .
     */
    public Clock (String s) {

        if(s==null||(s.length()!=8&&s.length()!=11)||s.charAt(2)!=':'||s.charAt(5)!=':') throw new IllegalArgumentException();
        int hInt, minInt, secInt;
        if(s.length() == 11){
            if(s.charAt(8)!=' ') throw new IllegalArgumentException();
            String[] time = s.split(" ");
            if (time.length!=2||(!time[1].equals("PM") && !time[1].equals("AM"))) throw new IllegalArgumentException();

            String[] timeSplit = time[0].split(":");
             hInt = Integer.parseInt(timeSplit[0]);
             minInt = Integer.parseInt(timeSplit[1]);
             secInt = Integer.parseInt(timeSplit[2]);
            if( hInt >12) throw new IllegalArgumentException();
            period= (time[1].equals("PM"))? Period.PM : Period.AM;
        } else {
            String[] timeSplit = s.split(":");
             hInt = Integer.parseInt(timeSplit[0]);
             minInt = Integer.parseInt(timeSplit[1]);
             secInt = Integer.parseInt(timeSplit[2]);
             period=null;
        }
        if( (hInt<0) || (hInt >23) || (minInt<0) || (minInt > 59) || (secInt<0) || (secInt > 59)) throw new IllegalArgumentException();

        hours=hInt;
        minutes=minInt;
        seconds=secInt;
    }


    /**
     * Creates a clock given the values in 24h format .
     * @param hours Hours in 24h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */
    public Clock ( int hours, int minutes, int seconds ) {
        if ((hours>23||hours<0)||(minutes>59||minutes<0)||(seconds>59||seconds<0)) throw new IllegalArgumentException();
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.period=null;


    }
    /**
     * Creates a clock given the values in 12h format . Period is a enumeration
     * located inside the Clock class with two values : AM and PM.
     * @param hours Hours in 12h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @param period Period used by the Clock ( represented by an enum ).
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */
    public Clock ( int hours, int minutes, int seconds, Period period ) {

        if (hours>12||hours<0||minutes>59||minutes<0||seconds>59||seconds<0||(period!=Period.PM&&period!=Period.AM)) throw new IllegalArgumentException();
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.period=period;

    }
    /**
     * Returns the hours of the clock in 24h format
     * @return the hours in 24h format
     */
    public int getHours24 () {
        if (period==null) return hours;
        if (period==Period.AM) return hours%12;
        return (hours+12);
    }
    /**
     * Returns the hours of the clock in 12h format
     * @return the hours in 12h format
     */
    public int getHours12 () {

        if (period==Period.PM||period==Period.AM||hours<=12) return hours;
        else return hours -12;

    }/**
     * Returns the minutes of the clock
     * @return the minutes
     */
    public int getMinutes () {

        return minutes;

    }
    /**
     * Returns the seconds of the clock .
     * @return the seconds .
     */
    public int getSeconds () {

        return seconds;

    }
    /**
     * Returns the period of the day (AM or PM) that the clock is representing
     * @return An instance of the Clock . Period enum depending if the time is
     * before noon (AM) or after noon (PM ).
     */
    public Period getPeriod () {

        if (period==Period.PM||hours>12) return Period.PM;
        else return Period.AM;

    }
    /**
     * Prints a String representation of the clock in 24h format .
     * @return An string in 24h format
     * @see String . format function to format integers with leading zeroes
     */
    public String printHour24 () {

        String timeColonPattern = "HH:mm:ss";
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
        int hours1 = hours;
        if(period==Period.PM && hours<=12 && hours>0) hours1=hours1+12;
        else if(hours==12 && period==Period.AM) hours1= 0;
        LocalTime time = LocalTime.of(hours1, minutes, seconds);
        return timeColonFormatter.format(time);

    }

    /**
     * Prints a String representation of the clock in 12h format .
     * @return An string in 12h format
     * @see String . format function to format integers with leading zeroes
     */
    public String printHour12 () {

        String timeColonPattern = "hh:mm:ss";
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
        LocalTime time = LocalTime.of(hours, minutes, seconds);
        String timeDone = timeColonFormatter.format(time);
        if(hours>12||period==Period.PM) return timeDone  + " PM";
        else return timeDone  + " AM";
    }
    /**
     * Performs the equality tests of the current clock with another clock
     * passed as a parameter . Two clock are equal if they represent the same
     * instant regardless of being in 12h or 24h format .
     * @param o The clock to be compared with the current clock .
     * @return true if the clocks are equals , false otherwise .
     */
    @Override
    public boolean equals ( Object o) {
        if (o==null) return false;
        if (o.getClass()==this.getClass()) return this.hashCode() == o.hashCode();
        return false;

    }
    /**
     * Returns a integer that is a hash code representation of the clock using
     * the " hash 31" algorithm .
     * Clocks that are equals must have the same hash code .
     * @return the hash code
     */
    @Override
    public int hashCode () {

        int hash = 7;
        if(period==Period.AM||period==null) hash*= (31 + hours) ;
        else hash*= (31+(hours+12));
        hash*= (31 + minutes);
        hash*= (31 + seconds);
        return hash;
    }
}