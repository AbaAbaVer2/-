package Test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int [] tempArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        //随机
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int Index =  r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[Index];
            tempArr[Index] = temp;
        }
        //遍历一维数组
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i]+" ");
        }
        //把一维数组的元素加载到二维数组中
        int [][] data = new int[4][4];
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++){
                data[i][j] = tempArr[index];
                index++;
            }
        }
        //遍历二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++){
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
    }
}
