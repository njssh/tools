// Copyright (C) 2017 Meituan
// All rights reserved
package utils;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * @author niujs
 * @version 1.0
 * @created 2017/12/6 下午3:27
 **/
public class CompareUtils {

    // 查询重复的数字
    public static List<Integer> listRepeat(List<Integer> toBeCompareList) {
        if(CollectionUtils.isEmpty(toBeCompareList)) {
            return null;
        }
        if(toBeCompareList.size()==1) {
            return Collections.emptyList();
        }

        // 1. 升序排序 O(nlogn)
        Collections.sort(toBeCompareList);

        // 2. 从前往后比较 O(n)
        int pre = 0;
        boolean first = true;
        List<Integer> repeatList = new ArrayList<Integer>();
        for(Integer i : toBeCompareList) {
            if(first) {
                // 第一次先将上一条记录记为当前
                pre = i;
                first = false;
                continue;
            }

            if(i.equals(pre)) {
                if(!repeatList.contains(i)) {
                    repeatList.add(i);
                }
            }

            // 指针后移
            pre = i;
        }

        return repeatList;
    }

    public static List<Integer> listRepeat2(List<Integer> toBeCompareList) {
        if(CollectionUtils.isEmpty(toBeCompareList)) {
            return null;
        }
        if(toBeCompareList.size()==1) {
            return Collections.emptyList();
        }

        // 1. 新建一个与比较list大小一致的hashmap
        HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>(toBeCompareList.size(), 1);

        // 2. 遍历list，取值放入map，重复则计入
        List<Integer> repeatList = new ArrayList<Integer>();
        for(Integer i : toBeCompareList) {

            if(map.get(i) != null) {
                if(!repeatList.contains(i)) {
                    repeatList.add(i);
                }
            } else {
                map.put(i, i);
            }
        }

        return repeatList;
    }

    public static List<Integer> listRepeat3(List<Integer> toBeCompareList) {
        return null;
    }


    public static void main(String[] args) {

        Random random = new Random(1000);
        List<Integer> toBeCompareList = new ArrayList<Integer>(10050);
        for (int i = 0; i < 500; i++) {
            toBeCompareList.add(random.nextInt(40));
        }

        System.out.println(listRepeat(toBeCompareList));
    }
}