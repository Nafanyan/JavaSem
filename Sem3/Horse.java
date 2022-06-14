import java.sql.Array;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.xml.crypto.KeySelector.Purpose;

public class Horse {

    static int[][] board;
    static int[][] moves;
    static int maxMoves;

    public static void main(String[] args) {
        board = new int[4][4];
        maxMoves = board.length * board[0].length;
        moves = new int[][] { { -2, 1 }, { -2, -1 },
                { -1, 2 }, { 1, 2 },
                { 2, 1 }, { 2, -1 },
                { -1, -2 }, { -1, -2 } };

        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j++){
                if(findPath(i, j, 1)){
                    printSol();
                    return;
                }
            }
        }
        System.out.println("Нет решений");
    }

    static boolean isPossible(int x, int y){
        return x >=0 && x < board.length && y >= 0 && y < board.length && board[x][y] == 0; 
    }

    static boolean findPath(int curX, int curY, int moveNum){
        board[curX][curY] = moveNum;
        if(moveNum >= maxMoves) return true;
        
        for(int i = 0; i < 8; i++){
            int nextX = curX + moves[i][0];
            int nextY = curY + moves[i][1];
            if(isPossible(nextX, nextY) && findPath(nextX, nextY, moveNum + 1)){
                return true;
            }
        }
        board[curX][curY] = 0;
        return false;
    }

    static void printSol(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.println(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}