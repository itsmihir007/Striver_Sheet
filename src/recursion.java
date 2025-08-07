public class recursion {
    public static void main(String[] args) {
        int n = 5;
        recursivecall1(n);
    }
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

}
