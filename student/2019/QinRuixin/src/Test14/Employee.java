package Test14;

public interface Employee {
    public static final String edu="南京大学";
    public abstract void work();
    static void printOrg(){
        System.out.println(edu);
    }

    default void attendMeeting(){
        System.out.println("开会");
    }
}
