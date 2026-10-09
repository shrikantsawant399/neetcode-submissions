class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        Map<Integer, List<Integer>> graph = buildGraph(edges, n);
        Set<Integer> isVisited = new HashSet<>();
        
        for(int source : graph.keySet()){
            if(traverseGraph(graph, isVisited, source)) count++;
        }
        return count;
    }

    public boolean traverseGraph(Map<Integer, List<Integer>> graph, Set<Integer> isVisited, int source){
        if(isVisited.contains(source)) return false;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);

        while(!stack.isEmpty()){
            int element = stack.pop();
            if(isVisited.contains(element)) continue;
            isVisited.add(element);

            for(int neighbor : graph.get(element)){
                stack.push(neighbor);
            }
        }
        return true;
    }

    public Map<Integer, List<Integer>> buildGraph(int[][] edges, int n){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
