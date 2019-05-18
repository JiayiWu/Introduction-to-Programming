package Task1_1;

import java.util.*;

class Solution8 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){

        List<List<String>> res=new ArrayList<List<String>>();

        int endIndex=wordList.indexOf(endWord);
        if(endIndex==-1){
            return res;
        }

        int beginIndex=wordList.indexOf(beginWord);
        //若beginWord不在wordList中，则添加至wordList末尾
        if(beginIndex==-1){
            wordList.add(beginWord);
            beginIndex=wordList.size()-1;
        }

        //queue用来BFS遍历图。队列按结点的深度依次存放待处理的结点。首先存放第一层结点，弹出，根据第一层结点找到所有第二层结点放入队列；弹出第二层某个结点，根据此结点找到所有第三层结点放入队列，以此类推。
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(beginIndex);

        //fatherNodes、height用来记录图
        //记录图中每个结点的父节点们
        Map<Integer,List<Integer>> fatherNodes=new HashMap<Integer,List<Integer>>();
        for(int i=0;i<wordList.size();i++){
            fatherNodes.put(i,new ArrayList<Integer>());
        }

        //记录图中结点的层数（深度）
        int[] height=new int[wordList.size()];
        height[beginIndex]=1;

        while(!queue.isEmpty()){
            int nowIndex=queue.poll();

            //若最短深度的路径已经记录完毕，退出循环
            //height[nowIndex]>=height[endIndex]针对多个父节点的情况
            if(height[endIndex]!=0 && height[nowIndex]>=height[endIndex]){
                break;
            }

            for(int i=0;i<wordList.size();i++){
                //height[i]==0未访问过的结点，height[i]=height[nowIndex]+1多个父节点的情况，且一个父节点已经访问过该结点
                if((height[i]==0 || height[i]==height[nowIndex]+1) && isDiffOneWord(wordList.get(nowIndex),wordList.get(i))){
                    if(height[i]==0){
                        queue.offer(i);
                        height[i]=height[nowIndex]+1;
                        fatherNodes.get(i).add(nowIndex);
                    }else{
                        //height[i]=height[nowIndex]+1多个父节点的情况，且一个父节点已经访问过该结点
                        fatherNodes.get(i).add(nowIndex);
                    }
                }
            }
        }

        if(height[endIndex]==0){
            return res;
        }else{
            List<String> list=new ArrayList<String>();
            list.add(wordList.get(endIndex));
            dfs(endIndex,list,res,wordList,fatherNodes,beginIndex);
        }

        return res;

    }

    public void dfs(int lastIndex, List<String> list, List<List<String>> res, List<String> wordList, Map<Integer,List<Integer>> fatherNodes, int beginIndex){
        if(lastIndex==beginIndex){
            List<String> newList=new ArrayList<String>(list);
            Collections.reverse(newList);
            res.add(newList);
            return ;
        }
        for(int i=0;i<fatherNodes.get(lastIndex).size();i++){
            int fatherIndex=fatherNodes.get(lastIndex).get(i);
            list.add(wordList.get(fatherIndex));
            dfs(fatherIndex,list,res,wordList,fatherNodes,beginIndex);
            list.remove(list.size()-1);
        }
    }


    public boolean isDiffOneWord(String a,String b){
        int diffnum=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diffnum++;
            }
            if(diffnum==2){
                return false;
            }
        }
        if(diffnum==1){
            return true;
        }
        return false;
    }
}

