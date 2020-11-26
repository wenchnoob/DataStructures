package PracticeAlgorithms;


import java.util.Scanner;

public class Playground {
    private static int j, k = 12;
    static boolean isBig = false;

    static {
        if (isBig) j = 10;
        else j = 5;
    }

    class hey {
        boolean isTalking = true;
        void hello() {System.out.println("Hey");}
    }

    public static void main(String[] args) {
        System.out.println(Playground.j + " " + Playground.k);
        Playground.isBig  = true;
        System.out.println(Playground.j);

        hey h = new Playground().new hey();
        System.out.println(h.isTalking);
        h.hello();


        boolean p = true;
        first: {
            print("I am first");
            second: {
                print("I am second");
                third: {
                    if (p) break second; // Skip the next statement
                    print("I am third");
                }
            }
        }

        outer: for (var i = 0; i < 10; i++)
            for (var j = 0; j < 10; j++) {
                if (i == 1 && j == 5) break outer;
                System.out.println(i + " " + j);
            }
    }


    public void main2() {
        final var num = 12;
        System.out.println(num);

        hey hello = new hey();

        //byte = 8 bit, short = 16, int = 32, long = 64
        int j = 0b101;
        byte k = 0b1101;
        System.out.println(j);
        System.out.println(k);

        byte c = (byte) 100000;
        long i = c;
        System.out.println(c);

        char p = 8;

        byte z = rInt();
        byte notZ = (byte)~z;
        var zero = z & notZ;
        System.out.printf("Z is this: %o \nAnd not Z = %o \nAnd zero = %d \n", z, notZ, zero);

        var h = z | ~z;
        System.out.println(h);


        int x = 0b0101;
        int y = x << 1;
        int m = y >> 2;
        int notX = ~x;


        System.out.println(x + " " + notX + " " + y + " " + m);

        byte l = - 0b0101; // -5
        byte l2 = (byte)(l << 5);
        System.out.println(l + " " + l2);

        boolean t = true;
        t &= true;

        boolean f = false;
        f &= true;

        t |= false;

        System.out.println(t + " " + f);

        int a = k = c = 100;

        System.out.println(a + " " + k + " " + c);

        print(String.valueOf(a), String.valueOf(k), String.valueOf(c));

        System.out.println(abs(15));
        System.out.println(mod2(115));

        System.out.println((9 | 12));


        Scanner s = new Scanner(System.in);

        String in = s.nextLine();

        switch(in) {
            case "apple":
                System.out.println("You asked for an apple");
                break;
            case "orange":
                System.out.println("You asked for an orange");
                break;
            case "cherry":
                System.out.println("You asked for a cherry");
        }

    }

    private static byte rInt() { return 42; }

    private static void print(String...a) {
        for(var s : a) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static int abs(int x) {
        return x < 0 ? -x : x;
    }

    private static int mod2 (int x) {
        return x >> 1;
    }

}
