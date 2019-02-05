package epi.stack;

import java.util.Deque;
import java.util.LinkedList;

//Given a valid unix path, compute the shortest path representing the same directory in O(n) time and space
public class NormalizePath {
    public static void main(String[] args){
        System.out.println(normalizePath("scripts//./../scripts/awkscripts/././"));
        System.out.println(normalizePath("/usr/lib/../bin/gcc/./..//"));

        /*
        Output:
        scripts/awkscripts/
        /usr/bin/
         */
    }

    static String normalizePath(String path){

        String[] dirs = path.split("/");
        Deque<String> stk = new LinkedList<>();


        for(String dir: dirs){
            if(dir!= null && !dir.equals("") && !dir.equals(".")){//ignore the null and empty dirs, ignore current dirs as well

                if(dir.equals("..") && stk.size() == 0){// empty stack, so cant go to the parent dir
                    return null;
                }else if(dir.equals("..")){
                    stk.removeFirst();//dir up
                    continue;
                }

                stk.addFirst(dir+"/");


            }
        }

        if(path.startsWith("/")){
            stk.addLast("/");//the first element on the path
        }

        StringBuffer normPath = new StringBuffer();
        while (!stk.isEmpty()){
            normPath.append(stk.removeLast());
        }
        return normPath.toString();
    }
}
