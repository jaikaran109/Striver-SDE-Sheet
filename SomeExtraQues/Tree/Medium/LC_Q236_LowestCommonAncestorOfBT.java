class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //base case 
        if(root == null || root == p || root == q){  // 1. suppose tm last node pe ho and uske baad left nd right null h then tm vo root return kr doge means tmko kuch nhi mila
                                                     // 2. suppose tmko koi bhi ek mil jata h to tm vha se return kr jaoge 
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);  // left check 
        TreeNode right = lowestCommonAncestor(root.right,p,q); // right check

        if(left == null){  // agr left null hoga to right return kr do 
            return right ;
        }
        else if(right == null){ // agr right null ho to left return kr do
            return left;
        }
        else { 
            return root; // if dono right left mil gye to root return kr do
        }
    }

}


// Dhyaan do agr 1 ka node mil ja rha and 2nd ka nhi mil rha to tm 1st wale ko return kr doge , kyuki constraint me likha h ki dono exist krte h ye sure h 

// test case 2 --  root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4

// isme start 3 se hoga , basecase not full fill
// then left part 5 , base condition occure then ye 5 return kr dega 3 ko 
// now 3 ke right me 1 , not fullfill

// ab left 0 , not fullfill
// ab 0 ke left me null , root == null soo it return null to 0
// ab 0 ke right me null , root == null soo it return null to 0
// ab neeche if-else condition , 1 occ left == null then return right and yha to right bhi null h to null return ho jayega 1 ko

// ab 1 ke right me 8 , base condition not full fill
// 8 ke left me , root == null then return root means null to 8
// 8 ke right me , root == null then return root means null to 8
// now if else thing left == null then return right means null returns to 1 


// ab dhyaan do 
// 1 ke left se bhi null aa rha aur right se bhi to yha if else occ hoga to left == null hh then return right means null to 3

// now we r at node 3
// again if-else condition left != null the first one skip , right == null means return left as a final ans in this case 
