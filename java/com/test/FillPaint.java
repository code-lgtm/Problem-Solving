package com.test;

public class FillPaint {
//fill like msPaint fill functionlity
    /*
    Output:
1 1 1 1 1 1 2 2
1 1 1 1 1 1 0 0
1 0 0 1 1 0 1 1
1 5 5 5 5 0 1 0
1 1 1 5 5 0 1 0
1 1 1 5 5 5 5 0
1 1 1 1 1 5 1 1
1 1 1 1 1 5 5 1 
     */

    public static void main(String[] args){
        int[][] ip = {{1, 1, 1, 1, 1, 1, 2,2},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        int[][] sol = fillPaint(ip, 2, 5, 4, 3);//replace color 2 with 5, starting pixel @ 4,3
        print(sol);
    }

    static int[][] fillPaint(int[][] ip,int currentColor, int newColor, int x, int y){
        //

        if(x >= 0 && y >= 0 && x < ip.length && y < ip[0].length && ip[x][y] == currentColor){
            ip[x][y] = newColor;
        }else{
            return ip;
        }


        int[][] newPaint = fillPaint(ip, currentColor, newColor, x+1, y);
        newPaint = fillPaint(newPaint, currentColor, newColor, x, y+1);
        newPaint = fillPaint(newPaint, currentColor, newColor, x-1, y);
        newPaint = fillPaint(newPaint, currentColor, newColor, x, y-1);

        return newPaint ;


    }

    static boolean print(int[][] sol){
        for(int i = 0; i < sol.length; i++){
            for(int j =0; j <sol[0].length; j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }

}
