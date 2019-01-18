package epi;

//given a matrix sorted by row and column, find a given number in log(n+m) - this is better than n log m
public class SearchSortedMatrix {
    public static void main (String[] args){
        int[][] ip = {
                {1, 2, 4, 4, 6},
                {1, 5, 5, 6, 21},
                { 3, 6, 6, 9, 22},
                {3, 6, 8, 10, 24},
                {6 ,8, 9, 12, 25},
                { 8 ,10, 12, 13, 40}
        };

        System.out.println(find(ip,9 , 0, ip[0].length-1));
        System.out.println(find(ip,10 , 0, ip[0].length-1));
        System.out.println(find(ip,40 , 0, ip[0].length-1));
        System.out.println(find(ip,7 , 0, ip[0].length-1));
    }

    static boolean find(int[][] ip, int k, int row, int col){

        if(col< 0 || row> ip.length-1){// number cannot be found
            return false;
        }
        if(ip[row][col] == k){
            return true;
        }

        if(ip[row][col] < k){//try next row as the the value cannot be in the current row
            return find(ip, k, row+1, col);
        }else if(ip[row][col] > k){//move left and check in the previous column
            return find(ip, k, row, col-1);
        }

        return false;
    }

}
