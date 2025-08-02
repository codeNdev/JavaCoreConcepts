package basic;

import java.util.Map;

public class Array2D {
    public static void main(String[] args) {
        int nums[][]=new int[4][5];
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[i].length;j++){
                int rand= (int) (Math.random()*100);// generates number from 0-99(both inclusive) randomly
                nums[i][j]=rand;
            }
        }
        for (int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                System.out.print(nums[i][j] +" ");
            }
            System.out.println();
        }
    }
}
