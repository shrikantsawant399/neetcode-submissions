class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMapping = new HashMap<>();
        Map<Integer, Integer> courseRemaining = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            courseMapping.put(i, new ArrayList<>());
            courseRemaining.put(i, 0);
        }

        for(int i = 0; i < prerequisites.length; i++){
            int course1 = prerequisites[i][0];
            int course2 = prerequisites[i][1];

            courseMapping.get(course2).add(course1);
            courseRemaining.put(course1, courseRemaining.get(course1)+1);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int key : courseRemaining.keySet()){
            if(courseRemaining.get(key) == 0) {
                queue.add(key);
                results.add(key);
            }
        }

        while(!queue.isEmpty()) {
            int dependencyCourse = queue.poll();
            for(int course : courseMapping.get(dependencyCourse)){
                int count = courseRemaining.get(course)-1;
                courseRemaining.put(course, count);
                if(count == 0) {
                    queue.add(course);
                    results.add(course);
                }
            }
        }

        int[] orderedCourses = results.stream().mapToInt(Integer::intValue).toArray();

        return orderedCourses.length == numCourses ? orderedCourses : new int[]{};
    }
}
