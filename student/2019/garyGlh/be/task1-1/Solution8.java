import java.util.*;

public class Solution8 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = dfs(beginWord, endWord,  wordList);

        if(res.size()!=0) {
            int min_len = res.get(0).size();
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).size() < min_len)
                    min_len = res.get(i).size();
            }
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).size() > min_len) {
                    res.remove(i);
                    i--;
                }
            }
        }
        return res;
    }


    public List<List<String>> dfs(String beginWord, String endWord, List<String> wordList)
    {
        List<List<String>> res = new ArrayList<>();
        if(!wordList.contains(endWord))
            return res;
        for(int i=0;i<wordList.size();i++){
            if(is_valid(beginWord,wordList.get(i))) {
                if(wordList.get(i).equals(endWord))
                {
                    List<List<String>> a = new ArrayList<>();
                    List<String> b = new ArrayList<>();
                    b.add(beginWord);
                    b.add(wordList.get(i));
                    a.add(b);
                    return a;
                }
                else {
                    List<String> temp = new ArrayList<>();
                    temp.addAll(wordList);
                    temp.remove(i);
                    List<List<String>> a = new ArrayList<>();
                    a = findLadders(wordList.get(i), endWord, temp);
                    if (a.size() != 0) {
                        for (int j = 0; j < a.size(); j++) {
                            a.get(j).add(0, beginWord);
                            res.add(a.get(j));
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution8 test = new Solution8();
        List<String> words = new ArrayList<>();
        words.add("hoc");
        words.add("doc");
        words.add("dog");
        test.findLadders("hot","dog",words);
    }

    //only one letter differs
    public boolean is_valid(String word1,String word2){
        if(word1.length()!=word2.length())
            return false;
        int count=0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i))
                count++;
        }
        return count==1;
    }


}

