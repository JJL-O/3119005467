package Main;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Description: Test$
 * @Author Tan
 * @Date: 2021/9/16$ 16:03$
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(50);
        arrayList.add(6);
        arrayList.add(4);
        arrayList.add(7);

        Comparator c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if((int)o1<(int)o2)
                    return 1;

                else return -1;
            }
        };
       arrayList.sort(c);
        System.out.println(arrayList);


    }
} 
