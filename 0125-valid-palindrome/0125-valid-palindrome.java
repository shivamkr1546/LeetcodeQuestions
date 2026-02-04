class Solution {
    public boolean isPalindrome(String s) {
        int lt = 0;
        int rt = s.length() - 1;

        while(lt <= rt){
            char left = s.charAt(lt);
            char right = s.charAt(rt);

            if(!Character.isLetterOrDigit(left)){
                lt++;
                continue;
            }
            if(!Character.isLetterOrDigit(right)){
                rt--;
                continue;
            }

            if(Character.toLowerCase(left) != Character.toLowerCase(right)) return false;
            lt++;
            rt--;
        }

        return true;
    }
}