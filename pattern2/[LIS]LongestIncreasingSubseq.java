// space - O(n)
// TC - O(n2)
// storage - dp[n] banalo
// meaning 
// T & S
// 10 22 9 33 21] 50 41 60 80 3
//            * yha kya store hoga --? 10 se 21 tak ka sabse bada subsequence ka length jo 21 par khatam hoga 
// 3 constraints he yad rkhna sbse phle subseq hona chahiye fir 21 par khtm hona chahiye fir sabse bada hona chahiye 
// remember subseq or subset pucha substring or subarray ni to continous hoga sochna bhi mt 
// subseq me har element ke pas 2 choice hoti he vo us subsq me ay ya nhi ay
// dp[0] me 1 store hoga because sabse choti problm he 10 p khtm hone wala subseq 10 hi he
// last dp[n - 1] me kya store hoga ? 10 se last 3 tak ke sabse bade subseq jo 3 pe khatm hoga uski length store hogi
// to left to right jayge
// smjne ke lie har step par pehle sare subseq nikalo fir unme se dec htao fir jo let say 21 par khtm ni hore unhe htao
// last me jo bache he jo 21 p khtm hote unme se sabse bada subseq ki length store karo 
// 10 22 9 33 21 50 41 60 80 1
//[ 1 2  1                    ]
// 10 10 9
//    22 

// 33 sochega me 10 ke piche lg skta ha bada hu lgskta hu 
// ------------- 22 ke ----------------------------------
// ------------- 9 ke ------------------------------------
// par lgega vhi jha sbse bdi LCI banayga 10 22 ke piche 
// 10 22 9 33 21 50 41 60 80 1
//[ 1 2  1 3                  ]
// 10 10 9 10
//    22   22
//         33
// 10 22 33 (3 length stored in dp)

// 10 22 9 33 21 50 41 60 80 1
//[ 1 2  1 3  2               ]
// 10 10 9 10 10
//    22   22 21
//         33
// now 21 ayga pehle kha lgega jha vo bda hoga 10 par ha lgskta 22 ke bad ni chota he inc ni bnegi 9 ke ha 33 ke na
// 10 21 , 9 21 dono 2 length ke he koi bhi store krdo

// 10 22 9 33 21 50 41 60 80 1
//[ 1 2  1 3  2  4             ]
// 10 10 9 10 10 10
//    22   22 21 22
//         33    33
//               50
// 50 har kisi ke end se bada he to sb jga lg skta pr lagega vhi jha bada lis bna pay 10 22 33 50 

// 10 22 9 33 21 50 41 60 80 1
//[ 1 2  1 3  2  4              ]
// 10 10 9 10 10 10 10
//    22   22 21 22 22
//         33    33 33
//               50 41
// 40 , 50 vale se bada ni he bas baki sbse he par lgega vhi jha bada bana pay 10 22 33 41

// ese hi har pr khtm hone wale ka maxm store hoga last me sabka maxm lelege 
class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        
        int ovmax = 0;
        
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){  // i se phle walo ka max lelege jo 33 ko ane de mtlb jha vo bada hoga baki end se 
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1; // jo bhi maxm lis pdi milegi usme 1 add krdege mtlb 33 add hoga usme 
            if(dp[i] > ovmax){ // alg se loop lga skte he par yhi sai he ovmax nikal lena har i ke liye 
                ovmax = dp[i];
            }
        }
      return ovmax;
    } 
}    

