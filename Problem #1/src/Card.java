import java.util.HashMap;

public class Card implements Comparable
{
    private int number;
    private String suit;
    private String original;
    public Card(String str)
    {
        original = str;
        try
        {
            int numero = Integer.parseInt(str.substring(0, 1));
            number = numero;
        }
        catch (Exception e)
        {
            if (str.substring(0, 1).equals("T"))
            {
                number = 10;
            }
            else if (str.substring(0, 1).equals("K"))
            {
                number = 11;
            }
            else if (str.substring(0, 1).equals("Q"))
            {
                number = 12;
            }
            else if (str.substring(0, 1).equals("J"))
            {
                number = 13;
            }
            else if (str.substring(0, 1).equals("A"))
            {
                number = 1;
            }
        }
        suit = str.substring(1, 2);
    }
    public int getNumber()
    {
        return number;
    }
    public String getSuit()
    {
        return suit;
    }
    public int compareTo(Object other)
    {
        Card otherCard = (Card) other;
        if (number > otherCard.getNumber())
        {
            return 1;
        }
        else if (number < otherCard.getNumber())
        {
            return -1;
        }
        else
        {
            HashMap<String, Integer> precedence = new HashMap<>();
            precedence.put("C", 1);
            precedence.put("D", 2);
            precedence.put("H", 3);
            precedence.put("S", 4);
            if (precedence.get(suit) > precedence.get(otherCard.getSuit()))
            {
                return 1;
            }
            else if (precedence.get(suit) < precedence.get(otherCard.getSuit()))
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
    public String getOriginal()
    {
        return original;
    }
    public String toString()
    {
        return number + " " + suit;
    }
}
