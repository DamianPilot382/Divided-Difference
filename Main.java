import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        double[][] givenValues = getFromFile();

        Polynomial polynomial = new Polynomial(givenValues);

        System.out.println("Divided Difference Table:");
        polynomial.printDividedDifferenceTable();
        
        System.out.println("Unsimplified Polynomial:");
        System.out.println(polynomial.getUnsimplifiedPolynomial());

        System.out.println("Simplified Polynomial:");
        System.out.println(polynomial.getSimplifiedPolynomial());

    }

    public static double[][] example(){
        return new double[][]{{1, 3}, {3./2, 13./4}, {0, 3}, {2, 5./3}};
    }

    public static double[][] getFromFile(){
        Scanner in = new Scanner(System.in);

        do{
            System.out.println("For the example, please type 'example'.");
            System.out.print("For file, please enter file name in the same directory (.txt recommended): ");
            String name = in.nextLine();

            if(name.toLowerCase().equals("example")){
                return example();
            }

            try{

                String input = new String(Files.readAllBytes(Paths.get(name)), StandardCharsets.UTF_8);

                String[] rows = input.split("\\n");

                String[] x = rows[0].split("\\s{1,}");
                String[] fx = rows[1].split("\\s{1,}");

                double[][] result = new double[x.length][];

                for(int i = 0; i < x.length; i++){
                    result[i] = new double[]{Double.parseDouble(x[i]), Double.parseDouble(fx[i])};
                }

                in.close();

                return result;

            }catch(Exception e){
                System.out.println("That wasn't quite right. Try again.");
                System.out.println("Make sure file is right and that you added the extension.");
                System.out.println("Also, make sure file has all the x values in the first row separated by space, " + 
                "and all the f(x) values in the next row also separated by space.");
            }

        }while(true);


    }
}