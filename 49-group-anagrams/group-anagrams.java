class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        HashMap<String , List<String> > map = new HashMap<>();

        for(int i = 0 ; i<strs.length ; i++){

            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String hold = new String(s);
            if(map.containsKey(hold)){
                map.get(hold).add(strs[i]);
            }
            else{
                map.put(hold , new ArrayList());
                map.get(hold).add(strs[i]);
            }
        }

        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            ans.add(entry.getValue());
        }



        if (ans.size()<1){
            ans.add(new ArrayList());
            ans.get(0).add("");
        } 

        return ans;
    }
}