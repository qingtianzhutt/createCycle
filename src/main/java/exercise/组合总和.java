package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 这种对于没有重复的数字的处理。
 */
public class 组合总和 {
    public static void main(String[] args) {
        int[] a = {2,3,7};
        List<List<Integer>> list = combinationSum(a,10);
        System.out.println(list);
    }

    public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates,res,combine,0,target);
        return res;
    }
    public static void dfs(int[] candidates, List<List<Integer>> res, List<Integer> combine, int place, int target){
        if(target == 0){
            res.add(new ArrayList<>(combine));
            return;
        }
        for(int i = place; i < candidates.length; i++){
            if (target < candidates[i]){
                return;
            }else{
                combine.add(candidates[i]);
                dfs(candidates,res,combine,i ,target - candidates[i]);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
