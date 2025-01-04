import java.io.*;
import java.util.*;

public class Q1_Chaining {
    
     public int m; // number of SLOTS 
     public int A; // the default random number
     int w;
     int r;
     public ArrayList<ArrayList<Integer>>  Table;

    // if A==-1, then a random A is generated. else, input A is used.
    protected Q1_Chaining(int w, int seed, int A){
         this.w = w;
         this.r = (int) (w-1)/2 +1;
         this.m = power2(r);
         this.Table = new ArrayList<ArrayList<Integer>>(m);
         for (int i=0; i<m; i++) {
             Table.add(new ArrayList<Integer>());
         }
         if (A==-1){
         this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
        }
        else{
            this.A = A;
        }

     }
    /** Calculate 2^w*/
     public static int power2(int w) {
         return (int) Math.pow(2, w);
     }
     //generate a random number in a range (for A)
     public static int generateRandom(int min, int max, int seed) {     
         Random generator = new Random(); 
                 if(seed>=0){
                    generator.setSeed(seed);
                 }
         int i = generator.nextInt(max-min-1);
         return i+min+1;     
    }




    /**Implements the hash function h(k)*/
    public int chain (int key) {

        int h = ((this.A * key) % (int) power2(this.w)) >> (this.w - this.r);

        return h;
    }
        
    
    /**Inserts key k into hash table. Returns the number of collisions encountered*/
    public int insertKey(int key){

        int collision;
        //Calculate the position using the hash function implemented
        int position = chain(key);

        //Get the list at position calculated
        ArrayList<Integer> hashPositionList = Table.get(position);

        //If there's no element at the position calculated
        if (hashPositionList.isEmpty()) {

            //Since no element at position, hence there's no collision
            collision = 0;

            //Add the key to the front of that list (it's the first element)
            hashPositionList.add(key);
        }

        //There is a collision since the list at the position is not empty
        else {

            //Get the size of the list to retrieve the number of collision that will happen
            collision = hashPositionList.size();

            //Add the key to the end of the list
            hashPositionList.add(key);

        }

        //Return the number of collision
        return collision;

    }

    
    
    /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
    public int insertKeyArray (int[] keyArray){
        int collision = 0;
        for (int key: keyArray) {
            collision += insertKey(key);
        }
        return collision;
    }





}