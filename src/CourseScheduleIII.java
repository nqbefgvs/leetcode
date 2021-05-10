import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Comparator<int[]> cmp = (a, b) -> a[1] - b[1];
        Arrays.sort(courses, cmp);
        PriorityQueue<int[]> coursesTaken = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        int time = 0;
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                coursesTaken.offer(course);
            } else {
                if (!coursesTaken.isEmpty() && coursesTaken.peek()[0] > course[0]) {
                    int longCourseTime = coursesTaken.poll()[0];
                    time -= longCourseTime;
                    time += course[0];
                    coursesTaken.offer(course);
                }
            }
        }
        return coursesTaken.size();
    }
}
