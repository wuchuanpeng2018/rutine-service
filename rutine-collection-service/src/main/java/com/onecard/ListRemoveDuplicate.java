package com.onecard;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @description: Java中List集合去除重复数据的方法/
 *  Java 中初始化 List 集合的 6 种方式
 * @author: wuchu
 * @date: Created in 2019/6/14 11:57
 */
public class ListRemoveDuplicate {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){{add(4);add(1);add(2);add(2);}};
        print(removeDuplicate(list)+"");
        list = new ArrayList<Integer>(){{add(4);add(1);add(2);add(2);}};
        print(removeDuplicate1(list)+"");
        list = new ArrayList<Integer>(){{add(4);add(1);add(2);add(2);}};
        print("list -------->" + list);
        print(removeDuplicateWithOrder(list)+"");
        list = new ArrayList<Integer>(){{add(4);add(1);add(2);add(2);}};
        print("list -------->" + list);
        print(removeDuplicate2(list)+"");
        list = new ArrayList<Integer>(){{add(4);add(1);add(2);add(2);}};
        print("list -------->" + list);
        print(list.stream().distinct().collect(toList())+"");
        initList1();
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void initList() {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("PHP");
        languages.add("Python");
    }

    /**
     *  老规则，如果要可变，使用 ArrayList 包装一遍
     * @author: wuchu
     * @date: Created in 2019/6/14 14:12
     * @param
     * @return void
     */
    public static void initList1() {
        List<String> jdks = Arrays.asList("JDK6", "JDK8", "JDK10");
        //Exception in thread "main" java.lang.UnsupportedOperationException
        jdks.add("ddd");
        print(jdks+"");
    }

    /**
     *  老规则，如果要可变，使用 ArrayList 包装一遍
     * @author: wuchu
     * @date: Created in 2019/6/14 14:12
     * @param
     * @return void
     */
    public static void initList2() {
        List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3"));
        numbers.add("ddd");
        print(numbers+"");
    }

    /**
     *  这种方式添加的是不可变的、复制某个元素N遍的工具类
     * @author: wuchu
     * @date: Created in 2019/6/14 14:09
     * @param
     * @return void
     */
    public void initList3() {
        List<String> apples = Collections.nCopies(3, "apple");
    }

    /**
     *  JDK8 stream
     * @author: wuchu
     * @date: Created in 2019/6/14 14:06
     * @param
     * @return void
     */
    public void initList4() {
        List<String> colors = Stream.of("blue", "red", "yellow").collect(toList());
    }

    /**
     *  JDK9功能
     * @author: wuchu
     * @date: Created in 2019/6/14 14:05
     * @param
     * @return void
     */
    public void initList5() {
        //List<String> cups = List.of("A", "B", "C");
    }
    /**
     *   删除ArrayList中重复元素，保持顺序
     * @author: wuchu
     * @date: Created in 2019/6/14 14:00
     * @param list
     * @return java.util.List
     */
    public static List removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element)) {
                newList.add(element);
            }
        }
        list.clear();
        list.addAll(newList);
        return list;
    }


    /**
     *  通过HashSet踢除重复元素
     * @author: wuchu
     * @date: Created in 2019/6/14 14:00
     * @param list
     * @return java.util.List
     */
    public static List removeDuplicate1(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    /**
     *  把list里的对象遍历一遍，用list.contain()，如果不存在就放入到另外一个list集合中
     * @author: wuchu
     * @date: Created in 2019/6/14 14:00
     * @return
     */
    public static List removeDuplicate2(List list){
        List listTemp = new ArrayList();
        for(int i=0;i<list.size();i++){
            if(!listTemp.contains(list.get(i))){
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }

    /**
     *  循环list中的所有元素然后删除重复
     * @author: wuchu
     * @date: Created in 2019/6/14 14:01
     * @param list
     * @return java.util.List
     */
    public  static List removeDuplicate(List list)  {
        for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )  {
            for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )  {
                if  (list.get(j).equals(list.get(i)))  {
                    list.remove(j);
                }
            }
        }
        return list;
    }

}
