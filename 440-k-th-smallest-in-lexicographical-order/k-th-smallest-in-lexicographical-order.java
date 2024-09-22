class Solution {
    public static long count(long current,long n){
        long result=0;
        long neighbour=current+1;
        while(current<=n){
            neighbour=Math.min(neighbour,n+1);
            result=result+neighbour-current;
            current*=10;
            neighbour*=10;

        }
        return result;
    }
    public int findKthNumber(int n, int k) {
    long i=1;
    long current=1;
    while(i<k){
       long  steps=count(current,n);
    if(i+steps<=k){
        current=current+1;
        i+=steps;
    }
    else{
        current=current*10;
        i+=1;
    }
    }

    return   (int)current;

    }
}