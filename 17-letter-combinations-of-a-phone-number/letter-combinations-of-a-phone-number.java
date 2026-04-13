class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        StringBuilder sb = new StringBuilder();
        
        HashMap<Character , String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        
        create(map , result , sb , digits , 0);
        return result;

    }


    public void create(HashMap<Character , String> map , List<String> result , StringBuilder sb , String digits , int index){


        if(index == digits.length()){
            StringBuilder sb1 = new StringBuilder(sb);
            result.add(sb1.toString());
            return;
        }

        for(int i = 0 ; i < map.get(digits.charAt(index)).length() ; i++){
            sb.append(map.get(digits.charAt(index)).charAt(i));
            create(map , result , sb , digits , index+1);
            sb.deleteCharAt(sb.length() - 1);
        }

        return;
    }
}