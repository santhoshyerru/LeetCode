class Solution {
    public int[] findNSE(int[] arr){
        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i = arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            nse[i] = st.isEmpty()? arr.length: st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findNGE(int[] arr){
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            nge[i] = st.isEmpty()? arr.length: st.peek();
            st.push(i);
        }
        return nge;
    }

    public int[] findPSEE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] psee = new int[n];
        for(int i=0;i<n;i++){
              while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
        return psee;
    }

    public int[] findPGEE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] pgee = new int[n];
        for(int i=0;i<n;i++){
              while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                st.pop();
            }
            pgee[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
        return pgee;
    }

     /* Function to find the sum of the 
    minimum value in each subarray */
    private long sumSubarrayMins(int[] arr) {
        
        int[] nse = findNSE(arr);
        
        int[] psee = findPSEE(arr);
        
        // Size of array
        int n = arr.length;
        
        // To store the sum
        long sum = 0;
        
        // Traverse on the array
        for (int i = 0; i < n; i++) {
            
            // Count of first type of subarrays
            int left = i - psee[i];
            
            // Count of second type of subarrays
            int right = nse[i] - i;
            
            /* Count of subarrays where 
            current element is minimum */
            long freq = left * right * 1L;
            
            // Contribution due to current element 
            long val = (freq * arr[i] * 1L);
            
            // Updating the sum
            sum += val;
        }
        
        // Return the computed sum
        return sum;
    }
    
    /* Function to find the sum of the 
    maximum value in each subarray */
    private long sumSubarrayMaxs(int[] arr) {
        
        int[] nge = findNGE(arr);
        
        int[] pgee = findPGEE(arr);
        
        // Size of array
        int n = arr.length;
        
        // To store the sum
        long sum = 0;
        
        // Traverse on the array
        for (int i = 0; i < n; i++) {
            
            // Count of first type of subarrays
            int left = i - pgee[i];
            
            // Count of second type of subarrays
            int right = nge[i] - i;
            
            /* Count of subarrays where 
            current element is maximum */
            long freq = left * right * 1L;
            
            // Contribution due to current element 
            long val = (freq * arr[i] * 1L);
            
            // Updating the sum
            sum += val;
        }
        
        // Return the computed sum
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
    }
}