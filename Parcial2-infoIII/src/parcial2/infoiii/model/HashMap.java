package parcial2.infoiii.model;

import static java.lang.Math.pow;

public class HashMap <K,T extends Comparable>{

   private AVLTree<T> table[];
   private int size;

    public HashMap(int size){
        this.size = size;
        table = new AVLTree[size];
    }

    public boolean put(String key,Email m,int i,Boolean sub) throws Exception {
        int pos = inRange(key);
        ContenedorMail cm = new ContenedorMail();
        cm.setEmail(m);
        cm.setPos(i);
        cm.setSubject(sub);
        cm.setKey(key);
        
        if (table[pos] == null){
            table[pos] = new AVLTree<>();
            table[pos].insertByWord(cm);
            return true;
        }
        else{
            table[pos].insertByWord(cm);
        }
        
        return false;
    }
    
    public void splitString(String query, Email m,Boolean sub) throws Exception{
        
        String[] splited = query.split("\\s+");
        for(int i = 0; i < splited.length; i++){
            put(splited[i],m,i,sub);
        }
    }

    public Lista getByQuery(String query) throws Exception {
        
        String[] splited = query.split("\\s+");            
        int pos = inRange(splited[0]);
        if(table[pos] == null){
            throw new Exception("No se encontró");
        }
        else{
             return table[pos].getByQuery(splited);
        }
    }

    public double hash(String key){
        
        double n = 0, x = 0;
        for(int i = 0; i < key.length(); i++){
            n = (int) key.charAt(i);
            x += n*(pow(2,key.length() - i));
        }
        return x;
    }

    public int inRange(String key){
        return (int) (hash(key) % size);
    }

    public boolean remove(String key){
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
