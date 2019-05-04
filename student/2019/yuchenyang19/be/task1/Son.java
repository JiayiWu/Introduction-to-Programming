public class Son extends Father{
	public void run(){
		System.out.println("This is in method of Son.");
	}
	public Son(){
		System.out.println("Construct Son");
	}
	public static void main (String[] args){
		Son son = new Son();
		son.run();
	}
}