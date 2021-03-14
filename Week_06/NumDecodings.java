package week6;

public class NumDecodings {
  public static void main(String[] args) {
    NumDecodings numDecodings = new NumDecodings();
    System.out.println(numDecodings.numDecodings("10011"));
  }

  public int numDecodings(String s) {
    if (s == null || s.length() == 0) return 0;
    String[] words = s.split("");
    if ("0".equals(words[0])) return 0;
    int curr = 1, pre = 1;
    for (int i = 1; i < words.length; i++) {
      int tmp = curr;
      if ("0".equals(words[i])) {
        if ("1".equals(words[i-1]) || "2".equals(words[i-1])) {
          curr = pre;
        } else {
          return 0;
        }
      } else if ("1".equals(words[i - 1]) || ("2".equals(words[i - 1]) && Integer.valueOf(words[i]) <= 6)) {
        curr = pre + curr;
      }
      pre = tmp;

    }
    return curr;

  }

}
