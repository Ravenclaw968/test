public class Cell
{
    private int row;
    private int column;
    private boolean isGrey = false;
    public Cell(int row, int column, boolean isGrey)
    {
        this.row = row;
        this.column = column;
        this.isGrey = isGrey;
    }
    public String toString()
    {
        return "[" + row + ", " + column + "] " + isGrey;
    }
    public int getRow()
    {
        return row;
    }
    public int getColumn()
    {
        return column;
    }
    public boolean isGrey()
    {
        return isGrey;
    }
    public boolean equals(Object other)
    {
        if (! (other instanceof Cell))
        {
            return false;
        }
        Cell other_cell = (Cell) other;
        return row == other_cell.getRow() && column == other_cell.getColumn() && isGrey == other_cell.isGrey();
    }
}