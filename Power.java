//Time Complexity O(N)
//Space Complexity O(N)
//LeetCode tested

public class Power {
    public double myPow(double x, int n) {
        return power(x,n);
    }
    public double power(double x,long n){
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(n<0) return power(1/x,-n);
        double result = power(x*x,n/2);
        if(n%2 == 1) result *= x;
        return result;

    }
}
