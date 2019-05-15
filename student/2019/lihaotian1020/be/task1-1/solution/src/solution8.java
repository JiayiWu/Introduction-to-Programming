import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//这题不会做，在leetcode上看的解答，算是看明白了。
//希望学长能分享一下答案
//菜鸡要哭了
class solution8 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginlist = new HashSet<String>();
        Set<String> endlist = new HashSet<String>();
        HashSet<String> visited = new HashSet<String>();
        beginlist.add(beginWord);
        endlist.add(endWord);
        List<List<String>> return_List = new ArrayList<>();
        while (!beginlist.isEmpty()&&!endlist.isEmpty()){
            if (beginlist.size()>endlist.size()){
                Set<String> tepm = beginlist;
                beginlist = endlist;
                endlist = tepm;
            }
            Set<String> temp = new HashSet<String>();
            for (String word :beginlist){
                char[] wrd = word.toCharArray();
                for (int i = 0;i<wrd.length;i++){
                    for (char j='a';j<='z';j++){
                        char old = wrd[i];
                        wrd[i] = j;
                        String target = String.valueOf(wrd);
                        if (endlist.contains(target)){
                            visited.add(target);
                            List<String> trmp = new ArrayList<>(visited);
                            return_List.add(trmp);
                            return return_List;
                        }
                        if (!visited.contains(target)&&wordList.contains(target)){
                            temp.add(target);
                            visited.add(target);
                        }
                        wrd[i] = old;
                    }
                }
            }
            beginlist = temp;
        }
        return null;
    }

}
