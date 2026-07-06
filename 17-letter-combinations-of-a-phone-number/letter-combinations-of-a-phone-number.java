class Solution {
    public List<String> letterCombinations(String digits) {
        return helper(digits);
    }

    public List<String> helper(String digits){
        List<String> ans = new ArrayList<>();      
        HashMap<Character , String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        solver(digits , ans , map , sb , 0);
        return ans;
    }

    public void solver(String digits , List<String> ans , HashMap<Character,String> map , StringBuilder sb , int i) {

        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }
        char c = digits.charAt(i);
        int len = map.get(c).length();

        for(int j = 0 ; j<len ; j++){

            sb.append(map.get(c).charAt(j));
            solver(digits , ans , map , sb , i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}