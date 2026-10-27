import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(10));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder stack=new StringBuilder();
        backtrack(0,0,n,stack,res);
        return res;
    }
    public static void backtrack(int open,int close,int n,StringBuilder stack,List<String> res){
        if(open==close && open==n){
            res.add(stack.toString());
            return;
        }
        if(open<n){
            stack.append('(');
            backtrack(open+1, close, n, stack, res);
            stack.deleteCharAt(stack.length()-1);
        }
        if(close<open){
            stack.append(')');
            backtrack(open, close+1, n, stack, res);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
