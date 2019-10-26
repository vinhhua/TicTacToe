package com.VinhHua;

public class Sum {

    /**
     * This method computes the sum from 1 to n.
     * @param n in this case 100.
     * @return return the sum from 1 to 100.
     */
    public int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * This method computes the sum from n to n1.
     * @param start n, this case is 100.
     * @param end n1, in this case is 1000
     * @return return the sum from 100 to 1000.
     */
    public int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }


}
