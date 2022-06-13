import java.sql.Array;
import java.util.Arrays;

public class Horse {

    public static void main(String[] args) {
       int n = 8; 
        int[][] horseDo = { { -2, 1 }, { -2, -1 },
                { -1, 2 }, { 1, 2 },
                { 2, 1 }, { 2, -1 },
                { -1, -2 }, { -1, -2 } };
        int[][] board = new int[n][n];
        
        for (int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean checkMove(int[] move, int[] position, int size)
    {
        if (move[0] + position[0] >= 0 && move[0] + position[0] < size
        && move[1] + position[1] >= 0 && move[1] + position[1] < size){
            return true;
        }
        return false;
    }

    public static void doMoveHorse(int[][] board, int[][] horseMove, int[] position, int index){
        if(!checkMove(horseMove[index], position, board.length)){
            return;
        }
        board[position[0]][position[1]] += 1;

        for(int i = 0; i < horseMove.length; i ++){
            if(!checkMove(horseMove[index], position, board.length)){
                position[0] = horseMove[index][0] + position[0];
                position[1] = horseMove[index][1] + position[1];
                doMoveHorse(board, horseMove, position, index);
                return;
            }

        }

        
    }
}