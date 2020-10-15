public class NQueens {
    private static int MaxQueens = 4;
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0},
                         {0,0,0,0},
                         {0,0,0,0},
                         {0,0,0,0}};
        if(SolveNQ(board, 0)==false)
        {
            System.out.println("NO Possible Solutions");
        }
        else{
            PrintBoard(board);
        }
    }

    public static boolean isValid(int[][] board, int row, int collumn)
    {
        //CHECKING UP
        if(row!=0)//checking up
        {
            if(board[row-1][collumn]==1)
            {
                return false;
            }

            if(collumn!=0)//checking up left
            {
                if(board[row-1][collumn -1]==1)
                {
                    return false;
                }
            }
            if(collumn!=board[0].length-1)//checking up right
            {
                if(board[row-1][collumn+1]==1)
                {
                    return false;
                }
            }
        }
        //CHECKING DOWN
        if(row!=board.length -1)
        {
            if(board[row +1][collumn]==1)
            {
                return false;
            }
            if(collumn!=0)//checking down left
            {   
                if(board[row+1][collumn -1]==1)
                {
                    return false;
                }
            }
            if(collumn!=board[0].length-1)//checking down right
            {
                if(board[row + 1][collumn+1]==1)
                {
                    return false;
                }
            }
        }

        if(collumn!=0)//checking left
        {
            if(board[row][collumn -1]==1)
            {
                return false;
            }
        }
        if(collumn!=board[0].length-1)//checking right
        {
            if(board[row][collumn+1]==1)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean SolveNQ(int[][] board, int Num)
    {
        if(Num>=MaxQueens)
        {
            return true;
        }
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                if(board[i][j]==0)
                {
                    if(isValid(board, i, j))
                    {
                        board[i][j] = 1;
                        if(SolveNQ(board, Num + 1))
                        {
                            return true;
                        }
                        board[i][j] = 0;
                    }
                }
            }
        }
        return false;
    }


    public static void PrintBoard(int[][] board)
    {
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0;j<board[0].length;j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}