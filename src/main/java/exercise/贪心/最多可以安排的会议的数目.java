package exercise.贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 结题策略：优先安排先结束的会议
 */
public class 最多可以安排的会议的数目 {
    public static void main(String[] args) {
        //初始化一个二维数组
        int[][] events = new int[4][2];
        for (int i = 0; i < events.length; i++){
            events[i][0] = 6;
            events[i][1] = i;
        }
        for (int i = 0; i < events.length; i++){
            System.out.println(events[i][0] + "," + events[i][1]);
        }
        Arrays.sort(events, new arrayComparator());
        for (int i = 0; i < events.length; i++){
            System.out.println(events[i][0] + "," + events[i][1]);
        }
    }
    public static int maxEvent1(int[][] events){
        //将数组按照正序排列
        Arrays.sort(events, new arrayComparator());
        int res = 0;
        for (int i = 0; i < events.length; i++){
            res++;
            int endTime = events[i][1];
            while (i + 1 <= events.length){
                if (events[i + 1][0] > endTime){
                    break;
                }
                i++;
            }
        }
        return res;
    }
    public static int maxEvent(int[][] events){
        //将数组按照正序排列
        Arrays.sort(events, new arrayComparator());
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < events.length; i++){
            Boolean isValid = false;
            for (int j = events[i][0]; j <= events[i][1]; j++){
                if (!set.contains(j)){
                    set.add(j);
                    isValid = true;
                    break;
                }
            }
            if (isValid){
                res++;
            }
        }
        return res;
    }
    public static class arrayComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            //这样就是正序排列
            return o1[1] - o2[1];
        }
    }
}
