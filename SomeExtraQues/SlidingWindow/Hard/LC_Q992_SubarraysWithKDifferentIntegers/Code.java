// Ye variable size sliding window ka question hai.
//
// Isme "Exactly K Distinct" ko directly count karna easy nahi hota,
// kyunki ek hi window ke andar multiple valid starting points ho sakte hain.
//
// Isliye pehle "At Most K Distinct" subarrays count karte hain,
// phir "At Most (K-1) Distinct" subarrays count karte hain.
//
// Dono ka difference lene se sirf "Exactly K Distinct" wale
// subarrays bach jaate hain.
//
// Formula:
// Exactly(K) = AtMost(K) - AtMost(K-1)

// Ex - example 1 me k = 2 hai 
// to yha agr tm k tk nikalte ho aur phir k - 1 tk to jo diff hoga vo bss k == 2 ka hoga

// still confusion h to --->>>  https://youtu.be/jjEQa44_GrE?si=PoCpASarZrzpF23T  -->> ye dekho

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int atMostK = helper(nums,k);
        int atMostK_minus1 = helper(nums,k-1);
        
        return atMostK - atMostK_minus1;
    }
    private static int helper(int[] nums , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int l = 0 , r = 0;
        while(r < nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
                
            while(map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);

                if(map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }

                l++;
            }

            count += r - l + 1;
            r++;
        }
        return count;
    }
}
// Time - O(4n)
// Space - O(n)




// Brute Force
// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         int count = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             HashSet<Integer> set = new HashSet<>();
//             for(int j = i ; j < nums.length ; j++){
//                 set.add(nums[j]);
//                 if(set.size() == k) count++;
//                 else if(set.size() > k) break;
//             }
//         }
//         return count;
//     }
// }

// Time - O(n^2)
// Space - O(n) - in case sare unique hue to Set ki size N hogi
