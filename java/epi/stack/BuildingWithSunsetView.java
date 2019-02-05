package epi.stack;

import java.util.ArrayList;
import java.util.List;

//Given building heights from east to wests, get the buildings with sunset view in O(n) time
public class BuildingWithSunsetView {
    public static void main(String[] args){
        //heights from east to west
        int[] buildingHeight = {1,3,10,8,9,7,5,6,5,3,1};
        List<Integer> heights = getBuildingHeightsWithView(buildingHeight);
        heights.forEach(height -> System.out.print(height+" "));
        //Output: 1 3 5 6 7 9 10
    }

    static List<Integer> getBuildingHeightsWithView(int[] buildingHeight){
        List<Integer> heights= new ArrayList<>();
        int runningMax = -1;
        for (int i = buildingHeight.length-1; i >= 0; i--){
            if(buildingHeight[i] > runningMax){//building with height greater than the running max will have the sunset view
                heights.add(buildingHeight[i]);
                runningMax = buildingHeight[i];
            }
        }
        return heights;
    }

}
