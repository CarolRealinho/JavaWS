package lists;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMinStringMain {
public static void main(String[] args) {
    ArrayList<String> strList = new ArrayList<>();
    strList.addAll(Arrays.asList("Carolina","Mae","Papier","Un","Liberdade"));

    String strMin = null;
    for(String str:strList){
        if (strMin != null){
            if (strMin.compareTo(str)>0){
                strMin = str;
            }
        }
        else{
            strMin = str;
        }
    }

    System.out.println(strMin);
}
}
