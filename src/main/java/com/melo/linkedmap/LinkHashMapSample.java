package com.melo.linkedmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 保证元素的顺序
 * 针对有序 Map 的分析内容比较有限，我再补充一些，虽然 LinkedHashMap 和 TreeMap 都可以保证某种顺序，但二者还是非常不同的。
 * LinkedHashMap 通常提供的是遍历顺序符合插入顺序，它的实现是通过为条目（键值对）维护一个双向链表。
 * 注意，通过特定构造函数，我们可以创建反映访问顺序的实例，所谓的 put、get、compute 等，都算作“访问”。
 * 这种行为适用于一些特定应用场景，例如，
 * 我们构建一个空间占用敏感的资源池，希望可以自动将最不常被访问的对象释放掉，
 * 这就可以利用 LinkedHashMap 提供的机制来实现
 * Created by Ablert
 * on 2018/5/24.
 * @author Ablert
 */
public class LinkHashMapSample {

    public static void main(String[] args) {
        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                // 实现自定义删除策略，否则行为就和普遍 Map 没有区别
                return size() > 3;
            }
        };
        accessOrderedMap.put("Project1", "Oneal");
        accessOrderedMap.put("Project2", "Jordan");
        accessOrderedMap.put("Project3", "Malone");
        accessOrderedMap.forEach( (k, v) -> {
            System.out.println(k + ":" + v);
        });
        //模拟访问
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project3");
        System.out.println("Iterate over should be not affected:");
        accessOrderedMap.forEach( (k, v) -> {
            System.out.println(k + ":" + v);
        });
        //触发删除
        accessOrderedMap.put("Project4", "Cole");
        System.out.println("Oldest entry should be removed:");
        //遍历顺序不变
        accessOrderedMap.forEach( (k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
