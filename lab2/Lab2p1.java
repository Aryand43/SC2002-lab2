import java.util.Scanner;

public class Lab2p1 {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Perform the following methods:");
            System.out.println("1: multiplication test");
            System.out.println("2: quotient using division by subtraction");
            System.out.println("3: remainder using division by subtraction");
            System.out.println("4: count the number of digits");
            System.out.println("5: position of a digit");
            System.out.println("6: extract all odd digits");
            System.out.println("7: quit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: mulTest(); break;
                case 2: 
                    System.out.print("Enter m: "); int m1 = sc.nextInt();
                    System.out.print("Enter n: "); int n1 = sc.nextInt();
                    System.out.println("Quotient is " + divide(m1, n1));
                    break;
                case 3:
                    System.out.print("Enter m: "); int m2 = sc.nextInt();
                    System.out.print("Enter n: "); int n2 = sc.nextInt();
                    System.out.println("Remainder is " + modulus(m2, n2));
                    break;
                case 4:
                    System.out.print("Enter n: "); int n3 = sc.nextInt();
                    System.out.println("Count = " + countDigits(n3));
                    break;
                case 5:
                    System.out.print("Enter n: "); int n4 = sc.nextInt();
                    System.out.print("Enter digit: "); int d1 = sc.nextInt();
                    System.out.println("Position = " + position(n4, d1));
                    break;
                case 6:
                    System.out.print("Enter n: "); long n5 = sc.nextLong();
                    System.out.println("OddDigits = " + extractOddDigits(n5));
                    break;
                case 7: System.out.println("Program terminating …."); break;
                default: System.out.println("Invalid choice"); break;
            }
        } while (choice < 7);
    }

    public static void mulTest() {
        Scanner sc = new Scanner(System.in);
        int correct = 0;
        for (int i = 0; i < 5; i++) {
            int a = (int)(Math.random() * 9) + 1;
            int b = (int)(Math.random() * 9) + 1;
            System.out.print("How much is " + a + " times " + b + "? ");
            int ans = sc.nextInt();
            if (ans == a * b) correct++;
        }
        System.out.println(correct + " answers out of 5 are correct.");
    }

    public static int divide(int m, int n) {
        int count = 0;
        while (m >= n) {
            m -= n;
            count++;
        }
        return count;
    }

    public static int modulus(int m, int n) {
        while (m >= n) {
            m -= n;
        }
        return m;
    }

    public static int countDigits(int n) {
        if (n <= 0) {
            System.out.println("Error input!!");
            return 0;
        }
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static int position(int n, int digit) {
        int pos = 1;
        while (n != 0) {
            if (n % 10 == digit) return pos;
            n /= 10;
            pos++;
        }
        return -1;
    }

    public static long extractOddDigits(long n) {
        if (n <= 0) {
            System.out.println("Error input!!");
            return -1;
        }
        long result = 0, multiplier = 1;
        while (n != 0) {
            long digit = n % 10;
            if (digit % 2 == 1) {
                result = digit * multiplier + result;
                multiplier *= 10;
            }
            n /= 10;
        }
        return (result == 0) ? -1 : result;
    }
}


