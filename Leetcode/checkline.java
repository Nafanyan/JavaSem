public class checkline {
    
    public static void main(String[] args) {
        int[][] coordinate = {{0,0},{0,1},{0,-1}};
        System.out.println(checkStraightLine(coordinate));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        for (byte i = 1; i < coordinates.length - 1; i ++)
        {
            if ( (coordinates[i][1] - coordinates[i-1][1]) * (coordinates[i+1][0] - coordinates[i][0]) 
            != (coordinates[i+1][1] - coordinates[i][1]) * (coordinates[i][0] - coordinates[i-1][0]) ) 
            return false;
        }
        return true;
    }
}
