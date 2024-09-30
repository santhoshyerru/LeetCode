class CustomStack {
    int[] arr;
    int curIndex = 0;
    int maxsize;
    public CustomStack(int maxSize) {
        maxsize = maxSize;
        arr = new int[maxSize];
    }
    
    public void push(int x) {
        if(curIndex==maxsize)
        return;
        arr[curIndex++] = x;
    }
    
    public int pop() {
        if(curIndex==0){
            return -1;
        }
        return arr[--curIndex];
    }
    
    public void increment(int k, int val) {
      int limit = Math.min(k, curIndex); // Increment up to the current stack size
        for (int i = 0; i < limit; i++) {
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */