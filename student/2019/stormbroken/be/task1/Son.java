package 党员系统;

public class Son extends Father{
		public Son() {
			System.out.println("Constructed from Son");
		}
		public void run() {
			System.out.println("From son.");
		}
		public static void main (String[] args) {
			Son son = new Son();
			son.run();
		}
}
