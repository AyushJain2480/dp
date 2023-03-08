
// space leke dp array se bhi krskte he par thoda complicate lga vo muje
// badi problem ko choti problem me tod dia fir choti problem se badi problem 
// tak solve krte jao 
// a+ se a+b+ nikl gya or usee a+b+c+ tbhi dp use kri he 
// for a the formula is 2 * a + 1
// jo a+ he vo or unme a or lga do + naya a alg se 
// for b the formula is 2 * ab + a
// jo (a+b+) he vo or unme hi b or lga do to * 2 + jo purane a+ he unme bhi b lgado
// for c the formula is 2 * abc + ab
// jo (a+b+c+) he vo or unme hi c or lga do to * 2 + jo purane a+b+ he unme bhi c lgado
class Solution
{
    public int fun(String s) {
       long a = 0;
       long ab = 0;
       long abc = 0;
       long mod = (long) Math.pow(10,9) + 7;
       
       for(int i = 0; i < s.length(); i++){
           char ch = s.charAt(i);
           if(ch == 'a'){
               a = (2 * a) % mod + 1;
           }else if(ch == 'b'){
               ab = (2 * ab) % mod + a % mod;
           }else if(ch == 'c'){
               abc = (2 * abc) % mod + ab % mod;
           }
       }
       return (int)(abc % mod);
    }
}
