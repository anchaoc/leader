package com.ac.objects;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;

import java.util.Calendar;

/**
 * @author anchao
 * @date 2020/3/7 14:59
 */
public class ObjectsTest {

    static class Guava implements Comparable<Guava>{

        private final String manufacturer;
        private final String version;
        private final Calendar releaseDate;

        public Guava(String manufacturer, String version, Calendar releaseDate) {
            this.manufacturer = manufacturer;
            this.version = version;
            this.releaseDate = releaseDate;
        }


        @Override
        public String toString() {
            //guava
            return MoreObjects.toStringHelper(this).omitNullValues()
                    .add("manufacturer",this.manufacturer).toString();
            //add...TODO
        }


        @Override
        public int compareTo(Guava o) {
            return ComparisonChain.start()
                    .compare(this.version,o.version)
                    //.compare...TODO
                    .result()
                    ;
        }
    }

    public static void main(String[] args) {
        Guava guava = new Guava("Google","23.0",Calendar.getInstance());
        System.out.println(guava);
        System.out.println(guava.hashCode());
    }
}
