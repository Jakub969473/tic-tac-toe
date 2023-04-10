
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String in = "         ";

        String[] temp = in.split("");

        String ticTaCToe[][] = new String[3][3];

        int jprld = 0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ticTaCToe[i][j] = temp[jprld];
                jprld++;
            }
        }

        int whoseTurn = 1;

        while(true) {


            System.out.println("---------");
            System.out.println("| " + ticTaCToe[0][0] + " " + ticTaCToe[0][1] + " " + ticTaCToe[0][2] + " |");
            System.out.println("| " + ticTaCToe[1][0] + " " + ticTaCToe[1][1] + " " + ticTaCToe[1][2] + " |");
            System.out.println("| " + ticTaCToe[2][0] + " " + ticTaCToe[2][1] + " " + ticTaCToe[2][2] + " |");
            System.out.println("---------");

            if (xWon(ticTaCToe)) {
                System.out.println("X wins");
                break;
            } else if (oWon(ticTaCToe)) {
                System.out.println("O wins");
                break;
            } else if(isFinished(ticTaCToe)){
                System.out.println("Draw");
                break;
            }


            boolean x = true;
            int[] cords = new int[2];
            while(true) {
                x = true;
                try {
                    cords = czytaj();
                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                    x = false;
                }


                if ((cords[0] <= 0 || cords[0] >= 4 || cords[1] <= 0 || cords[1] >= 4) && x) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if(x){
                    if(!ticTaCToe[cords[0]-1][cords[1]-1].equals(" ")){
                        System.out.println("This cell is occupied! Choose another one!");
                    }else{
                        if(whoseTurn == 1){
                            ticTaCToe[cords[0]-1][cords[1]-1] = "X";
                        }else{
                            ticTaCToe[cords[0]-1][cords[1]-1] = "O";
                        }
                        whoseTurn *= -1;
                        break;
                    }
                }

            }

      /*if(!isPossible(temp)){
        System.out.println("Impossible");
        possible=false;
      }*/

        }
    }

    private static int[] czytaj(){
        Scanner scanner = new Scanner(System.in);

        int[] cords = new int[2];
        cords[0] = scanner.nextInt();
        cords[1] = scanner.nextInt();

        return cords;
    }
    private static boolean isFinished(String[][] temp) {

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                if (temp[i][j].equals(" ")) {
                    //System.out.println("Game not finished");
                    return false;
                }
            }
        }
        //System.out.println("Draw");
        return true;
    }

  /*private static boolean isPossible(String[][] temp) {

    int x=0;
    int o=0;

    for(int i=0;i<9;i++){
      if(temp[i].equals("X")){
        x++;
      }else if(temp[i].equals("O")){
        o++;
      }
    }

    if((x-o>1 || o-x>1) || (xWon(temp) && oWon(temp))){
      return false;
    }else{
      return true;
    }

  }*/

    public static boolean xWon(String[][] temp){

        for(int i=0;i<3;i++){
            if(temp[i][0].equals("X") && temp[i][1].equals("X") && temp[i][2].equals("X")){
                return true;
            }else if(temp[0][i].equals("X") && temp[1][i].equals("X") && temp[2][i].equals("X")){
                return true;
            }
        }

        if(temp[0][0].equals("X") && temp[1][1].equals("X") && temp[2][2].equals("X")){
            return true;
        }else if(temp[2][0].equals("X") && temp[1][1].equals("X") && temp[0][2].equals("X")){
            return true;
        }

        return false;
    }

    public static boolean oWon(String[][] temp){

        for(int i=0;i<3;i++){
            if(temp[i][0].equals("O") && temp[i][1].equals("O") && temp[i][2].equals("O")){
                return true;
            }else if(temp[0][i].equals("O") && temp[1][i].equals("O") && temp[2][i].equals("O")){
                return true;
            }
        }

        if(temp[0][0].equals("O") && temp[1][1].equals("O") && temp[2][2].equals("O")){
            return true;
        }else if(temp[2][0].equals("O") && temp[1][1].equals("O") && temp[0][2].equals("O")){
            return true;
        }

        return false;
    }
}
