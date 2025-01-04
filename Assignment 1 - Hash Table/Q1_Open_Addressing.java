import java.io.*;
import java.util.*;

public class Q1_Open_Addressing {
    public int m; // number of SLOTS AVAILABLE
    public int A; // the default random number
    int w;
    int r;
    public int[] Table;

    protected Q1_Open_Addressing(int w, int seed, int A) {

        this.w = w;
        this.r = (int) (w-1)/2 +1;
        this.m = power2(r);
        if (A==-1){
            this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
        }
        else{
            this.A = A;
        }
        this.Table = new int[m];
        for (int i =0; i<m; i++) {
            Table[i] = -1;
        }

    }

    /** Calculate 2^w*/
    public static int power2(int w) {
        return (int) Math.pow(2, w);
    }
    public static int generateRandom(int min, int max, int seed) {
        Random generator = new Random();
        if(seed>=0){
            generator.setSeed(seed);
        }
        int i = generator.nextInt(max-min-1);
        return i+min+1;
    }
    /**Implements the hash function g(k)*/
    public int probe(int key, int i) {

        int h = ((this.A * key) % (int) power2(this.w)) >> (this.w - this.r);
        int g = (h + i) % (int) power2(this.r);

        return g;
    }


    /**Inserts key k into hash table. Returns the number of collisions encountered*/
    public int insertKey(int key){

        int collision = 0;
        int position;

        //While there are slots still available
        while(collision < m){

            //Calculate the position with the collision counter at each iteration
            position = probe(key,collision);

            //If the value at position calculated is not in use or was an old key that was deleted
            if(Table[position] == -1 || Table[position] == -2){

                //Set the value of the key at position calculated with the hash
                Table[position] = key;

                //We've successfully set a value in the table, hence stop the program
                return collision;
            }

            //The position calculated had an element in it
            else{
                //Increment the collision counter
                collision++;
                
            }
        }
        
        //Return the number of collision if the key was not found 
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

    /**Remove key k into hash table. Returns the number of collisions encountered*/
    public int removeKey(int key){

        //Set the collision counter to 0
        int collision = 0;
        //Calculate first possible position
        int position = probe(key,collision);

        //While there are slots still available
        while(collision < m ){

            //Empty slot, hence the key is not in my table; pre-ecrement the collision
            if(Table[position] == -1) return ++collision;
            
            //If the value at position calculated is the key
            if(Table[position] == key ){

                //Set a different value than deleted at position calculated with the hash where the old key was
                Table[position] = -2;

                //We've successfully removed the value in the table, hence stop the program
                return collision;
            }

            //The position calculated was not the key we want to delete
            else{
                //Increment the collision counter
                collision++;
            }

            //Calculate the position with the collision counter at each iteration
            position = probe(key,collision);
        }

        //Return the number of collision if the key was not found 
        return collision;
    }
}