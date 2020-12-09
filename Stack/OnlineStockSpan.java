package Stack;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan  {
        List<Integer> list = new ArrayList<>();
        public OnlineStockSpan() {
                    
        }
        public int next(int price) {
            list.add(price);
            int c=0;
            for(int i=list.size()-1;i>=0;i--){
                if(price<list.get(i)) {
                    break;   
                } 
                c++;
            }
            return c;
        }
public static void main(String[] args) {
    //https://leetcode.com/submissions/detail/341691294/
    OnlineStockSpan span = new OnlineStockSpan();
    span.next(100);
  }
    }

