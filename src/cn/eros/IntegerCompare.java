package cn.eros;

/**
 * Integer类型数据比较
 * <p>Create time: 2020-05-28 11:49</p>
 *
 * @author Eros
 **/
public class IntegerCompare {
    public static void main(String[] args) {
        /*
         * Integer会缓存-128~127的数字，值在此范围内时，其引用地址相同
         */
        Integer val1 = 100;
        Integer val2 = 100;
        Integer val3 = 128;
        Integer val4 = 128;

        // 打印对象存储地址
        System.out.println(System.identityHashCode(val1));
        System.out.println(System.identityHashCode(val2));
        System.out.println(System.identityHashCode(val3));
        System.out.println(System.identityHashCode(val4));

        // true
        System.out.println(val1 == val2);
        // true
        System.out.println(val1.equals(val2));
        // false
        System.out.println(val3 == val4);
        // true
        System.out.println(val3.equals(val4));
    }
}
