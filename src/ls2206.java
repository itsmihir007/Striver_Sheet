import javax.swing.*;
import java.util.Arrays;

public class ls2206 {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            if(nums[i]!= nums[i+1]){
                return false;
            }
        }
        return true;
    }
    //SORTING
    public void selection_sort(int [] arr){
        int n = arr.length;
        

        for (int i = 0; i < n-1; i++) {
            int minindex = i;
            for (int j = 0; j < n; j++) {
                if(arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            if(minindex != i){
                int temp = arr[i];
                arr[i] = arr[minindex];
                arr[minindex] = temp;
            }
        }
    }
    public int myAtoi(String s) {
        int sign = 0;
        int res = 0;
        int i = 0;
            while(i < s.length() && s.charAt(i) == ' '){
                i++;
            }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
            while(i < s.length()){
                char ch = s.charAt(i);
                if(s.charAt(i) < '0' || s.charAt(i) > '9') break;

                if(sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                if(sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                res = res * 10 + ch - '0';


i++;
        }
            return sign *res;
    }
}
