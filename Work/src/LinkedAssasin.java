import java.util.NoSuchElementException;

public class LinkedAssasin {
    private AssasinNode front;

    public LinkedAssasin(){
        front = null;
    }

    public LinkedAssasin(AssasinNode front){
        this.front = front;
    }
    public void maintainLink(){
        AssasinNode cur = front;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = front;
    }
    public void add(String value){
        if(front == null){
            front = new AssasinNode(value);
        }else{
            AssasinNode cur = front;
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = new AssasinNode(value);


        }

        //maintainLink();
    }
    public int size(){
        int size = 0;
        AssasinNode cur = front;
        while(cur.next!=null){
            cur = cur.next;
            size++;
        }
        return size + 1;
    }

    public String remove(){
        if(front == null){
            throw new NoSuchElementException();
        }
        String result = front.name;
        AssasinNode newLink = front.next;
        front = newLink;
        return result;
    }

    public String remove(String name){
        int index = findIndex(name);
        if(index == -1){
           return "Invalid Name";
        }
        if(index == 0){
            //maintainLink();
            return remove();
        }else{
            AssasinNode cur = front;
            for(int i = 0; i < index - 1; i++){
                cur = cur.next;
            }
            if(cur.next == null || index < 0){
                throw new NoSuchElementException();
            }
            String i = cur.next.name;
            cur.next = cur.next.next;
            //maintainLink();
            return i;
        }
    }

    public int findIndex(String name){
        boolean isPresent = false;
        int ind = 0;
        if(front.name.equals(name)){
            return 0;
        }
        AssasinNode cur = front;
        while(cur.next!=null){
            cur = cur.next;
            ind++;
            if(cur.name.equals(name)){
                isPresent = true;
                break;
            }
        }
        if(!isPresent){
            return -1;
        }
        return ind;
    }

    public AssasinNode getFront(){
        return front;
    }

    public class AssasinNode{
        String name;
        AssasinNode next;

        public AssasinNode(String name){
            this.name = name;
            this.next = null;
        }

    }
}

