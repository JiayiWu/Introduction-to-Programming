import java.util.*;
/**
 * Solution8
 */
public class Solution8 {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
    if(!wordList.contains(endWord))
      return null;

    HashSet<String> restWord = new HashSet<String>(wordList);
    restWord.remove(beginWord);

    HashMap<String, Integer> record = new HashMap<String, Integer>();

    Queue<String> current = new LinkedList<String>();
    current.offer(beginWord);
    current.offer(",");
    int level = 1;

    while(!current.isEmpty()){
      String s = current.poll();
      StringBuilder string = new StringBuilder(s);
      if(!s.equals(",")){
        for(int i=0 ; i<s.length() ; i++){
          char saved = string.charAt(i);
          for(char c='a' ; c<'z' ; c++){
            if(saved == c)
              continue;
            string.setCharAt(i, c);
            if(restWord.contains(s = string.toString())){
              current.offer(s);
              record.put(s, level);
              restWord.remove(s);
              if(s.equals(endWord))
                return getPath(record, beginWord);
            }
          }
          string.setCharAt(i, saved);
        }
      }else if(!current.isEmpty()){
        current.add(",");
        level++;
      }
    }    
    return null;
  }
  public List<List<String>> getPath(HashMap<String, Integer> record, String beginWord){
    List<List<String>> result = new LinkedList<List<String>>();
    result.add(new LinkedList<String>(Arrays.asList(beginWord)));
    int deep = new HashSet<Integer>(record.values()).size()+1;
    // System.out.println(record);
    for(int level=1 ; level<deep ; level++){
      List<String> temp = new LinkedList<String>();
      for(String s : record.keySet())
        if(record.get(s) == level)
          temp.add(s);
      // System.out.println("temp: "+temp);
      // System.out.println("result: "+result);
      int count = 0;
      for(List<String> list : new LinkedList<List<String>>(result)){
        count++;
        if(list.size()==level){
          for(String s : new LinkedList<String>(temp)){
            if(isNext(((LinkedList<String>)list).getLast(), s)){
              LinkedList<String> tmp = new LinkedList<String>(list);
              tmp.add(s);
              result.add(tmp);
            }
          }
        }
      }
      for(int i=0 ; i<count ; i++)
        result.remove(0);
    }
    return result;
  }
  public boolean isNext(String front, String rear){
    StringBuilder string = new StringBuilder(front);
    for(int i=0 ; i<front.length() ; i++){
      char saved = front.charAt(i);
      for(char c='a' ; c<'z' ; c++){
        if(c==saved)
          continue;
        string.setCharAt(i, c);
        if(rear.equals(string.toString()))
          return true;
      }
      string.setCharAt(i, saved);
    }
    return false;
  }
  public static void main(String[] args) {
    // test 1
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
    List<List<String>> result = new Solution8().findLadders(beginWord, endWord, wordList);
    if(result == null){
      System.out.println("[]");
    }else{
      System.out.println("[");
      for(List<String> way : result)
        System.out.println(" " + way);
      System.out.println("]");
    }
    // test 2
    wordList = new ArrayList<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
    result = new Solution8().findLadders(beginWord, endWord, wordList);
    if(result == null){
      System.out.println("[]");
    }else{
      System.out.println("[");
      for(List<String> way : result)
        System.out.println(" " + way);
      System.out.println("]");
    }
  }
}