package org.example;
import java.util.*;
public class MeetingRoomSolution {
    public static int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> list1=new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> e:A){
            list1.add(new ArrayList<Integer>(Arrays.asList(e.get(0),1)));
            list1.add(new ArrayList<Integer>(Arrays.asList(e.get(1),-1)));
        }
        Collections.sort(list1,(o1,o2)->{
            if(o1.get(0)>o2.get(0)) {
                return 1;
            }else if(o1.get(0)<o2.get(0))
                return -1;
            else {
                if(o1.get(1)>o2.get(1))
                    return 1;
                else if(o1.get(1)<o2.get(1))
                    return -1;
                else
                    return 0;
            }
               
        });
        int curr=0,max=0;
        for(ArrayList<Integer> e:list1){
            curr+=e.get(1);
            max=Math.max(curr,max);
        }
        return max;
    }
}
