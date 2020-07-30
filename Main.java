import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        double[][] givenValues = new double[][]{{1, 3}, {3./2, 13./4}, {0, 3}, {2, 5./3}};

        DividedDifferenceTable polynomial = new DividedDifferenceTable(givenValues);

        polynomial.printTable();

    }
}