package PracticeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public static void main(String[] args) {
        Fraction f1 = new Fraction(6, 14);
        Fraction f2 = Fraction.simplify(f1);
        Fraction f3 = f2.subtract(new Fraction(0, 14));
        Fraction f4 = findClosestEgyptianFraction(f3);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);

        List<Fraction> fracts = egyptianFractions(new Fraction(3, 11));
        System.out.println(fracts);



    }

    public static List<Fraction> egyptianFractions(Fraction fraction) {
        List<Fraction> ls = new ArrayList<>();
        while(!(fraction.getNumerator() == 0)) {
            Fraction closest = findClosestEgyptianFraction(fraction);
            ls.add(closest);
            fraction = fraction.subtract(closest);
        }
        return  ls;
    }

    public static Fraction findClosestEgyptianFraction(Fraction fraction) {
        int denom = 2;
        Fraction curFraction = new Fraction(1, denom);
        while(curFraction.compareTo(fraction) > 0) {
            curFraction = new Fraction(1, ++denom);
        }
        return curFraction;
    }
}

class Fraction implements Comparable<Fraction> {
    private int numerator, denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int compareTo(Fraction o) {
        return numerator * o.denominator - o.numerator * denominator;
    }

    public Fraction subtract(Fraction o) {
        int newNumerator = numerator * o.denominator - o.numerator * denominator;
        return Fraction.simplify(new Fraction(newNumerator, denominator * o.denominator));
    }

    public static Fraction simplify(Fraction f) {
        int divisor = f.gcd(f.numerator, f.denominator);
        int numerator = 0;
        int denominator = 0;
        if (divisor != 0) {
            numerator = f.numerator / divisor;
            denominator = f.denominator / divisor;
        }
        return new Fraction(numerator, denominator);
    }

    private int gcd(int i, int j) {
        if (i == 0 || j == 0) return 0;

        if (i > j) {
            if (i%j == 0) return j;
            return gcd(i%j, j);
        } else {
            if (j%i == 0) return i;
            return gcd(j%i, i);
        }
    }

    public boolean isZero() {
        if (numerator == 0) return true;
        return false;
    }

    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    public String toString() {
        return numerator + "/" + denominator;
    }
}