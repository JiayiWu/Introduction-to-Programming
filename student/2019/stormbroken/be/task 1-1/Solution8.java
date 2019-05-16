package Solution;
import java.util.*;
class Solution8 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       List<List<String>> result = new LinkedList<List<String>>();
       //����ָ������������еݹ�
       List<Integer> situation1 = new LinkedList<Integer>();
       List<List<Integer>> situation = new LinkedList<List<Integer>>();
       Solution8 s = new Solution8();
       int begin,end = -1;
       int min ;
       //�ж����һ�������Ƿ�����������У�������ڣ����ؿ�����
       if (wordList.indexOf(endWord)==-1) {
    	   return result;
       }
       //���ֵ���ӽ����ʼ����
       List<String> wordList1 = new ArrayList<String>(wordList);
       wordList1.add(beginWord);   
       int time = 0;
       for (int i = 0;i<wordList1.size();i++) {
    	   situation1 = new LinkedList<Integer>();//�������ô���ᵼ���ظ�����Ϊlist�洢���ǵ�ַ���޸�Ҳ��ȫ���޸�
    	   if(wordList1.get(i)==endWord) {
    		   	end = i;
    			situation1.add(-1);
    	   }else {
    			   for(int j = 0;j<wordList1.size();j++) {
    				   time = 0;
    				   if(j != i) {
    					   //�ж��������ʵ��ظ��̶�
	    			   for(int m = 0;m<wordList1.get(i).length();m++) {
	    				   if(wordList1.get(i).charAt(m) != wordList1.get(j).charAt(m)) {
	    					   time++;
		    				   }
		    			   }
		    			//�����ظ��̶�����ɾ����Ƿ����
		    			if (time == 1) {
		    				situation1.add(j);
		    			}
    				   }
    				   }
    			   }	     
    	   situation.add(situation1);
       }
       /*for (int n = 0;n<situation.size();n++) {
    	   System.out.print(wordList1.get(n)+" ");
    	   for(int d = 0;d<situation.get(n).size();d++) {
    		   System.out.print(situation.get(n).get(d)+" ");
    	   }
    	   System.out.println("");
       }*/
       begin = wordList1.size()-1;
       List<Integer> path = new ArrayList<Integer>();
       List<List<Integer>> result1 = s.findPath(situation, begin, end, path);
       /*for (int n = 0;n<result1.size();n++) {
    	   for(int d = 0;d<result1.get(n).size();d++) {
    		   System.out.print(result1.get(n).get(d)+" ");
    	   }
    	   System.out.println("");
       }*/
       min = result1.get(0).size();
       for(int i = 0;i<result1.size();i++) {
    	   if (min >= result1.get(i).size()) {
    		   if (min > result1.get(i).size()) {
    			   min = result1.get(i).size();
    			   result.clear();
    		   }
    		   List<String> result2 = new ArrayList<String>();
    		   for(int m = 0;m<result1.get(i).size();m++) {
    			   result2.add(String.valueOf(wordList1.get(result1.get(i).get(m))));
    		   }
    		   result.add(result2);
    	   }
       }
       return result;
    }
    //������������������е�·��
    public List<List<Integer>> findPath(List<List<Integer>> situation,int begin,int end,List<Integer> path){
    	//System.out.println(begin + " " +end);
    	//һ��Ҫ��path��ɳ�Ա��������Ȼ�ݹ鷵�ز������
    	path = new ArrayList<Integer>(path);
    	Solution8 s = new Solution8();
    	path.add(begin);
    	if (begin == end) {
    		List<List<Integer>> path1 =  new LinkedList<List<Integer>>();
    		path1.add(path);
    		return path1;
    	}
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	for(int i = 0; i<situation.get(begin).size();i++) {
    		if ( !path.contains(situation.get(begin).get(i))){
    			List<List<Integer>> newresult = new LinkedList<List<Integer>>();
    			newresult = s.findPath(situation, situation.get(begin).get(i), end, path);
    			if(newresult.size()!=0) {
    				for(int j = 0;j<newresult.size();j++) {
    					result.add(newresult.get(j));
    				}
    			}else {
    				path.remove(situation.get(begin).get(i));
    			}
    		}
    	}
    	return result;
    }
    public static void main (String[] args) {
    	Solution8 s = new Solution8();
    	String beginWord ="hit";
    	String endWord = "cog";
    	List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
    	List<List<String>> result = s.findLadders(beginWord, endWord, wordList);
    	for (int n = 0;n<result.size();n++) {
	 	   for(int d = 0;d<result.get(n).size();d++) {
		 		   System.out.print(result.get(n).get(d)+" ");
		 	   }
		 	   System.out.println("");
    	}
      }
}