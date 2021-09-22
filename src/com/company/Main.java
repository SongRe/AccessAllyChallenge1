package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Clock c = new Clock();
        Scanner sc = new Scanner(System.in);
        long d = sc.nextLong();
        c.addTime(d);
        System.out.println(c.getCount());

    }


}

