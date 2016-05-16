package com.emilburzo.datoriistat.main;


import com.emilburzo.datoriistat.parser.Parser;

public class Main {

    public static void main(String[] args) {
        try {
            new Parser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
