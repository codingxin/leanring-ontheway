package com.codingzx.leetcode.每日一题._690员工的重要性;


import com.codingzx.leetcode.company.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.CollectionUtils;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author codingzx
 * @description 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 * <p>
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 * <p>
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 *  
 * <p>
 * 提示：
 * <p>
 * 一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
 * 员工数量不超过 2000 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/1 11:42
 */
public class 广度优先 {

    @ToString
    @AllArgsConstructor
    static class Employee {
        public Integer id;
        public Integer importance;
        public List<Integer> subordinates;
    }

    static Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    public static int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }


    // 深度优先 获取当前id下面的子树和
    public static int dfs(int id) {
        Employee curEmploy = map.get(id);
        int result = curEmploy.importance;
        for (Integer i : curEmploy.subordinates) {
            result += dfs(i);
        }
        return result;
    }

    public static void main(String[] args) {
/**
 * [[1,2,[2]], [2,3,[]]]
 * 2
 */
        List<Employee> employees = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(2);
        Employee e1 = new Employee(1, 2, list1);
        List<Integer> list2 = Arrays.asList();
        Employee e2 = new Employee(2, 3, list2);
        employees.add(e1);
        employees.add(e2);

        System.out.println(getImportance(employees, 2));

    }

}
