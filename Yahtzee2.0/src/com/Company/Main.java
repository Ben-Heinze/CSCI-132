package com.Company;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        Yahtzee first = new Yahtzee();
        final int ROLLS = 5000;
        first.play(ROLLS);//loops dice, grades, then counts it
    }
}
