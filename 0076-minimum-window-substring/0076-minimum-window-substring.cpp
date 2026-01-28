class Solution {
public:
    string minWindow(string s, string t) {
        int left = 0;
        int right = 0;
        int stIdx = 0;
        int len = 1e7;
        int neededChar = t.size();
        unordered_map<char, int> mp;
        for(int i=0; i<t.size(); i++){
            mp[t[i]] += 1;
        }

        while(right < s.size()){
            if(mp[s[right]] > 0) neededChar -= 1;
            mp[s[right]] -= 1;

            while(neededChar == 0){
                if(right - left + 1 < len){
                    len = right - left + 1;
                    stIdx = left;
                }

                mp[s[left]] += 1;
                if(mp[s[left]] > 0) neededChar += 1;
                left++;
            }
            right++;
        }

        if(len == 1e7){
            return "";
        }else{
            return s.substr(stIdx, len);
        }
    }
};