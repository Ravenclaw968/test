import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
public class Board
{
    public static int[][] surroundings = {
            {-2, 0},
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -2},
            {0, -1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, -1},
            {1, 0},
            {1, 1},
            {2, 0}
    };
    private Cell[][] cell = new Cell[8][8];
    public Board(String str)
    {
        str = str.replaceAll("\\s+", "");
        ArrayList<String> binary_values = new ArrayList<>();
        for (int i = 0; i < str.length(); i ++)
        {
            BigInteger hex = new BigInteger(str.substring(i, i + 1), 16);
            String bin = hex.toString(2);
            if (bin.length() != 4)
            {
                while (bin.length() != 4)
                {
                    bin = "0" + bin;
                }
            }
            binary_values.add(bin);
        }
        ArrayList<String> refined_binary_values = new ArrayList<>();
        for (int i = 0; i < binary_values.size(); i += 2)
        {
            refined_binary_values.add(binary_values.get(i) + binary_values.get(i + 1));
        }
        Collections.reverse(refined_binary_values);
        for (int i = 0; i < refined_binary_values.size(); i ++)
        {
            for (int j = 0; j < refined_binary_values.get(i).length(); j ++)
            {
                boolean isGrey = refined_binary_values.get(i).substring(j, j + 1).equals("1");
                int row = 8 - i;
                int column = j + 1;
                cell[i][j] = new Cell(row, column, isGrey);
            }
        }
    }
    public Board(Cell[][] cell)
    {
        this.cell = cell;
    }
    public boolean equals(Object other)
    {
        if (! (other instanceof Board))
        {
            return false;
        }
        Board otherBoard = (Board) other;
        for (int i = 0; i < otherBoard.cell.length; i ++)
        {
            for (int j = 0; j < otherBoard.cell[0].length; j ++)
            {
                if (! cell[i][j].equals(otherBoard.cell[i][j]))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public Board press(int row, int column)
    {
        Cell[][] cell = new Cell[8][8];
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < surroundings.length; i ++)
        {
            set.add((row + surroundings[i][0]) + " " + (column + surroundings[i][1]));
        }
        for (int i = 0; i < this.cell.length; i ++)
        {
            for (int j = 0; j < this.cell[0].length; j ++)
            {
                if (set.contains(i + " " + j))
                {
                    cell[i][j] = new Cell(this.cell[i][j].getRow(), this.cell[i][j].getColumn(), ! this.cell[i][j].isGrey());
                }
                else
                {
                    cell[i][j] = this.cell[i][j];
                }
            }
        }
        return new Board(cell);
    }
    public String get(int row, int column)
    {
        return cell[row][column].getRow() + "" + cell[row][column].getColumn();
    }
    public String toString()
    {
        return Arrays.deepToString(cell);
    }
}