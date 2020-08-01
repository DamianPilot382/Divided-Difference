import java.text.DecimalFormat;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {
    
    private DividedDifferenceTable table;
    private double[][] t;
    private String unsimpPoly;

    public Polynomial(double[][] givenValues){
        this.table = new DividedDifferenceTable(givenValues);
        this.t = this.table.getTable();

    }

    public void printDividedDifferenceTable(){
        this.table.printTable();
    }

    public String getUnsimplifiedPolynomial(){

        if(this.unsimpPoly != null)
            return this.unsimpPoly;

        DecimalFormat decFormat = new DecimalFormat("+#.###;-#.###");


        StringBuilder builder = new StringBuilder();

        StringBuilder xTerms = new StringBuilder();

        for(int col = 1; col < t.length; col++){

            builder.append(decFormat.format(t[col][0]));
            builder.append(xTerms.toString());

            
            xTerms.append("(x");
            if(t[0][col-1] != 0){
                xTerms.append(decFormat.format(-t[0][col-1]));
            }
            xTerms.append(")");

            builder.append(" ");
        }


        this.unsimpPoly = builder.toString().substring(1);

        return this.unsimpPoly;

    }

    public String getSimplifiedPolynomial(){

        DoubleLinkedList coefficients = new DoubleLinkedList();

        coefficients.addLast(1.);
        coefficients.addLast(-t[0][0]);

        for(int col = 1; col < t[col].length; col++){
            double next = -t[0][col];

            coefficients.addLast(0.);

            Node node = coefficients.getLast();

            while(node.previous != null){
                double current = node.previous.data;
                node.data = current * next + node.data;

                node = node.previous;
            }

        }

        coefficients.print();

        return "";

    }

}