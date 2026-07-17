class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0 ; 
        int rsum = 0 ;
        int maxSum = 0 ;
        
        // left wala phle compute kro phir last wala add krna and starting wala minus krna and max update krte rahna
        for(int i = 0 ; i < k ; i++)
        {
            lsum += cardPoints[i] ; 
        }

        // initially max = lsum
        maxSum = lsum ; 

        // starting wala minus kro last se add kro  
        int r = cardPoints.length-1 ; 
        for(int i = k-1 ; i >= 0 ; i--)
        {
            lsum = lsum - cardPoints[i] ;
            rsum = rsum + cardPoints[r] ; 
            maxSum = Math.max(maxSum , lsum + rsum) ;
            r-- ;  
        }
        return maxSum ; 
    }
}
