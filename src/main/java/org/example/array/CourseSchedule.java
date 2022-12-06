package org.example.array;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 *     For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *  
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * * * */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0 || prerequisites == null || prerequisites.length==0)
            return false;
        int[] preCourse = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            preCourse[i] = i;
        }

        for (int[] course : prerequisites) {
            int want = course[0];
            int pre = course[1];
            preCourse[want] = pre;

            while (pre != preCourse[pre]) {
                pre = preCourse[pre];
                if (pre == want)
                    return false;
            }
        }
        return true;
    }
}
