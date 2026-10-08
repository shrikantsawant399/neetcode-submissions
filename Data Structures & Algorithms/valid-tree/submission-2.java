class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        Set<Integer> isVisited = new HashSet<>();
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        traverseTree(graph, isVisited);

        return isVisited.size() == n;
    }

    public void traverseTree(Map<Integer, List<Integer>> map, Set<Integer> isVisited){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        while(!stack.isEmpty()){
            int element = stack.pop();
            if(isVisited.contains(element)) continue;
            isVisited.add(element);

            if(map.containsKey(element)){
                for(int neighbor : map.get(element)){
                    stack.push(neighbor);
                }
            }
        }
    }

    public Map<Integer,List<Integer>> buildGraph(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            if(!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<>());
            if(!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
