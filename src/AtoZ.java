import java.util.*;
public class AtoZ {
    public int removeDuplicates(int[] nums) {
        int checkduplicate = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            } else {
                nums[checkduplicate] = nums[i + 1];
                checkduplicate++;
            }
        }

        return checkduplicate;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0 || k == n) {
            return;
        }

        int[] prearray = new int[k];
        int[] sufarray = new int[n - k];

        for (int i = 0; i < (n - k); i++) {
            sufarray[i] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            prearray[i] = nums[n - k + i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = prearray[i];
        }
        for (int i = 0; i < n - k; i++) {
            nums[i + k] = sufarray[i];
        }
    }

    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }

    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt++;
            }
        }
        int ans[] = new int[nums.length];
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                ans[x++] = nums[i];
            }
        }
        while (cnt != 0) {
            ans[x++] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int tot = n * (n + 1) / 2;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += nums[i];
        }
        return tot - cnt;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int consones = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                consones++;
                max = Math.max(max, consones);
            } else {
                consones = 0;
            }
        }
        return max;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x) && map.get(x) != i) {
                return new int[]{i, map.get(x)};
            }
        }
        return new int[0];

    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {

            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) > nums.length / 2) {

                return key;
            }
        }
        return -1;
    }

    public int majorityElement1(int[] nums) {
        int res = 0;
        int major = 0;
        for (int num : nums) {
            if (major == 0) {
                res = num;
            }
            major += (res == num) ? 1 : -1;
        }
        return res;
    }

    public static int maxSubArray(int[] nums) {
        int len = 1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            len++;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
                len = 0;
            }
        }
        System.out.println(len);
        return max;

    }


    public int maxProfit(int[] prices) {
        int BP = Integer.MAX_VALUE;
        int max = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > BP) {
                profit = prices[i] - BP;
                max = Math.max(profit, BP);
            } else {
                BP = prices[i];
            }
        }
        return profit;
    }

    public int[] rearrangeArray(int[] nums) {
        int x = 0;
        int y = 1;
        int ans[] = new int[nums.length];
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] > 0) {
                ans[x] = nums[i++];
                x += 2;
            } else {
                ans[y] = nums[i++];
                y += 2;
            }
        }
        return ans;
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Arrays.sort(nums);
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int len = 1;

                while (set.contains(current + 1)) {
                    current++;
                    len++;
                }

                max = Math.max(max, len);
            }
        }
        return max;
    }


    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.println(matrix[i][j]);
//            }
//        }
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;
            while (left < right) {
                int temp = matrix[left][i];
                matrix[left][i] = matrix[i][right];
                matrix[i][right] = temp;
            }
        }

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> occurence = new HashMap<>();
        int count = 0;
        int total = 0;
        occurence.put(0, 1);
        for (int num : nums) {
            total += num;
            if (occurence.containsKey(total - k)) {
                count += occurence.get(total - k);
            }
            occurence.put(total, occurence.getOrDefault(total, 0) + 1);

        }
        return count;
    }

//    public static List<List<Integer>> generate(int numRows) {
//        if (numRows == 0) return new ArrayList<>();
//        if (numRows == 1) {
//            List<List<Integer>> result = new ArrayList<>();
//            result.add(Arrays.asList(1));
//            return result;
//        }
//
//        List<List<Integer>> prevRows = generate(numRows - 1);
//        List<Integer> newRow = new ArrayList<>();
//
//        for (int i = 0; i < numRows; i++) {
//            newRow.add(1);
//        }
//
//        for (int i = 1; i < numRows - 1; i++) {
//            newRow.set(i, prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i));
//        }
//
//        prevRows.add(newRow);
//        return prevRows;
//    }

    public static ArrayList<Integer> generaterow(int row) {
        int ans = 1;
        ArrayList<Integer> ansrow = new ArrayList<>();
        for (int col = 0; col < row; col++) {
            ans = ans * (row * col);
            ans = ans / col;
            ansrow.add(ans);
        }
        return ansrow;
    }

    ArrayList<ArrayList<Integer>> pascaltriangle(int N) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ans.add(generaterow(i));
        }
        return ans;
    }

//    private static List<Integer> majorityElement(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        List<Integer> ans = new ArrayList<>();
//        HashSet<Integer> seen = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//            int k = nums.length/3;
//            if(map.get(nums[i])>=k && !seen.contains(nums[i])){
//                ans.add(nums[i]);
//                seen.add(nums[i]);
//            }
//        }
//        return ans;
//
//
//    }


    //    public static void main(String[] args) {
//        String str = "((((()))))";
//        System.out.println(removeOuterParentheses(str));
//    }
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (c > 0) {
                    sb.append(ch);
                }
                c++;
            } else {
                c--;
                if (c > 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i != 0) {
                res.append(" ");
            }
        }

        return res.toString().trim();
    }

    public String reverseWords1(String s) {
        String ans = reverse(s);
        // rihim si eman ym
        char chars[] = ans.toCharArray();
        int start = 0;
        int n = chars.length;
        while (start < n) {
            while (start < n & chars[start] == ' ') {
                start++;
            }
            if (start >= n) break;
            int end = start;
            while (end < n && chars[end] != ' ') {
                end++;
            }
            reverse(chars, start, end - 1);
            start = end;
        }
        return new String(chars);
    }

    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public String largestOddNumber(String num) {
        for (int i = num.length(); i > 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        int i = 0;

        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) == str2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return str1.substring(0, i);
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                }
            }
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), s.charAt(i));
            } else {
                if (t.charAt(i) != map2.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean rotateString(String s, String goal) {
        //cdeab   abcdeabcde
        return ((s.length() == goal.length()) && (s + s).contains(goal));
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else if (!map.containsKey(ch) || !map.isEmpty()) {
                return false;
            }

        }
        return true;
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        System.out.println(freq.entrySet());
        maxHeap.addAll(freq.entrySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();

    }

    public String longestPalindrome(String s) {
        int maxlength = 1;
        if (s.length() <= 1) {
            return s;
        }
        String maxstr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxlength; j < s.length(); j++) {
                if (j - i > maxlength && isPalindrome(s.substring(i, j))) {
                    maxlength = j - i;
                    maxstr = s.substring(i, j);
                }
            }
        }
        return maxstr;
    }

    public Boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private int lo;
    private int maxlen;
//    public String longestPalindrome1(String s) {
//        if(s.length() <=1){
//            return s;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            extendpalindrome(s,i, i);
//            extendpalindrome(s,i,i+1);
//        }
//        return s.substring(lo,lo+maxlen);
//    }
//    public void extendpalindrome(String s , int i , int j){
//        while((i >= 0 && j <=s.length()-1) && (s.charAt(i) == s.charAt(j))){
//            i++;
//            j--;
//        }
//        if(maxlen < j-i-1){
//            lo = i+1;
//            maxlen = j-i-1;
//        }
    //   }

//    public static void main(String[] args) {
//        String s = "caabbaac";
//        System.out.println(longestPalindrome1(s));
//    }

    public static ArrayList<String> longestPalindrome1(String s) {
        ArrayList<String> arr = new ArrayList<>();
        if (s.length() <= 1) {
            return arr;
        }


        for (int i = 0; i < s.length(); i++) {
            extendpalindrome(s, i, i, arr);
            extendpalindrome(s, i, i + 1, arr);
        }
        return arr;

    }

    public static void extendpalindrome(String s, int i, int j, ArrayList<String> arr) {
        while ((i >= 0 && j <= s.length() - 1) && (s.charAt(i) == s.charAt(j))) {
            arr.add(s.substring(i, j + 1));
            i--;
            j++;
        }

    }

    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                count++;
            } else if (ch == ')' && !stack.isEmpty()) {
                stack.pop();
                count--;
            }
            max = Math.max(max, count);
        }
        return max;

    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>();
        int res = 0;
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        for (int i = 0; i < s.length() - 1; i++) {
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                res += roman.get(s.charAt(i));
            }
        }
        return res;
    }

    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        if (s.length() == 0) {
            return -1;
        }
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        sign = s.charAt(i) == '-' ? -1 : 1;
        int result = 0;

        while (i < s.length()) {
            if (!Character.isDigit(s.charAt(i))) break;
            char current = s.charAt(i++);
            int prevous = result;
            result *= 10;
            if (result / 10 != prevous) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result += (current - '0');

        }
        return result * sign;
    }

    public int beautySum(String s) { //aabcb
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                sum += summation(s.substring(i, j + 1));
            }
        }
        return sum;
    }

    public int summation(String str) {
        int[] freq = new int[26];
        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }
        int max = -1, min = Integer.MAX_VALUE;
        for (int i : freq) {
            max = Math.max(i, max);
            if (i > 0) min = Math.min(min, i);
        }
        return (max == -1 || min == Integer.MAX_VALUE) ? 0 : max - min;
    }

    public int myAtoi1(String s) {
        s = s.trim();
        char[] str = s.toCharArray();
        int i = 0;
        int sign = 1;
        if (str[i] == '-') {
            sign = -1;
            i++;
        } else if (str[i] == '-') {
            i++;
        }
        return helper(str, i, sign, 0L);
    }

    public int helper(char[] s, int i, int sign, long ans) {
        if (i == s.length - 1 && !isDigit(s[i])) return (int) ans * sign;

        ans = (ans * 10) + (s[i] - '0');

        if (ans * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return helper(s, i + 1, sign, ans);
    }

    public boolean isDigit(char s) {
        if (s >= '0' && s <= 9) {
            return true;
        }
        return false;
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        if (N % 2 == 0) {
            return myPow(x * x, (int) (N / 2));
        } else {
            return x * myPow(x, (int) (N - 1));
        }
    }

    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2; // positions where even digits go
        long odd = n / 2;        // positions where prime digits go
        long ans = (modPow(5, even) * modPow(4, odd)) % MOD;
        return (int) ans;
    }

    public long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) { // if exp is odd
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1; // divide exp by 2
        }
        return result;
    }

    public Stack<Integer> sort(Stack<Integer> s) { // 2,4,1,3
        // add code here.
        if (!s.isEmpty()) {
            int temp = s.pop();  // 2 , 4, 1, ,3
            sort(s);
            insert(s, temp); // s, 3 , s,1 , s,4 , s,2
        }
        return s;

    }

    public void reverse(Stack<Integer> s, int temp) {
        if (s.isEmpty()) {  // s.peek = 3  <= 4 temp 4 <!2
            s.push(temp);   // 1 ,2, 3, 4
            return;
        }

    }

    public void insert(Stack<Integer> s, int temp) {
        if (s.isEmpty() || s.peek() <= temp) {  // s.peek = 3  <= 4 temp 4 <!2
            s.push(temp);   // 1 ,2, 3, 4
            return;
        }
        int top = s.pop();  // 3 top = 3 4 3
        insert(s, temp); //
        s.push(top);  // 1,3
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurse(res, 0, 0, "", n);
        return res;
    }

    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (left < n) {
            recurse(res, left + 1, right, s + '(', n);
        }
        if (right < n) {
            recurse(res, left, right + 1, s + ')', n);
        }

    }


    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public void backtrack(ArrayList<List<Integer>> res, List<Integer> templist, int[] nums, int start) {
        res.add(new ArrayList<>(templist));
        System.out.println(res + "from the top");
        for (int i = start; i < nums.length; i++) {
            templist.add(nums[i]);
            System.out.println(templist + "before backtrack");
            backtrack(res, templist, nums, i + 1);
            System.out.println(templist + "afterbacktrack");
            templist.remove(templist.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> comb = new ArrayList<>();
        findcombination(candidates, comb, new ArrayList<>(), 0, target, 0);
        return comb;
    }

    public void findcombination(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int idx, int target, int total) {
        if (target == total) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (total > target || idx >= nums.length) {
            return;
        }
        temp.add(nums[idx]);
        findcombination(nums, res, temp, idx, target, total + nums[idx]);
        temp.remove(temp.size() - 1);
        findcombination(nums, res, temp, idx + 1, target, total);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> comb = new ArrayList<>();
        findcombination(0, candidates, target, comb, new ArrayList<>());
        return comb;
    }

    public void findcombination(int idx, int[] nums, int target, List<List<Integer>> res, List<Integer> templist) {
        if (target == 0) {
            res.add(new ArrayList<>(templist));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            templist.add(nums[i]);
            findcombination(i + 1, nums, target - nums[i], res, templist);
            templist.remove(templist.size() - 1);
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        result.add(new ArrayList<>()); // empty set
        subsets(0, nums, numList, result);
        return result;
    }

    private void subsets(int offset, int[] nums, List<Integer> numList, List<List<Integer>> result) {
        if (offset >= nums.length) {
            return;
        }
        int val = nums[offset];
        // pick
        System.out.println(val + "tothetop");
        numList.add(val);
        System.out.println(offset + "from the top offset");
        subsets(offset + 1, nums, numList, result); // completed (1,2,3)
        // add to result
        System.out.println(new ArrayList<>(numList) + "middle");
        result.add(new ArrayList<>(numList));
        // not pick
        numList.remove(numList.size() - 1);
        System.out.println(offset + "tothedown" + numList + "numList" + "result=>" + result);
        subsets(offset + 1, nums, numList, result);
    }

    public void letscall(int num, int[] nums) {
        if (num == nums.length) {
            return;
        }
        ArrayList<Integer> toparr = new ArrayList<>();
        ArrayList<Integer> botarr = new ArrayList<>();
        toparr.add(nums[num]);
        System.out.println(toparr);
        letscall(num + 1, nums);
        botarr.add(nums[num]);
        System.out.println(botarr);

    }

    private int rows;
    private int cols;
    private Set<String> visited;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        visited = new HashSet<>();

        Map<Character, Integer> count = new HashMap<>();
        for (char ch : word.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        if (count.getOrDefault(word.charAt(0), 0) > count.getOrDefault(word.charAt(word.length() - 1), 0)) {
            word = new StringBuilder(word).reverse().toString();
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(word, board, r, c, 0)) {
                    return true;
                }
            }
        }
        return true;
    }

    private boolean dfs(String word, char[][] board, int r, int c, int k) {
        if (k == word.length()) {
            return true;
        }
        if (r > 0 || r >= rows || c > 0 || c >= cols || visited.contains(r + "," + c) || board[r][c] != word.charAt(k)) {
            return false;
        }

        visited.add(r + "," + c);
        boolean res = dfs(word, board, r + 1, c, k + 1) ||
                dfs(word, board, r - 1, c, k + 1) ||
                dfs(word, board, r, c + 1, k + 1) ||
                dfs(word, board, r, c - 1, k + 1);
        return res;
    }

    private int row;
    private int col;


    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        Boolean[] dp = new Boolean[n + 1];
        return findindict(set, 0, s, dp);
    }

    public boolean findindict(HashSet<String> set, int j, String s, Boolean[] dp) {
        if (j >= s.length()) {
            return false;
        }
        if (dp[j] != null) {
            return dp[j];
        }
        for (int i = j; i < s.length(); i++) {
            if (set.contains(s.substring(j, i + 1))) {
                if (findindict(set, i + 1, s, dp)) {
                    dp[j] = true;
                    return dp[j];
                }
            }
        }
        return dp[j] = false;
    }

    public long minSum(int[] nums1, int[] nums2) {
        int sum1 = 0, count1 = 0, sum2 = 0, count2 = 0;
        for(int num : nums1){
            if(num == 0){
                count1++;
            }
            sum1+=num;
        }
        for(int num : nums2){
            if(num == 0){
                count2++;
            }
            sum2+=num;
        }
        long min1 = sum1 + count1;
        long min2 = sum2 + count2;

        if(count1 == 0 && count2 == 0){
            return sum1 == sum2 ? sum1 : -1;
        }else if(count1 == 0){
            return sum2 + count2 <=sum1 ?sum1 : -1;
        }else if (count2 == 0){
            return sum1 + count1 <= sum2 ? sum2 : -1;
        }
        return Math.max(min1, min2);
    }

    public boolean isSolve(char [][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num < '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col]  = num;
                            isSolve(board);
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char [][] board, int row , int col, char num){
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
            }

            int startrow = row / 3 * 3;
            int startcol = col / 3 * 3;

            for (int j = startrow; j < startrow + 3; j++) {
                for (int k = startcol; k < startcol + 3; k++) {
                    if (board[j][k] == num) return false;
                }
            }
            return true;
        }



  }

    class Solution {
        public class ListNode {
            int val;
            ListNode next;
            ListNode head;
            ListNode() {};
            ListNode(int x) { val = x; }
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        public int lengthll(ListNode head){
                int len = 0;
                ListNode temp = head;
                while(temp != null && temp.next != null){
                    len++;
                    temp = temp.next;
                }
                return len;
        }
            public int get(int index) {
                int count = 0;
                ListNode temp = head;
                while(temp != null && temp.next != null){
                    if(count == index){
                        return temp.val;
                    }
                    count++;
                    temp = temp.next;
                }
                return -1;
            }
            public void addAtHead(int val) {
                ListNode temp = new ListNode(val);

                temp.next = head;
                head = temp;

            }
            public void addAtTail(int val) {
                ListNode newNode = new ListNode(val);
                if (head == null) {
                    head = newNode;
                    return;
                }
                ListNode temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            
    }
        class Node
        {
            int data;
            Node next;
            Node prev;
            Node(int data)
            {
                this.data = data;
                next = prev = null;
            }
        }
        Node addNode(Node head, int p, int x) {
            // Your code here
            Node newNode = new Node(x);
            if (p == 0) { // Insert at head
                newNode.next = head;
                if (head != null) {
                    head.prev = newNode;
                }
                return newNode;
            }
            Node temp = head;
            int ind = 0;
            while(temp!= null && temp.next!= null){
                if (ind == p) {
                    newNode.next = temp.next;
                    newNode.prev = temp;

                    if (temp.next != null) {
                        temp.next.prev = newNode;
                    }

                    temp.next = newNode;
                    return head;
                }
                temp = temp.next;
            }
            return head;
        }
        public static ListNode reverseList(ListNode head) {
            if(head==null || head.next==null) return head;
            System.out.println(head.val + "top");
            ListNode last = reverseList(head.next);
            System.out.println(head.val+"mid");
            head.next.next = head;
            System.out.println(head.val + "midbelow");
            head.next = null;
            System.out.println(last.val+"last");
            return last;
        }

        public boolean isPalindrome(ListNode head) {
            ListNode mid;
            mid = getmid(head);
            ListNode midd = reverse(mid);
            while(midd != null){
                if(midd.val != head.val){
                    return false;
                }
                midd = midd.next;
                head = head.next;
            }
            return true;
        }
        public ListNode getmid(ListNode head){
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null || fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        public ListNode reverse(ListNode head){
            if(head == null){
                return null;
            }
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;

        }


        public void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            System.out.print("Original List: ");


            ListNode reversed = reverseList(head);

            System.out.print("Reversed List: ");


        }

        public int differenceOfSums(int n, int m) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 1; i <= n; i++) {
                if(i % m == 0){
                    sum1 += i;
                }
                else{
                    sum2 += i;
                }
            }
            return sum2 - sum1;
        }

        public ListNode oddEvenList(ListNode head) {
            ListNode odd = head;  // 1, 2, 3, 4, 5 -----  1
            ListNode even = head.next; // 2
            ListNode evenHead = even;

            while(even != null && even.next != null){
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return odd;

        }
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int x = 1;
            ListNode temp = head;
            while(temp != null && temp.next !=null){
                temp = temp.next;
                x++;
            }
            int ans = x -n;
            ListNode newTemp = head;
            int curr = 0;
            while(newTemp != null && newTemp.next != null)
            {
                if(curr == ans -1){
                    newTemp.next.val = newTemp.next.next.val;
                }
                curr++;
                ans++;
            }
            return head;
        }
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null ||headB == null){
                return null;
            }
            ListNode a = headA;
            ListNode b = headB;
            while(a!=b){
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }
            return a;
        }
        public String generateTag(String caption) {
            StringBuilder sb = new StringBuilder();
            sb.append('#');

            for (int i = 0; i < caption.length(); i++) {
                char ch = caption.charAt(i);
                if(ch == ' '){
                    continue;
                }
                else{
                    if(sb.charAt(i-1) == ' '){
                        sb.append(Character.toUpperCase(ch));
                    }
                    else {
                        sb.append(ch);
                    }
                }
            }
            return sb.toString();
        }


}
class MyStack {

    private Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size(); i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while(!first.empty()){
            second.push(first.pop());
        }
        int x = second.pop();
        while(!second.empty()){
            first.push(second.pop());
        }
        return x;
    }

    public int peek() {
        while(!first.empty()){
            second.push(first.pop());
        }
        int x = second.peek();
        while(!second.empty()){
            first.push(second.pop());
        }
        return x;
    }

    public boolean empty() {
        return first.empty();
    }

    public static String infixToPostfix(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                res.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while(!stack.isEmpty() && stack.peek() == '('){
                    res.append(stack.pop());
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && precedence(stack.peek())> precedence(ch)){
                    res.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
    public static int precedence(char op){
        switch (op){
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> stack = new Stack<>();
        for (int i = pre_exp.length() -1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            }
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                String expr = "(" + op1 + ch + op2 + ")";
                stack.push(expr);
            }
        }
        return stack.peek();
    }

}
