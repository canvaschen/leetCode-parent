package category.ArrayProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzchen
 * @create 2019-12-18
 * @desc
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 螺旋矩阵
 **/
public class SpiralOrder {


    public static void main(String[] args) {

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        result.add(4);
        System.out.println(result);

    }


    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if(matrix ==null || matrix[0] == null){
            return result;
        }

        // 行
        int m = matrix.length;
        // 列
        int n = matrix[0].length;
        int count ;
        if(n<=m){
            count = n/2 + (n%2 == 0?0:1);
        }else {
            count = m/2 + (m%2 == 0?0:1);
        }

        // 先行后列
        for(int i=0;i<count;i++){
            // 四个边界
            for(int j=i;j<n-i;j++){
                result.add(matrix[i][j]);
            }
            for(int j=i+1;j<m-i;j++){
                result.add(matrix[j][n-i-1]);
            }
            for(int j=n-i-2;j>i;j--){
                result.add(matrix[m-i-1][j]);
            }
            for(int j=m-i-1;j>i;j--){
                result.add(matrix[j][i]);

            }
        }


        return result;
    }

















}
