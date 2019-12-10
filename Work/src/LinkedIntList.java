import java.util.NoSuchElementException;

public class LinkedIntList {
    private LinkNode front;

    public LinkedIntList(){
        front = null;
    }

    public LinkedIntList(LinkNode front){
        this.front = front;
    }

    public void set(int ind, int val){
        LinkNode cur = front;
        for(int i = 0; i < ind - 1; i++){
            cur = cur.next;
        }
        cur.value = val;
    }

    public int min(){
        if(front == null){
            throw  new NoSuchElementException();
        }
        int min = Integer.MAX_VALUE;
        LinkNode cur = front;
        while(cur.next!=null){
            cur = cur.next;
            if(cur.value < min){
                min = cur.value;
            }
        }
        return min;
    }

    public boolean isSorted(){
        boolean sorted = true;
        LinkNode cur = front;
        while(cur.next!=null){
            if(cur.value > cur.next.value){
                sorted = false;
                break;
            }
            cur = cur.next;
        }

        return sorted;
    }

    public int deleteBack(){
        LinkNode cur = front;
        while(cur.next.next!=null){
            cur = cur.next;
        }
       int val = cur.next.value;
        cur.next = null;

        return val;

    }

    public int lastIndexOf(int val){
        int lastOccur = -1;
        int curInd = 0;
        LinkNode cur = front;
        while(cur!=null){
            if(cur.value == val){
                lastOccur = curInd;
            }
            cur = cur.next;
            curInd++;
        }

        return lastOccur;
    }

    public void add(int value){
        if(front == null){
            front = new LinkNode(value);
        }else{
            LinkNode cur = front;
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = new LinkNode(value);


        }

    }

    public int size(){
        int size = 0;
        LinkNode cur = front;
        while(cur.next!=null){
            cur = cur.next;
            size++;
        }
        return size + 1;
    }

    public int remove(){
        if(front == null){
            throw new NoSuchElementException();
        }
        int result = front.value;
        LinkNode newLink = front.next;
        front = newLink;
        return result;
    }

    public int remove(int val){
        int index = findIndex(val);

        if(index == 0){
            //maintainLink();
            return remove();
        }else{
            LinkNode cur = front;
            for(int i = 0; i < index - 1; i++){
                cur = cur.next;
            }
            if(cur.next == null || index < 0){
                throw new NoSuchElementException();
            }
            int i = cur.next.value;
            cur.next = cur.next.next;
            //maintainLink();
            return i;
        }
    }

    public int findIndex(int val){
        boolean isPresent = false;
        int ind = 0;
        if(front.value == val){
            return 0;
        }
        LinkNode cur = front;
        while(cur.next!=null){
            cur = cur.next;
            ind++;
            if(cur.value == val){
                isPresent = true;
                break;
            }
        }
        if(!isPresent){
            return -1;
        }
        return ind;
    }

    public LinkNode getFront(){
        return front;
    }

    public class LinkNode{
        int value;
        LinkNode next;

        public LinkNode(int value){
            this.value = value;
            this.next = null;
        }

    }
}
