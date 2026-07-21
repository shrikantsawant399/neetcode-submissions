class Solution {

    public String encode(List<String> strs) {
        String result = "";
        if(strs.isEmpty()) return "";
        for(String str : strs){
            result = result + String.valueOf(str.length()) + "#" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int len = 0;
        String test = "";
        if(str.length() == 0){
            return list;
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '#'){
                len = Integer.valueOf(test);
                test = "";
                list.add(str.substring(i+1, i + len + 1));
                i = i + len;
            }else{
                test = test + str.charAt(i);
            }
        }

        return list;
    }
}