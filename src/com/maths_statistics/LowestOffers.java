package com.maths_statistics;

import java.util.LinkedList;
import java.util.List;

/*
@GS Find lowest offers in a given interval
 */
public class LowestOffers {

    public static void main(String[] args) {

        List<Offering> offers = new LinkedList<>();

        Offering offer1 = new Offering(1, 6, 20);
        offers.add(offer1);
        Offering offer2 = new Offering(2, 5, 15);
        offers.add(offer2);
        Offering offer3 = new Offering(2, 7, 5);
        offers.add(offer3);

        List<Interval> intervals = new LinkedList<>();

        Interval inter1 = new Interval(1, 2);
        intervals.add(inter1);
        Interval inter2 = new Interval(2, 5);
        intervals.add(inter2);
        Interval inter3 = new Interval(5, 6);
        intervals.add(inter3);

        findLowestOffers(offers, intervals);

    }

    static void findLowestOffers(List<Offering> offers, List<Interval> intervals) {
        double offer_price = Double.MAX_VALUE;
        List<Double> lowestOffers = new LinkedList<>();
        for (Interval interval : intervals) {
            for (Offering offer : offers) {
                if (interval.start >= offer.start && interval.end <= offer.end) {
                    offer_price = Double.min(offer_price, offer.price);
                }
            }
            lowestOffers.add(offer_price);
            offer_price = Double.MAX_VALUE;
        }
        System.out.println(lowestOffers);
    }

    private static class Offering {
        int start;
        int end;
        double price;

        public Offering(int start, int end, double price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
