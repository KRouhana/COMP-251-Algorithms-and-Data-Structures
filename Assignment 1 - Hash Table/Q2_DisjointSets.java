import java.io.*;
import java.util.*;


public class Q2_DisjointSets {

    private int[] par;
    private int[] rank;
    
    /* contructor: creates a partition of n elements. */
    /* Each element is in a separate disjoint set */
    Q2_DisjointSets(int n) {
        if (n>0) {
            par = new int[n];
            rank = new int[n];
            for (int i=0; i<this.par.length; i++) {
                par[i] = i;
            }
        }
    }
    
    public String toString(){
        int pari,countsets=0;
        String output = "";
        String[] setstrings = new String[this.par.length];
        /* build string for each set */
        for (int i=0; i<this.par.length; i++) {
            pari = find(i);
            if (setstrings[pari]==null) {
                setstrings[pari] = String.valueOf(i);
                countsets+=1;
            } else {
                setstrings[pari] += "," + i;
            }
        }
        /* print strings */
        output = countsets + " set(s):\n";
        for (int i=0; i<this.par.length; i++) {
            if (setstrings[i] != null) {
                output += i + " : " + setstrings[i] + "\n";
            }
        }
        return output;
    }
    
    /* find resentative of element i */
    public int find(int i) {

        if(par[i] == i) return i;

        else{
            par[i] = find(par[i]);
            return par[i];
        }
    }

    /* merge sets containing elements i and j */
    public int union(int i, int j) {

        int newRep = 0;

        //If rank of the representative of i is less than the rank of the representative of j (merge i into j)
        if(rank[find(i)] < rank[find(j)]){

            //Get the new representative for the union
            newRep = find(j);
            //Set the parent of the representative of i the new representative
            par[find(i)] = newRep;

        }

        //If rank of the representative of i is greater than the rank of the representative of j (merge j into i)
        else if(rank[find(i)] > rank[find(j)]){

            //Get the new representative for the union
            newRep = find(i);
            //Set the parent of the representative of j the new representative
            par[find(j)] = newRep;

        }
        //If the rank of the representative of i is equal to the rank of the representative of j (merge i into j)
        else{
            //Check if it's the same partition, if not, proceed
            if(find(i) != find(j)){

                //Get the new representative for the union
                newRep = find(j);

                //Set the parent of the representative of i to the new representative
                par[find(i)] = newRep;

                //Increment the rank of the j since the rank are the same
                rank[newRep]++;
            }
        }
        //Return the new representative of the joint set
        return newRep;
        
    }
    
    public static void main(String[] args) {
        
        Q2_DisjointSets myset = new Q2_DisjointSets(6);
        System.out.println(myset);
        System.out.println("-> Union 2 and 3");
        myset.union(2,3);
        System.out.println(myset);
        System.out.println("-> Union 2 and 3");
        myset.union(2,3);
        System.out.println(myset);
        System.out.println("-> Union 2 and 1");
        myset.union(2,1);
        System.out.println(myset);
        System.out.println("-> Union 4 and 5");
        myset.union(4,5);
        System.out.println(myset);
        System.out.println("-> Union 3 and 1");
        myset.union(3,1);
        System.out.println(myset);
        System.out.println("-> Union 2 and 4");
        myset.union(2,4);
        System.out.println(myset);
        
    }

}
