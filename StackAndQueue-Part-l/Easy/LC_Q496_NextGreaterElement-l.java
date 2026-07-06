class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] greater = new int[nums2.length];
        for(int i = nums2.length - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && st.peek() < nums2[i] ){
                st.pop();
            }
            if(st.isEmpty()) greater[i] = -1;
            else greater[i] = st.peek();
            st.push(nums2[i]);
        }


        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums2.length ; i++){
            map.put(nums2[i],greater[i]);
        }

        int[] ans = new int[nums1.length];

        for(int i = 0 ; i < nums1.length ; i++){
            if(map.containsKey(nums1[i])){
                ans[i] = map.get(nums1[i]);
            }
        }

        return ans;

    }
}


// I think ye brute force h kyuki 4ms aaya h 


// chalo code samjhte h 

// maine ke greater arr bnaya h and usme nums2 ke sare elements ka greater store kr liya h and ek hash map bna liya h jo nums2 ke values ke saath uske greater element from greater arr store kr rha h

// ab neeche ek ans array h usme hm nums1 ki values map me check kr rhe h aur unke greater wale key ko store kr rhe h 