package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2020-04-07
 * @desc
 *
 * 二插搜索树的个数
 *
 * 动态规划法
 *
 *
 *
 *
 *
 **/
public class NumTrees {



    /**
     *
     * G(n) = F(1) + F(2) ... + F(n)
     *
     * F(i) = G(i-1) * G(n-1-i) 不考虑 右边树的具体数据 .. 因为只需要 计算数量，所以 ，考虑形状就可以
     *
     * 后续的计算 可以使用 前面的计算结果
     *
     * **/
    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tem = 0;
            for (int j = 1; j <= i; j++) {
                tem = tem + G[j - 1] * G[i - j];
            }
            G[i] = tem;
        }
        return G[n];
    }


    public static void main(String [] args){

        System.out.println(numTrees(3));
    }


}
