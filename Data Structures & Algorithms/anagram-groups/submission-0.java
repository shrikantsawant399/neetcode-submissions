class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        char[] charArr = null;
        String str = "";

        for(int i = 0; i < strs.length; i++){
            charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            str = new String(charArr);
            if(map.containsKey(str)){
                map.get(str).add(strs[i]);
                map.put(str, map.get(str));
            }else{
                List<String> listStr = new ArrayList<>();
                listStr.add(strs[i]);
                map.put(str, listStr);
            }
        }

        return new ArrayList<>(map.values());
    }
}
