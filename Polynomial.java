import java.text.DecimalFormat;

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
                xTerms.append(decFormat.format(t[0][col-1]));
            }
            xTerms.append(")");

            builder.append(" ");
        }


        this.unsimpPoly = builder.toString().substring(1);

        return this.unsimpPoly;

    }

}