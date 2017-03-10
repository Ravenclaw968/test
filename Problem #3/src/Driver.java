import java.util.ArrayList;
import java.util.Scanner;
public class Driver
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Board> boards = new ArrayList<Board>();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 6; i ++)
        {
            System.out.print("");
            String str = input.nextLine();
            boards.add(new Board(str));
        }
        for (int i = 0; i < boards.size() - 1; i ++)
        {
            Board board = boards.get(i);
            outer:
            for (int j = 0; j < 8; j ++)
            {
                for (int k = 0; k < 8; k ++)
                {
                    Board newBoard = board.press(j, k);
                    if (newBoard.equals(boards.get(i + 1)))
                    {
                        System.out.println(board.get(j, k));
                        break outer;
                    }
                }
            }
        }
    }
}