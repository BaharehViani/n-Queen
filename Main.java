import java.util.Scanner;
 
public class Main {
    
    public static void chessboard(int[] queens){

        int n = queens.length;

        for (int r = 0; r < n; r++) {

            int p = queens[r];

            for (int c = 0; c < n; c++) {
                System.out.print(" ---");
            }
            System.out.println();

            for (int c = 0; c < n+1; c++) {
                
                System.out.print(c == p ? "| * " : "|   ");
            }
            System.out.println();
        }

        for (int c = 0; c < n; c++) {
            System.out.print(" ---");
        }
        System.out.println("\n");
    }

    public static boolean checkHit(int row, int[] queens){
        for (int i = 0; i < row; i++) {
            if(queens[row] == queens[i]){
                return true;
            }
            if(Math.abs(queens[row] - queens[i]) == (row - i)){
                return true;
            }
        }
        return false;
    }

    public static boolean fillRow(int row, int[] queens){

        if(row == queens.length){
            return true;
        }

        for (int i = 0; i < queens.length; i++) {
            queens[row] = i;
            if(checkHit(row, queens)){
                continue;
            }
            if(!fillRow(row+1, queens)){
                continue;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Enter number of Queens: ");
            try{
                n = scan.nextInt();
                break;
            }
            catch(Exception e){
                scan.nextLine();
                System.out.println("Invalid input value");
            }
        }
        scan.close();

        int[] queens = new int[n];

        //solve 
        if(fillRow(0, queens)){
            //print result
            chessboard(queens);
        }
        else{
            System.out.println("There is no solution");
        }
    }
}
