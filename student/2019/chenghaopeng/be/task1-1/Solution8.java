import java.util.*;

class Solution8 {

    private static Boolean isConnected(String a, String b) {
        if(a.length() != b.length()) return false;
        if(a.equals(b) == true) return false;
        Boolean flag = false;
        for(int i=0; i<a.length(); ++i) {
            if(a.charAt(i) != b.charAt(i)) {
                if(flag == true) return false;
                flag = true;
            }
        }
        return true;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList.contains(endWord) == false) {
            return new ArrayList<List<String>>();
        }
        if(wordList.contains(beginWord) == false) {
            wordList.add(beginWord);
        }
        int S = wordList.indexOf(beginWord), T = wordList.indexOf(endWord);

        MyGraph graph = new MyGraph(wordList.size());
        for(int i=0; i<wordList.size(); ++i) {
            for(int j=i+1; j<wordList.size(); ++j) {
                if(isConnected(wordList.get(i), wordList.get(j))){
                    graph.addEdge(i, j);
                    graph.addEdge(j, i);
                }
            }
        }

        Spfa spfa = new Spfa(graph);
        int distance = spfa.getDistance(S, T);
        if(distance == -1) {
            return new ArrayList<List<String>>();
        }
        //System.out.println(distance);

        Dfs dfs = new Dfs(graph, distance, S, T);
        List<List<Integer>> paths = dfs.getPath();
        List<List<String>> ans = new ArrayList<List<String>>();
        for(List<Integer> path : paths) {
            List<String> strPath = new ArrayList<String>();
            for(Integer i : path) {
                strPath.add(wordList.get(i));
            }
            ans.add(strPath);
        }
        
        return ans;
    }

    private class MyGraph {
        private class Edge {
            public int v, nxt;
        }
        public Edge[] edges;
        private int[] head;
        private int tot;
        public int size;
        MyGraph(int n) {
            size = n;
            edges = new Edge[n*n];
            head = new int[n];
            tot = 0;
            for(int i=0; i<n; ++i) {
                head[i] = -1;
            }
            for(int i=0; i<n*n; ++i) {
                edges[i] = new Edge();
            }
        }
        public void addEdge(int u, int v) {
            edges[tot].v = v;
            edges[tot].nxt = head[u];
            head[u]=tot++;
        }
    }

    private class Spfa {
        private MyGraph graph;
        private int size;
        private int[] distance;
        private Boolean[] inQueue;

        Spfa(MyGraph G){
            graph = G;
            size = graph.size;
            distance = new int[size];
            inQueue = new Boolean[size];
            for(int i=0; i<size; ++i) {
                distance[i] = -1;
                inQueue[i] = new Boolean(false);
            }
        }

        public int getDistance(int S, int T) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(S);
            inQueue[S] = true;
            distance[S] = 0;
            while(queue.isEmpty() == false) {
                int u = queue.poll();
                inQueue[u] = false;
                for(int i=graph.head[u]; i!=-1; i=graph.edges[i].nxt) {
                    int v = graph.edges[i].v;
                    if((distance[v] == -1) || (distance[v] > distance[u] + 1)) {
                        distance[v] = distance[u] + 1;
                        if(inQueue[v] == false) {
                            queue.offer(v);
                            inQueue[v] = true;
                        }
                    }
                }
            }
            return distance[T];
        }
    }

    private class Dfs {
        private MyGraph graph;
        private int MaxDep;
        private int source;
        private int target;
        List<List<Integer>> paths;
        List<Integer> path;
        Dfs(MyGraph G, int maxDep, int S, int T){
            graph = G;
            MaxDep = maxDep;
            source = S;
            target = T;
            paths = new ArrayList<List<Integer>>();
            path = new ArrayList<Integer>();
        }
        private void dfs(int dep, int u) {
            if(dep == MaxDep) {
                if(u == target) {
                    paths.add(new ArrayList<Integer>(path));
                    return;
                }
                return;
            }
            for(int i=graph.head[u]; i!=-1; i=graph.edges[i].nxt) {
                int v = graph.edges[i].v;
                path.add(v);
                dfs(dep + 1, v);
                path.remove(path.size() - 1);
            }
        }
        public List<List<Integer>> getPath() {
            path.add(source);
            dfs(0, source);
            path.remove(path.size() - 1);
            return paths;
        }
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        List<List<String>> ans = solution8.findLadders("hit", "cog", new ArrayList<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
        for(List<String> path : ans) {
            for(String v : path) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

}