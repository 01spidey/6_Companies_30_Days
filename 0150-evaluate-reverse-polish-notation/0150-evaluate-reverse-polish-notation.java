class Solution {

    public int eval(int a, int b, String op){
        int out = 0;
        switch(op){
            case "+":
                out = a+b;
                break;

            case "-":
                out =  b-a;
                break;

            case "*":
                out =  a*b;
                break;
            
            case "/":
                out =  b/a;
                break;
        }
        return out;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int a = 0, b = 0;
        for(String str : tokens){
            if(str.matches("[+*/-]")){
                a = stk.pop();
                b = stk.pop();
                stk.push(eval(a, b , str));
            }
            else{
                stk.push(Integer.parseInt(str));
            }
        }
        
        
        return stk.pop();


    }
}