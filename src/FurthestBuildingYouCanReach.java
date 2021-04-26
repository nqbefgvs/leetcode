import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

//    class Node{
//        int val;
//        Node next;
//        int size;
//        int filled;
//
//        Node(){}
//
//        Node(int val){
//            this.val = val;
//        }
//
//        Node(int val, Node next){
//            this.val = val;
//            this.next = next;
//        }
//
//        Node(int size, int filled){
//            this.size = size;
//            this.filled = filled;
//        }
//
//        void insert(int val){
//            if(next == null || val <= next.val){
//                Node node = new Node(val, next);
//                next = node;
//            }
//            else{
//                next.insert(val);
//            }
//            filled++;
//        }
//
//        int delete(){
//            Node n = next;
//            next = n.next;
//            filled--;
//            return n.val;
//        }
//
//        boolean hasElement(){
//            return next != null;
//        }
//
//        boolean isFull(){
//            return filled >= size;
//        }
//    }
//
//    public int furthestBuilding(int[] heights, int bricks, int ladders) {
//        Node head = new Node(ladders, 0);
//        for(int i = 0; i < heights.length - 1; i++){
//            int dis = heights[i+1] - heights[i];
//            if(dis > 0){
//                if(!head.isFull()){
//                    head.insert(dis);
//                }
//                else if(head.hasElement() && dis > head.next.val){
//                    bricks -= head.delete();
//                    head.insert(dis);
//                }
//                else{
//                    bricks -= dis;
//                }
//                if(bricks < 0){
//                    return i;
//                }
//            }
//        }
//        return heights.length - 1;
//    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++)
        {
            int diff = heights[i+1]-heights[i];
            if(diff>0){
                queue.add(diff);
                if(queue.size()>ladders)
                {
                    bricks-=queue.poll();
                    if(bricks<0) return i;
                }
            }
        }
        return heights.length-1;
    }

    public static void main(String[] args){
        new FurthestBuildingYouCanReach().furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2);
    }

}
