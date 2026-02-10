class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int i = 0;
        int j = 0;

        while(i<s.length()){
            if(s.charAt(i) != '#'){
                sb1.append(s.charAt(i));
            }else{
                if(sb1.length() > 0){
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            }
            i++;
        } 


        while(j<t.length()){
            if(t.charAt(j) != '#'){
                sb2.append(t.charAt(j));
            }else{
                if(sb2.length() > 0){
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            }
            j++;
        }

        return sb1.toString().equals(sb2.toString());
    }
}