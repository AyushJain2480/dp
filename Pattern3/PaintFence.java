import java.io.*;
import java.util.*;

// Its a permutation type question 
// n fences k colours 
// not more than 2 conseq fences have same colour 2 ho skta he note isi ke basis par permutation lgegi

//  same  - IN how many ways you can paint upto the 4th fence such that no more two conseq are of the same colour but the last 
// two have the same color.

// diff  -  IN how many ways you can paint upto the 4th fence such that no more two conseq are of the same color and the last 
// two also dont have the same color.
public class Main {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int k = sc.nextInt();
       
       // if you are choosing same from let say 3 colors rgb
       // than you have only 3 ways to select 
       // rr , gg , bb (3c1 for selecting the first i and there is only 1 way to select second i because you have to select the way which you have already selected to make it same)
       // kC1 * 1C1
       long same = k * 1; // (ii)
       
       // for ith position you have 3 options (3c1) for jth position you cant select the one which you have selected because you want something different so rem now 2 (2c1)
       // kC1 * (k-1)C1
       long diff = k * (k - 1); // (ij)
       
       long total = same + diff;
       
       for(int i = 3; i <= n; i++){
           // agli bar fir same chahiye(ii) format me 
           // pichli bar ke same me se nhi lenge because vo already same he like rr gg bb 
           // inme already 2 consec same hochuke he to konse uthay fir diff vale 
           // rg rb gr gb br bg new same are old diff i.e 6 
           // rgg rbb grr gbb brr bgg (ii) select same that takes 1C1
           same = diff * 1;
           
           // agli bar fir diff chahiye(ij) format me
           // prev total are 9 rr bb gg rg rb gr gb br bg
           // you can paint the third colour from the 2 other colours than the one you used last time
           // 9 * 2 = 18
           // rrg , rrb , bbg , bbr ,ggr , ggb , rba , rbr
           diff = total * (k - 1);
           
           total = same + diff;
       }
       System.out.println(total);
    }
}
