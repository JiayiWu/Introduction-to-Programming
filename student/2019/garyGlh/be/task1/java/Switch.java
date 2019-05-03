import java.util.Scanner;

public class Switch {
    public static int Switch_judge(String n)
    {
        switch (n)
        {
            case "10":
                System.out.println(n+" is 10.");
                return 10;
            case "20":
                System.out.println(n+" is 20.");
                return 20;
            case "30":
                System.out.println(n+" is 30.");
                return 30;
            case "40":
                System.out.println(n+" is 40.");
                return 40;
            case "50":
                System.out.println(n+" is 50.");
                return 50;
            default:
                System.out.println("not in the test nums");
                return -1;
        }
    }
    public static int if_judge(String s)
    {
        if(s.equals("10"))
        {
            System.out.println(s+" is 10.");
            return 10;
        }
        else if(s.equals("20"))
        {
            System.out.println(s+" is 20.");
            return 20;
        }
        else if(s.equals("30"))
        {
            System.out.println(s+" is 30.");
            return 30;
        }
        else if(s.equals("40"))
        {
            System.out.println(s+" is 40.");
            return 40;
        }
        else if(s.equals("50"))
        {
            System.out.println(s+" is 50.");
            return 50;
        }
        else
        {
            System.out.println("not in the test nums.");
            return -1;
        }


    }
}
