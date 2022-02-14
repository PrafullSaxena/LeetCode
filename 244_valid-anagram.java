class Solution {
    public boolean isAnagram(String s, String t) {
        // return BruteForce(s, t);
        return withSpace(s, t);
    }
    
    public static boolean withSpace(String s, String t){
        
        if(s.length() != t.length()) return false;

        Map<Character, Integer> target = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            if(target.containsKey(t.charAt(i))){
                int occurence = target.get(t.charAt(i));
                target.put(t.charAt(i), occurence + 1);
            }else {
                target.put(t.charAt(i), 1);
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(target.containsKey(s.charAt(i))){
                int occurence = target.get(s.charAt(i));
                occurence = occurence - 1;
                if(occurence == 0){
                    target.remove(s.charAt(i));
                }else {
                    target.put(s.charAt(i), occurence);
                }
                
            }else{
                return false;
            }
        }

        return true;
    }
    
    public boolean BruteForce(String s, String t) {
        if(s.length() != t.length()) return false;

        List<Character> target = new ArrayList();
        for(int i = 0; i<t.length(); i++){
            target.add(t.charAt(i));
        }

        for(int i = 0; i<s.length(); i++){
            boolean isFound = false;
            for(int j = 0; j<target.size(); j++){
                if(s.charAt(i) == target.get(j)){
                    isFound = true;
                    target.set(j, ' ');
                    break;
                }
            }

            if(!isFound) return false;

        }
        return true;
    }
}
