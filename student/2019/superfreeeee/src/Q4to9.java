import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Q4to9{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter Question(0 for all): ");
    int choice = in.nextInt();
    switch(choice){
      case 0:
        Q4();
        Q5();
        Q6();
        Q7();
        Q8();
        Q9();
        break;
      case 4: Q4(); break;
      case 5: Q5(); break;
      case 6: Q6(); break;
      case 7: Q7(); break;
      case 8: Q8(); break;
      case 9: Q9(); break;
      default:
        System.out.println("Question not found.");
        break;
    }
  }
  private static void Q9(){
    System.out.println("\nQ9: bubble sort and selection sort");
    System.out.println("test1:");
    try{
      System.out.println("Enter numbers:");
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String[] input = in.readLine().split(" ");
      int[] nums = new int[input.length];
      for(int i=0 ; i<input.length ; i++)
        nums[i] = Integer.parseInt(input[i]);
      System.out.println("origin array: " + Arrays.toString(nums));
      
      //bubble sort
      int temp;
      int[] bubbled = nums.clone();
      for(int i=0 ; i<nums.length-1 ; i++)
        for(int j=0 ; j<nums.length-1-i ; j++)
          if(bubbled[j] < bubbled[j+1]){
            temp = bubbled[j];
            bubbled[j] = bubbled[j+1];
            bubbled[j+1] = temp;
          }
      System.out.println("bubble sort: " + Arrays.toString(bubbled));

      //selection sort
      int[] selected = nums.clone();
      int current;
      int point = -1;
      while(++point < selected.length){
        current = point;
        for(int i=current+1 ; i<selected.length ; i++){
          if(selected[i] > selected[current]){
            current = i;
          }
        }
        if(current != point){
          temp = selected[point];
          selected[point] = selected[current];
          selected[current] = temp;
        }
      }
      System.out.println("selection sort: " + Arrays.toString(selected));
    }catch(Exception e){

    }
  }
  private static void Q8(){
    System.out.println("\nQ8:");
    System.out.println("test1: BufferedReader test");
    try{
      System.out.print("Enter a sentence: ");
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String input = reader.readLine();
      System.out.println("Your input: " + input);
    }catch(Exception e){
      e.printStackTrace();
    }

    System.out.println("\ntest2: FileInputStream, FileOutputStream");
    try{
      FileInputStream f = new FileInputStream(new File("asset/test.txt"));
      try{
        StringBuilder string = new StringBuilder();
        int c;
        while((c = f.read()) != -1){  // 读到底返回-1
          string.append((char)c);
        }
      }catch(Exception e){
        // 
        e.printStackTrace();
      }finally{
        f.close();
      }
    }catch(Exception e){
      // FileNotFoundException
      e.printStackTrace();
    }
    // System.out.println("lines after catch");
  }
  private static void Q7(){
    System.out.println("\nQ7: switch");
    System.out.println("test1:");
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = in.nextInt();
    if(num == 10){
      System.out.println("The number is 10");
    }else if(num == 20){
      System.out.println("The number is 20");
    }else if(num == 30){
      System.out.println("The number is 30");
    }else if(num == 40){
      System.out.println("The number is 40");
    }else if(num == 50){
      System.out.println("The number is 50");
    }
    switch(num){
      case 10: System.out.println("The number is 10"); break;
      case 20: System.out.println("The number is 20"); break;
      case 30: System.out.println("The number is 30"); break;
      case 40: System.out.println("The number is 40"); break;
      case 50: System.out.println("The number is 50"); break;
    }
  }
  private static void Q6(){
    System.out.println("\nQ6: prime number");
    System.out.println("test1:");
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = in.nextInt();
    if(isPrime(num)){
      System.out.println(num + " is a prime number");
    }else{
      System.out.println(num + " is not a prime number");
    }

  }
  private static boolean isPrime(int num){
    for(int i=2 ; i<=Math.sqrt(num) ; i++)
      if(num%i == 0)
        return false;
    return true;
  }
  private static void Q5(){
    System.out.println("\nQ5:");
    System.out.println("test1:");
    for(int i=1 ; i<10 ; i++){
      if(i%2==0){
        System.out.printf(i + " is even\n");
      }else{
        System.out.printf(i + " is odd\n");
      }
    }

    System.out.println("\ntest2: leap year");
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a year: ");
    int year = in.nextInt();
    isLeap(year);
    // for(int i=1880 ; i<=2000 ; i++)
    //   isLeap(i);
  }
  private static void isLeap(int year){
    boolean isLeap;
    if(year%4 == 0){
      if(year%100 == 0){
        if(year%400 == 0){
          if(year%1000 == 0){
            isLeap = false;
          }else{
            isLeap = true;
          }
        }else{
          isLeap = false;
        }
      }else{
        isLeap = true;
      }
    }else{
      isLeap = false;
    }
    if(isLeap){
      System.out.println(year + " is leap year");
    }else{
      System.out.println(year + " is not leap year");      
    }
  }
  private static void Q4(){
    System.out.println("\nQ4:");
    int first, step, end;
    // test1
    System.out.println("test1");
    first = 1;  step = 1;  end = 100;
    useWhile(first, step, end);
    useDoWhile(first, step, end);
    useFor(first, step, end);
    // test2
    System.out.println("\ntest2");
    first = 1;  step = 2;  end = 101;
    useWhile(first, step, end);
    useDoWhile(first, step, end);
    useFor(first, step, end);
    // test3
    System.out.println("\ntest3");
    int[] intArray = {1,2,3,4,5};
    for(int i : intArray)
      System.out.print(i + " ");
    System.out.println();
  }
  private static void useWhile(int first, int step, int end){
    int result = 0;
    while(first <= end){
      result += first;
      first += step;
    }
    System.out.println("use while: " + result);
  }
  private static void useDoWhile(int first, int step, int end){
    int result = 0;
    do{
      result += first;
      first += step;
    }while(first <= end);
    System.out.println("use do-while: " + result);
  }
  private static void useFor(int first, int step, int end){
    int result = 0;
    for(int i=first ; i<=end ; i+=step){
      result += i;
    }
    System.out.println("use for: " + result);
  }
}