package TreeExample;

public class MyList {
    Node head;
    Node tail;
    public MyList(){
        head=tail=null;
    }
    boolean Empty(){
       return head ==null;
    }
    void clear(){
        head=tail=null;
    }
    void addHead(int x){
        Node newNode= new Node(x);
//        if(Empty()){
//            this.head=this.tail = newNode;
//            return;
//        }
//        this.tail.next = newNode;
//        this.tail=newNode;
        newNode.next =head;
        head  = newNode;
    }
    void addTail(int x){

        Node lastnode =head;
        while (lastnode!=null){
            if(lastnode.next==null){
                Node newNode = new Node(x);
            lastnode.next = newNode;
            return; }
            lastnode =lastnode.next;

            }
        }
        void addPosition(int pos, int x){
        Node newNode = new Node(x);
        Node cur = head;
        int cout=0;
        if(pos==0){
            addHead(x);
        }
        while (cur!=null){
            if(cout==(pos-1)){
                newNode.next = cur.next;
                cur.next = newNode;
                return;
            }cout++;
            cur=cur.next;
        }
        if(cout==pos){
            addTail(x);
        }
        }

    void display(){
        System.out.println("list");
        Node cur = this.head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}
