class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> schedule = new HashMap<>();
        Map<Integer, Integer> isCourseCompleted = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            schedule.put(i, new ArrayList<>());
            isCourseCompleted.put(i, 0);
        }
        
        for(int index = 0; index < prerequisites.length; index++){
            int course1 = prerequisites[index][0];
            int course2 = prerequisites[index][1];
            
            schedule.get(course2).add(course1);

            int count = isCourseCompleted.get(course1);
            isCourseCompleted.put(course1, count+1);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int key : isCourseCompleted.keySet()){
            if(isCourseCompleted.get(key) == 0) queue.add(key);
        }

        if(queue.isEmpty()) return false;

        while(!queue.isEmpty()) {
            int key = queue.poll();
            for(int i : schedule.get(key)){
                int count = isCourseCompleted.get(i);
                isCourseCompleted.put(i, count-1);
                if(isCourseCompleted.get(i) == 0) queue.add(i);
            }
            numCourses--;
            if(numCourses <= 0) return true;
        }

        return false;
    }
}
