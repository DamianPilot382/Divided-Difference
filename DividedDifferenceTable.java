public class DividedDifferenceTable{

    public double[][] table;

    public DividedDifferenceTable(double[][] givenValues){
        this.initializeTable(givenValues);

        this.fillTable();
    }

    private void initializeTable(double[][] givenValues){
        table = new double[givenValues.length+1][];

        table[0] = new double[givenValues.length];
        table[1] = new double[givenValues.length];

        for(int index = 0; index < givenValues.length; index++){
            table[0][index] = givenValues[index][0];
            table[1][index] = givenValues[index][1];
        }

        for(int index = 2; index < table.length; index++){
            table[index] = new double[givenValues.length-index+1];
        }
    }

    private void fillTable(){
        
        int distance = 2;
        for(int col = 2; col < table.length; col++){
            for(int row = 0; row < table[col].length; row++){
                int a = col+row-1;
                int b = col+row-distance;

                double numerator = table[col-1][row+1] - table[col-1][row];
                double denominator = table[0][a]-table[0][b];

                table[col][row] = numerator/denominator;
            }
            distance++;
        }
    }

    public void printTable(){

        for(int col = 0; col < table.length; col++){
            if(col == 0)
                System.out.print("x: ");
            else{
                System.out.print("f[");
                for(int i = 1; i < col; i++)
                    System.out.print(",");
                System.out.print("]: ");
            }
            for(int row = 0; row < table[col].length; row++){
                System.out.printf("%.2g,", table[col][row]);
            }
            System.out.println();
        }
        
        // int rowCount = (table[0].length << 1) - 1;

        // for(int row = 0; row < rowCount; row++){

        //     if(row % 2 == 0){
        //         System.out.print(table[0][row >> 1]+"\t"+table[1][row >> 1]+"\t");
        //     }else{
        //         System.out.print("\t\t");
        //     }

        //     for(int col = 2; col <= row+1 && col < ; col++){

        //         if(row % 2 != 0){
        //             if(col % 2 == 0){
        //                 System.out.print(table[col][row >> 1]+"\t");
        //             }
        //         }else if(col % 2 != 0){
        //             System.out.print(table[col][row >> 1]+"\t");
        //         }


        //         //System.out.print("["+row+"]["+col+"]"+"\t");
        //     }
        //     System.out.println();
        // }

        // System.out.printf(table[0][0]+"\t"+table[1][0]+"\n");
        // System.out.printf("\t\t"+table[2][0]+"\n");
        // System.out.printf(table[0][1]+"\t"+table[1][1]+"\t\t"+table[3][0]+"\n");
        // System.out.printf("\t\t"+table[2][1]+"\t\t"+table[4][0]+"\n");
        // System.out.printf(table[0][2]+"\t"+table[1][2]+"\t\t"+table[3][1]+"\n");
        // System.out.printf("\t\t"+table[2][2]+"\n");
        // System.out.printf(table[0][3]+"\t"+table[1][3]+"\n");

    }



}