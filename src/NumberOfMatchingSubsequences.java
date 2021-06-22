import java.util.LinkedList;
import java.util.Queue;

public class NumberOfMatchingSubsequences {
    class Solution {

        private class Node {
            char[] word;
            int index;// 这个变量是用来遍历每个word用的

            public Node(String word, int index) {
                this.word = word.toCharArray();
                this.index = index;
            }
        }

        public int numMatchingSubseq(String s, String[] words) {
            // 创建一个数组将 字符串数组按照首字符放入其中
            Queue<Node>[] dict = new LinkedList[128];
            for (int i = 'a'; i <= 'z'; i++)
                dict[i] = new LinkedList<>();
            // 将words放入其中
            for (String word : words)
                dict[word.charAt(0)].add(new Node(word, 0));
            int res = 0, n = words.length;
            // 遍历字符串s
            for (char c : s.toCharArray()) {
                // 把当前字符对应数组中位置对应的queue取出来
                Queue<Node> q = dict[c];
                // 遍历队列
                for (int j = q.size(); j > 0; j--) {
                    Node node = q.poll();
                    // 如果当前node已经遍历完了，则证明这是一个subsequence
                    if (++node.index == node.word.length) {
                        if (++res == n)
                            return res;
                    } else
                        // 如果没遍历完，则将ind移动到下一个字符，并以该字符作为首字符并把该节点再插入回队里
                        dict[node.word[node.index]].add(node);
                }
            }

            return res;
        }

    }
}
