// one transaction allowed 
import java.io.*;
import java.util.*;

// aj ke din agar maxm profit me bechna he to me time machine me bethunga or piche us din pe khariduga jaha mal sabse sasta hoga 
// to ek min leke chlo usse pta rhega ki min kis din tha 
// or har din ese kro ki aj kharid ta to kitna profit hota abhi tak k min se agar aj kharid tha to kitna profit hota min se ese krte jao jo max profit hoga return krdena 
public class Main {

    public static void main(String[] args) throws Exception {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int[] arr = new int[n];
          
          for(int i = 0; i < arr.length; i++){
              arr[i] = sc.nextInt();
          }
          
          int min = Integer.MAX_VALUE;
          int maxProfit = 0;
          for(int ele : arr){
            min = Math.min(ele,min);
            maxProfit = Math.max(maxProfit, ele - min);
          }
          
          System.out.println(maxProfit);
    }

}
