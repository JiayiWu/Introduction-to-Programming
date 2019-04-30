public class Sum
{
    public static void main(String[] args)
    {
        System.out.println(for_loop(1,100,1));
        System.out.println(while_loop(1,100,1));
        System.out.println(do_while_loop(1,100,1));

        System.out.println(for_loop(1,100,2));
        System.out.println(while_loop(1,100,2));
        System.out.println(do_while_loop(1,100,2));

        int[] a=new int[100];
        for(int i=0;i<100;i++)
            a[i]=i;
        for(int i=0;i<a.length;i++)
            System.out.println("a[i]="+a[i]);
    }

    public static int for_loop(int begin,int end,int step)
    {
        int res=0;
        for(int i=begin;i<=end;i=i+step)
        {
            res=res+i;
        }
        return res;
    }

    public static int while_loop(int begin,int end,int step)
    {
        int i=begin;
        int res=0;
        while(i<=end)
        {
            res=res+i;
            i=i+step;
        }
        return res;
    }

    public static int do_while_loop(int begin,int end,int step)
    {
        int res=0;
        int i=begin;
        do{
            if(i<=end)
                res=res+i;
            i=i+step;
        }while(i<=end);
        return res;
    }
}

