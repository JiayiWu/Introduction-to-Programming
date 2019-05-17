import java.util.*;

class Solution8 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Deque<String> queue = new ArrayDeque<>();
        boolean[] isHandled = new boolean[wordList.size()];
        ArrayList resultList = new ArrayList();
        boolean found = false;
        List result = new ArrayList();
        queue.offer(beginWord);
        resultList.add(0);
        resultList.add(" ");
        resultList.add(beginWord);
        resultList.add(" ");
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) {
                isHandled[i] = true;
            }
        }
        while (!queue.isEmpty() && !found) {
            resultList.add("##");
            resultList.add(" ");
            int tempSum = queue.size();
            for (int i = 0; i < tempSum; i++) {
                resultList.add(i);
                resultList.add(" ");
                String temp = queue.poll();
                if (temp.equals(endWord)) {
                    found = true;
                    resultList.add("eee");
                    result.add(toResult(resultList));
                }
                for (int j = 0; j < wordList.size(); j++) {
                    if (!isHandled[j] && isOneLetterDiff(temp, wordList.get(j))) {
                        queue.offer(wordList.get(j));
                        if (wordList.get(j).equals(endWord)) {

                        } else {
                            isHandled[j] = true;
                        }
                        resultList.add(wordList.get(j));
                        resultList.add(" ");
                    }
                }
            }
        }
        return result;
    }

    private boolean isOneLetterDiff(String s1, String s2) {
        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sum++;
            }
        }
        return sum == 1;
    }

    private List<String> toResult(ArrayList resultList) {
        List<String> result = new ArrayList<>();
        String tempResult = "";
        String handleStr = "";
        for (Object obj : resultList) {
            handleStr = handleStr + obj;
        }
        int judLen = 2;
        int t = handleStr.charAt(handleStr.length() - 2) - '0';
        int times = 1;
        while (judLen >= 2) {
            int len = handleStr.length();
            int k = len - 1;
            while (k > 0) {
                if (handleStr.charAt(k) <= '9' && handleStr.charAt(k) >= '0') {
                    if (times == 1) {
                        times = 0;
                        break;
                    } else {
                        if (handleStr.charAt(k) - '0' == t) {
                            break;
                        }
                    }
                }
                k--;
            }
            k = handleStr.charAt(k) - '0';
            int copyLen = len - handleStr.split("##")[handleStr.split("##").length - 1].length() - 2;
            handleStr = handleStr.substring(0, copyLen);
            judLen = handleStr.split("##").length;
            String singlePart = handleStr.split("##")[judLen - 1];
            int count = -1;
            for (String str : singlePart.split(" ")) {
                if (str.matches("\\d*")) {

                } else {
                    count++;
                }
                if (count == k) {
                    tempResult = str + " " + tempResult;
                    break;
                }
                t = k;
            }
        }
        for (String str : tempResult.split(" ")) {
            result.add(str);
        }
        return result;
    }


    /*public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(new Solution8().findLadders("hit", "log", wordList));
    }*/
}
