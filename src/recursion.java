public class recursion {

    public static void recursivecall(int n){
        if(n == 0){
            return ;
        }
        recursivecall(n-1);
        System.out.println(n);
        return;
    }
    public static void recursivecall1(int n){ // n = 5
        if(n == 0){
            return ;
        }
        System.out.println(n); // n = 5
        recursivecall1(n-1); //

        return;
    }
    public static int fibo(int n){

        if(n<2){
            return n;
        }
        return fibo(n-1)+fibo(n-2);


    }
    public static int Binary_Search(int [] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }
        int mid = s +(e-s)/2;
        if(arr[mid] ==target){
            return mid;
        }
        if(target < arr[mid]){
            return Binary_Search(arr,target,s,mid-1);
        }
        else{
            return Binary_Search(arr,target,mid+1,e);
        }
    }

    public static void filter_it(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch =up.charAt(0);
        if(ch == 'a'){
            filter_it(p, up.substring(1));
        }
        else{
            filter_it(p+ch, up.substring(1));
        }

    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,99,190,1000};
        System.out.println(Binary_Search(arr,190,0,arr.length-1));
    }

}
