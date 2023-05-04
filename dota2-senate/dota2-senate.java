class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>(), d = new LinkedList<>();
        
        int n = senate.length();
        for(int i = 0; i< n; i++){
            if (senate.charAt(i) == 'R')  r.offer(i);
            else d.offer(i);
        }

        while(!r.isEmpty() && !d.isEmpty()){
            if(r.peek() > d.peek()){
                r.poll(); d.offer(d.poll()+n);
            }else{
                d.poll(); r.offer(r.poll()+n);
            }
        }

        if(!r.isEmpty()){
            return "Radiant";
        }else{
            return "Dire";
        }

    }
}