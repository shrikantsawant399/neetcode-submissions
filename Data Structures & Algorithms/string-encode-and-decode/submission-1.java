class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        if(strs.isEmpty()) return "";
        for(String str : strs){
            result.append(String.valueOf(str.length())).append("#").append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int len = 0;
        int delimiterIndex = 0;
        if(str.length() == 0){
            return list;
        }
        for(int i = 0; i < str.length();){
            delimiterIndex = str.indexOf("#", i);
            len = Integer.valueOf(str.substring(i, delimiterIndex));
            list.add(str.substring(delimiterIndex+1, delimiterIndex+1+len));
            i = delimiterIndex+1+len;
        }

        return list;
    }
}