package com.ap.leetcode.graphs;

import java.util.*;

/**
 * LC: https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        // to avoid getOrDefault code
        for(int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            adjList.put(i, new ArrayList<Integer>());
        }

        for(int[] prereq: prerequisites) {
            int preReqCourse = prereq[0];
            int course = prereq[1];
            inDegree.put(course, inDegree.get(course) + 1);
            adjList.get(preReqCourse).add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet() ) {
            // could be a starting point
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        List<Integer> courseOrder = new ArrayList<>();
        while(!queue.isEmpty()) {
            int course = queue.poll();
            courseOrder.add(course);
            List<Integer> childs = adjList.get(course);
            for(int child: childs) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }
        return courseOrder.size() == numCourses;
    }
}
