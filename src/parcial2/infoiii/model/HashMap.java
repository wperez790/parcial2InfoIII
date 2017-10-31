package parcial2.infoiii.model;

public class HashMap <K,T extends Comparable>{

   private AVLTree<T> table[];
   private int size;

    public HashMap(int size){
        this.size = size;
        table = new AVLTree[size];
    }

    public boolean put(K key,T dat) {
        int pos = inRange(key);
        if (table[pos] == null){
            table[pos] = new AVLTree<>();
            table[pos].insert(dat);
            return true;
        }
        return false;
    }

    public T get(K key) throws Exception {
        int pos = inRange(key);
        if(table[pos] == null){
            throw new Exception();
        }
        else{
            return table[pos].getDat();
        }

    }

    public int hash(K key){
        return Integer.parseInt(""+key);
    }

    public int inRange(K key){
        return hash(key) % size;
    }

    public boolean remove(K key){
        int pos = inRange(key);
        if(table[pos] == null){
            return false;
        }
        table[pos] = null;
        return true;

    }

    public boolean isEmpty(){
        for (int i = 0; i < size; i++){
            if(table[i] != null){
                return false;
            }
        }
        return true;
    }

    public int esVacia(){
        int cont = 0;
        for (int i = 0; i < size; i++){
            if(table[i] != null)
                cont++;
        }
        return cont;
    }
}
