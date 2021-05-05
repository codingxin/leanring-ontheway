package com.codingzx.leetcode.每日一题;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codingzx
 * @description 输入：wall =
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：wall = [[1],[1],[1]]
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/2 11:39
 */
public class _554砖墙 {
    public static int leastBricks(List<List<Integer>> wall) {
        // 找到每一层的缝隙
        // 每一层缝隙最多的数字，高度减去数字等于穿过的砖数目
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0; // 穿过砖的数目
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            List<Integer> curwall = wall.get(i);
//            for (Integer j : curwall) {
//                sum += j;
//                map.put(sum, map.getOrDefault(sum, 0) + 1);
//                count = Math.max(count, map.get(sum));
//            }
            // 需要把最后一个删除
            for (int j = 0; j < curwall.size() - 1; j++) {
                sum += curwall.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                count = Math.max(count, map.get(sum));
            }

        }
        return wall.size()-count;
    }


    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        wall.add(list1);
        wall.add(list2);
        wall.add(list3);
        System.out.println(leastBricks(wall));

    }


}
