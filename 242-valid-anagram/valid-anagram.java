class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        String s1 = new String(arr1);
        String s2 = new String(arr2);
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
}