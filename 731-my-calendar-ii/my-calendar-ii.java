// Approach -1


class MyCalendarTwo {
    private TreeMap<Integer, Integer> bookings;

    public MyCalendarTwo() {
        bookings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // Increment the count at the start time
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        // Decrement the count at the end time
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);
        
        int activeBookings = 0;
        for (int count : bookings.values()) {
            activeBookings += count;
            if (activeBookings >= 3) {
                // If we encounter a triple booking, revert the changes and return false
                bookings.put(start, bookings.get(start) - 1);
                if (bookings.get(start) == 0) {
                    bookings.remove(start);
                }
                bookings.put(end, bookings.get(end) + 1);
                if (bookings.get(end) == 0) {
                    bookings.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */