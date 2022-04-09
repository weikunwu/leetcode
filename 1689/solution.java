class Solution {
    public int minPartitions(String n) {
        int num = 0;
        for (int i = 0; i < n.length(); i++) {
            num = Math.max(num, Integer.valueOf(n.substring(i,i+1)));
        }
        return num;
    }
}