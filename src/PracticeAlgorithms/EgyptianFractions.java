package PracticeAlgorithms;

import java.util.List;

public class EgyptianFractions {

    public static void main(String[] args) {
        Fraction f1 = new Fraction(6, 14);
        Fraction f2 = Fraction.simplify(f1);
        Fraction f3 = f2.subtract(new Fraction(3, 14));

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

    }

    public static List<String> eqyptianFractions(Fraction fraction) {
        return  null;
    }
}

class Fraction {
    private int numerator, denominator;

    Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Fraction denominator cannot be 0.");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction subtract(Fraction o) {
        int newNumerator = numerator * o.denominator - o.numerator * denominator;
        return Fraction.simplify(new Fraction(newNumerator, denominator * o.denominator));
    }

    public static Fraction simplify(Fraction f) {
        if (f == null) throw new IllegalArgumentException("This method does not accept null arguments");
        int divisor = f.gcd(f.numerator, f.denominator);
        int numerator = f.numerator / divisor;
        int denominator = f.denominator / divisor;
        return new Fraction(numerator, denominator);
    }

    private int gcd(int i, int j) {
        if (i > j) {
            if (i%j == 0) return j;
            return gcd(i%j, j);
        } else {
            if (j%i == 0) return i;
            return gcd(j%i, i);
        }
    }

    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    public String toString() {
        return numerator + "/" + denominator;
    }
}