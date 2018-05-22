package com.alisonjc.matchchallenge;

import com.alisonjc.matchchallenge.model.Datum;

import java.util.Comparator;


public class MatchComparator implements Comparator<Datum> {
    @Override
    public int compare(Datum o1, Datum o2) {
        if(o1.getMatch() == o2.getMatch()) {
            return 0;
        } else if (o1.getMatch() < o2.getMatch()){
            return 1;
        } else {
            return -1;
        }
    }
}
