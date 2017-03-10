import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Driver
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i ++)
        {
            ArrayList<String> list = new ArrayList<>();
            System.out.print("");
            String item = input.nextLine();
            String[] split = item.split(", ");
            for (String str : split)
            {
                list.add(str);
            }
            ArrayList<Card> cards = new ArrayList<>();
            for (String str : list)
            {
                cards.add(new Card(str));
            }
            Card opponentCard = cards.get(0);
            ArrayList<Card> dealersCard = new ArrayList<>();
            for (int j = 1; j < cards.size(); j ++)
            {
                dealersCard.add(cards.get(j));
            }
            ArrayList<Card> sameSuitAsOpponent = new ArrayList<>();
            for (Card card : dealersCard)
            {
                if (card.getSuit().equals(opponentCard.getSuit()))
                {
                    sameSuitAsOpponent.add(card);
                }
            }
            if (sameSuitAsOpponent.size() != 0)
            {
                ArrayList<Card> greaterThanOpponent = new ArrayList<>();
                for (Card card : sameSuitAsOpponent)
                {
                    if (card.compareTo(opponentCard) == 1)
                    {
                        greaterThanOpponent.add(card);
                    }
                }
                if (greaterThanOpponent.size() > 0)
                {
                    Collections.sort(greaterThanOpponent);
                    System.out.println(greaterThanOpponent.get(0).getOriginal());
                }
                else
                {
                    Collections.sort(sameSuitAsOpponent);
                    System.out.println(sameSuitAsOpponent.get(0).getOriginal());
                }
            }
            else
            {
                Collections.sort(dealersCard);
                System.out.println(dealersCard.get(0).getOriginal());
            }
        }
    }
}