import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntPredicate;

/**
 * @program: untitled
 * @author: hhong
 * @create: 2025-04-12 21:08
 **/
public class LambdaDemo {
    /**
     * Lambda 例1
     * @param  o1, o2
     * @return o1.compareToIgnoreCase(o2)
     */
    public static void main(String[] args) {
//        String[] strs = {"apple", "Banana", "cherry"};
//        Arrays.sort(strs, (o1, o2) -> {
//            return o1.compareToIgnoreCase(o2); // 不区分大小写排序
//        });
//
//        // 添加输出，验证排序结果
//        System.out.println("排序后的数组:");
//        for (String str : strs) {
//            System.out.println(str);
//        }

        /**
         * @describe lambda 案例2
          */
//        printNum(value -> {
//            return value % 2 == 0; // 添加返回值，判断是否为偶数
//        }); // 添加分号
//
//    }
//    public static void printNum(IntPredicate predicate){
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for (int i : arr){
//            if (predicate.test(i)){
//                System.out.println(i);
//            }
//        }
        Integer result = typeConver((String s) -> {
            return Integer.valueOf(s);
        });
        System.out.println(result);
        if (result instanceof Integer) {
            System.out.println("返回的数据类型是 Integer");
        } else {
            System.out.println("返回的数据类型不是 Integer");
        }
    }
    public static<R> R typeConver(Function<String,R>function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
}