class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String sSorted = new String(sArr);
        String tSorted = new String(tArr);

        return sSorted.equals(tSorted) ? true : false;
    }
}
