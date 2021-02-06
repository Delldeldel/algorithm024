package com.wkx.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopKFrequent {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(topKFrequentWithBubble(new int[]{1, 1, 1, 2, 2, 3}, 2)));
  }

  public static  int[] topKFrequentWithBubble(int[] nums, int k) {
    Map<Integer, Integer> counterMap = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
    Pair[] pairs = IntStream.of(nums).distinct().boxed().map(num -> new Pair(num, counterMap.get(num))).toArray(Pair[]::new);


    Pair[] topKPairs = bubbleSelect(pairs, k);

    // 构造返回结果
    int[] res = new int[k];
    int idx = 0;
    for (Pair pair : topKPairs) {
      res[idx++] = pair.num;
    }
    return res;
  }

  private static Pair[] bubbleSelect(Pair[] pairs, int k) {
    bubbleSort(pairs, k);
    return Arrays.copyOfRange(pairs,pairs.length-k,pairs.length);
  }

  private static void bubbleSort(Pair[] pairs, int k) {
    for (int i = 0; i < k; i++) {
      boolean flag = false;
      for (int j = 0; j < pairs.length - i - 1; j++) {
        if (pairs[j].freq > pairs[j + 1].freq) {
          Pair tempPair = pairs[j];
          pairs[j] = pairs[j + 1];
          pairs[j + 1] = tempPair;
          flag = true;
        }
      }
      if (!flag) break;
    }
  }

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      if (countMap.get(nums[i]) != null) {
        countMap.put(nums[i], 1);
      } else {
        countMap.put(nums[i], countMap.get(nums[i]) + 1);
      }
    }
    //    Heap
    //    for (Integer count:countMap.values()) {
    //
    //    }
    //    作者：LeetCode-Solution
    //    链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
      public int compare(int[] m, int[] n) {
        return m[1] - n[1];
      }
    });
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
      int num = entry.getKey(), count = entry.getValue();
      if (queue.size() == k) {
        if (queue.peek()[1] < count) {
          queue.poll();
          queue.offer(new int[]{num, count});
        }
      } else {
        queue.offer(new int[]{num, count});
      }
    }
    int[] ret = new int[k];
    for (int i = 0; i < k; ++i) {
      ret[i] = queue.poll()[0];
    }
    return ret;
  }

  /*作者：sweetiee
  链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/4-chong-fang-fa-miao-sha-topkji-shu-pai-xu-kuai-pa/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
  public int[] topKFrequent2(int[] nums, int k) {
    // 统计每个数字出现的次数
    Map<Integer, Integer> counterMap = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
    // 构造Pair数组，Pair.num 表示数值，Pair.freq 表示数字出现的次数
    Pair[] pairs = IntStream.of(nums).distinct().boxed().map(num -> new Pair(num, counterMap.get(num))).toArray(Pair[]::new);


    // 使用快排变形 O(N) 获取Pair数组中频次最大的 k 个元素（第 4 个参数是下标，因此是 k - 1）。
    Pair[] topKPairs = quickSelect(pairs, 0, pairs.length - 1, k - 1);

    // 构造返回结果
    int[] res = new int[k];
    int idx = 0;
    for (Pair pair : topKPairs) {
      res[idx++] = pair.num;
    }
    return res;
  }

  private Pair[] quickSelect(Pair[] pairs, int lo, int hi, int idx) {
    if (lo > hi) {
      return new Pair[0];
    }
    // 快排切分后，j 左边的数字出现的次数都大于等于 pairs[j].freq，j 右边的数字出现的次数都小于等于 pairs[j].freq。
    int j = partition(pairs, lo, hi);
    // 如果 j 正好等于目标idx，说明当前pairs数组中的[0, idx]就是出现次数最大的 K 个元素。
    if (j == idx) {
      return Arrays.copyOf(pairs, idx + 1);
    }
    // 否则根据 j 与 idx 的大小关系判断找左段还是右段
    return j < idx ? quickSelect(pairs, j + 1, hi, idx) : quickSelect(pairs, lo, j - 1, idx);
  }

  private int partition(Pair[] pairs, int lo, int hi) {
    Pair v = pairs[lo];
    int i = lo, j = hi + 1;
    while (true) {
      while (++i <= hi && pairs[i].freq > v.freq) ;
      while (--j >= lo && pairs[j].freq < v.freq) ;
      if (i >= j) {
        break;
      }
      Pair tmp = pairs[i];
      pairs[i] = pairs[j];
      pairs[j] = tmp;
    }
    pairs[lo] = pairs[j];
    pairs[j] = v;
    return j;
  }
}

class Pair {
  int num;
  int freq;

  public Pair(int num, int freq) {
    this.num = num;
    this.freq = freq;
  }


}
