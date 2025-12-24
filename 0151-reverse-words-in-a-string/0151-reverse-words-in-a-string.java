class Solution {
    public String reverseWords(String s) {
        // trim
        // l, r, s
        // sb -> s cleaned with multiple spaces to a single space
        // reverse sb
        // reverse word by word in sb

        int l = 0;
        int r = s.length() - 1;

        while(l<s.length()){
            if(s.charAt(l) == ' ') l++;
            else break;
        }

        while(r >= 0){
            if(s.charAt(r) == ' ') r--;
            else break;
        }

        StringBuilder sb = new StringBuilder();

        while(l<=r){
            if(s.charAt(l)!=' '){
                sb.append(s.charAt(l));
                l++;
            }else if(s.charAt(l) == ' '){
                if(sb.charAt(sb.length() - 1) != ' '){
                    sb.append(' ');
                    l++;
                }else{
                    l++;
                }
            }
        }

        int i = 0;
        int j = sb.length() - 1;

        while(i<j){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }

        int st=0;
        int en=0;
        while(st<sb.length()){
            while(en<sb.length() && sb.charAt(en)!=' '){
                en++;
            }

            int p1 = st;
            int p2 = en - 1;
            while(p1<p2){
                char temp = sb.charAt(p1);
                sb.setCharAt(p1, sb.charAt(p2));
                sb.setCharAt(p2, temp);
                p1++;
                p2--;
            }

            st = en + 1;
            en = st;
        }

        return sb.toString();
    }
}