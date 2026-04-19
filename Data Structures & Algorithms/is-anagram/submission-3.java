class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        String[] sArr = s.split("");
        String[] tArr = t.split("");
        Hashtable<String, Integer> ht1 = new Hashtable<>();
        Hashtable<String, Integer> ht2 = new Hashtable<>();

        for(int i = 0; i < sArr.length; i++){
            if(ht1.containsKey(sArr[i])){
                ht1.put(sArr[i], ht1.get(sArr[i]) + 1);
            }else{
                ht1.put(sArr[i], 1);
            }
            if(ht2.containsKey(tArr[i])){
                ht2.put(tArr[i], ht2.get(tArr[i]) + 1);
            }else{
                ht2.put(tArr[i], 1);
            }
        }
        return ht1.equals(ht2);
    }
}
