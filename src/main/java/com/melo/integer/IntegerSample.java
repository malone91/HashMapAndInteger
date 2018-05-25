package com.melo.integer;

import java.util.ArrayList;
import java.util.List;

/**
 * 大家都知道”==“是比较两个变量的值是否相等,
 * 对于引用型变量表示的是两个变量在堆中存储的地址是否相同。
 * Created by Ablert
 * on 2018/5/25.
 * @author Ablert
 */
public class IntegerSample {

    public static void main(String[] args) {
        //会将int类型通过valueof转换成Integer类型
//        public static Integer valueOf(int i) {
//            if (i >= IntegerCache.low && i <= IntegerCache.high)
//                return IntegerCache.cache[i + (-IntegerCache.low)];
//            return new Integer(i);
//        }
//        -128到127之间的值会缓存到IntegerCache.cache中，所以在Integer x=在-128到127之间时，返回的是同一个对象
        Integer a = 232;
        Integer b = 232;
        System.out.println(b.equals(a));
        System.out.println(b == a);//两个对象在比较
//        与初始化值做比较的时候，会将封装类型进行拆箱操作，转换为基本类型。
        System.out.println(b == 232);//true

        Integer c = 22;
        Integer d = 22;
        System.out.println(b.equals(a));
        System.out.println(c == d);
    }
}
