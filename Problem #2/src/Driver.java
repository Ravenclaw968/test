import java.util.ArrayList;
import java.util.Scanner;
public class Driver
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i ++)
        {
            System.out.print("");
            String str = input.nextLine();
            ArrayList<Integer> list = new ArrayList<>();
            boolean left = true;
            while (str.length() > 0)
            {
                if (left)
                {
                    if (list.size() == 0)
                    {
                        list.add(Integer.parseInt(str.substring(0, 1)));
                        str = str.substring(1, str.length());
                    }
                    else
                    {
                        String temporary = "";
                        for (int j = 0; j < str.length(); j ++)
                        {
                            if (! temporary.equals("") && Integer.parseInt(temporary) > list.get(list.size() - 1))
                            {
                                break;
                            }
                            temporary += str.substring(j, j + 1);
                        }
                        if (Integer.parseInt(temporary) < list.get(list.size() - 1))
                        {
                            break;
                        }
                        list.add(Integer.parseInt(temporary));
                        str = str.substring(temporary.length(), str.length());
                    }
                    left = false;
                }
                else
                {
                    String temporary = "";
                    for (int j = str.length() - 1; j >= 0; j --)
                    {
                        if (! temporary.equals("") &&Integer.parseInt(temporary) > list.get(list.size() - 1))
                        {
                            break;
                        }
                        temporary += str.substring(j, j + 1);
                    }
                    if (Integer.parseInt(temporary) < list.get(list.size() - 1))
                    {
                        break;
                    }
                    list.add(Integer.parseInt(temporary));
                    str = str.substring(0, str.length() - temporary.length());
                    left = true;
                }
            }
            String item = "";
            for (int j = 0; j < list.size(); j ++)
            {
                if (j != list.size() - 1)
                {
                    item += list.get(j) + " ";
                }
                else
                {
                    item += list.get(j);
                }
            }
            System.out.println(item);
        }
    }
}