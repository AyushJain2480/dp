// you are given a number n, which represents the length of a road. The road has n plots on each of its side
// THe road is to be planned that there should not be consecutive buildings on either side on the road.
// you are required to find and print the number of ways in which the buildings can be built on both sides of road.
// its just like finding the number of strings having no consecutive 0's.

// [][][][][]   5 buildings on one side of road
// ----------
// [][][][][]  5 buildings on other side of road 

// we will find out that in how many ways one side can be filled without no consecutive B 
// i.e 13 ways - like 5 jagah me se vo vala arrangement jinme B last me atta ho vo 5 ways honge
// or like 5 jagah me vo vala arrangement jinme S last me ata ho vo 8 ways honge 

// total ways jinme B consecutive nai ho vo 13 hoge to ek side 13 ways se bhar skte he 
// dusri be 13 ways se bhar skte he to 13C1 * 13C1

public class Main
{
    public static void main(String[] args) {
       System.out.println(TotalWays(5));
    }
    public static int TotalWays(int N)
    {
      long mod = (long)Math.pow(10,9) + 7;     
      long ocb = 1;
      long ocs = 1;
      for(int i = 2; i <= N; i++){
          long ncb = (ocs) % mod;
          long ncs = (ocs + ocb) % mod;
          
          ocb = ncb;
          ocs = ncs;
      }
      return (int)((ocb + ocs) % mod * (ocb + ocs) % mod);
    }
}
