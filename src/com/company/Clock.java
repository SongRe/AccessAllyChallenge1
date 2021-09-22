package com.company;

// custom class clock for simulation
public class Clock {
    private int hour; //
    private int []minute; // an array of two integers to hold the minute value, since the minute can have a leading zero, where minute 12 = [1,2] (position 0 is the tens position)
    private int count;

    public Clock() {
        this.hour = 12;
        this.minute = new int[2];
        count = 0;
    }

    public Clock(int hour, int[] minute) {
        this.hour = hour;
        this.minute = minute;
    }
    // since after 11 hours, and 59 minutes, all the possible clock combinations would be discovered, any value d bigger than that will simply be shortened to 11 * 60 + 59 = 719 minutes
    public void addTime(long d) {

//        if (d > 719)  {
//            count = (int) (d / 719 * 31) - 1; //headstart the count (in 719 minutes (12:00 -> 11:59), there are 31 arithmetic sequences),
//            toAdd = d % 719; //we only need to iterate through the remainder
//        }
        // we will add a minute at a time and check each arithmetic combination
        for(int i = 0; i < d; i++) {
            minute[1]++; //add 1 minute
            if(minute[1] > 9) { //simply counting by the clock values
                minute[1] = 0;
                minute[0]++;
                if(minute[0] > 5) { //we cannot go to 60 minutes on a clock
                    minute[0] = 0;
                    hour++;
                    if (hour > 12) {
                        hour = 1;
                    }
                }
            }

            int difference = (minute[1] - minute[0]);
            if(hour == 10) { //consider special hour cases
            } else if(hour == 11 && minute[0] == 1 && minute[1] == 1) {
                count++;
            } else if(hour == 12 && minute[0] == 3 && minute[1] == 4) {
                count++;
            } else if(minute[0] - hour == difference) { // main comparison
                count++;
            }
        }
    }

    public int getCount() {
        return this.count;
    }

}
