class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>map = new HashMap<>();

        for(int i = 0 ; i <t.length() ; i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        int count = map.size();
        int min = Integer.MAX_VALUE;

        while(j<s.length()){
            char c = s.charAt(j);

            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    count--;
                }
            } 

            if(count == 0 ){
                while (i <= j && count == 0) {
                    if (min > j - i + 1) {
                        min = j - i + 1;
                        start = i;
                        end = j + 1;
                    }
                    char cc = s.charAt(i);
                    if (map.containsKey(cc)){
                        map.put(cc, map.get(cc) + 1);
                            if (map.get(cc) == 1) {
                                count++;
                            }
                    }
                    i++;
                }
            }

            j++;
        }
    return s.substring(start,end);
    }
}


