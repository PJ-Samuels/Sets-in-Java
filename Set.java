/*
* Student First Name:
* Student Last Name:
* Student BU Number:
* Purpose: 
*/
import java.util.*;

public class Set  {
    private static final int SIZE = 10; // default size of initial set
                               
    private int[] set;      // array referece to the set
    private int size;    // current size of the set
    private int next;       // index to next available slot in the set array
   
   
    public Set() {
        this.set = new int[0];
        this.size = 0;
        this.next = 0;
    }
   
    public Set(int[] A) {
        this.set = new int[A.length];
        for(int i = 0; i < A.length; i++)
        {
            set[i] = A[i];
        }
        this.size = A.length;
        this.next = A.length;
        
    }
   
    public Set clone() {
        return new Set(this.set);
       //return this;      // just to get it to compile; replace this with something appropriate   
    }
    public boolean contains(int[] arr, int k)
    {
        for(int i = 0; i < arr.length; i++ )
        {
            if(arr[i] == k)
                return true;
        }
        return false;
    }
   
   // This method reallocates the array set to twice as big and copies all the elements over.
   // It is called only by insert.
   //
   // Note that this is the reason that in this class
   // the member size is not a class variable (i.e. static)
   // and it is not final, because the set can grow and size
   // will be modified accordingly.
   
    private void resize() {
        if(size == 0 )
        {
            size += 1;
        }
        size +=1;
        int[] temp = new int[size];
        for(int i = 0; i < set.length; i++) {
            temp[i] = set[i];
        }
        set = temp;
    }
       
    public  String toString()  {
        if(set.length == 0)
            return "[]";
        String ans = "[";
        for(int i = 0; i < set.length; i++)  
        {
            ans += set[i];
            if(i == this.set.length-1)
                ans += "";
            else
                ans +=",";
        }
        ans += "]";
        return ans;
    //return null;   // just to get it to compile; replace null with something appropriate    
   } 
    
    public int cardinality() {
        return this.next;
       //return 0;   // just to get it to compile; replace 0 with something appropriate    
   }
   
    public  boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;       // your code here
       //return false;   // just to get it to compile; replace false with something appropriate   
   }
     
    public boolean member(int k) {   
        for(int i = 0; i < set.length; i++)
        {
            if( set[i] == k)
                return true;
        }
        return false;
   }    
  
    public  boolean subset(Set T) {//change to account for varying sizes
        int[] temp1 = this.set;
        int[] temp2 = T.set;

        if( (temp1 == null && temp2 != null) || (temp1 != null && temp2 == null))
            return false;
        if( (temp1.length == 0 && temp2.length != 0) || (temp1.length != 0 && temp2.length == 0))
            return true;
        if( temp1.equals(temp2))
            return true;
        if(temp1.length > temp2.length)
            return false;
        
        boolean ans = false;
        for(int i = 0; i < temp2.length; i++)//wrong length
        {
            System.out.println(temp2[i]);
            if(contains(temp1,temp2[i]))
            {
                ans = true; 
            }
            else
            {
                ans = false;
                break;
            }
        }
        return ans;
   }
   
    public  boolean equal(Set T) {
        if(T.size == this.size && subset(T)== true)
            return true;
        return false;  
    }
      
    public void insert(int k) {
        if(next >= size)
             resize();
        if(!(contains(this.set, k))){
            this.set[next] = k;
            next++;
        }
    }
   
    public void delete(int k) {

        int[] arr = this.set; 
        if(false == contains(arr,k))
            System.out.println("");
        else
        {
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i] == k){
              // shifting elements
                for(int j = i; j < arr.length - 1; j++){
                      arr[j] = arr[j+1];
                }
                break;
                }
            }
            if( arr.length != 0){
                int[] temp = new int[arr.length-1];
                for( int i = 0; i < arr.length-1; i ++)
                    temp[i] = arr[i];
                this.set = temp;
            }
        }
       
    }
 
    public Set union(Set T) {
       boolean ans = false;
        if( T.set.length == this.set.length)
        {
            for( int i = 0; i < T.set.length; i++)
            {
                if(contains(this.set, T.set[i]))
                    ans = true;
                else{
                    ans = false;
                    break;
                }
            }
        }
        if(ans == true )  
            return T;  
       Set temp = clone();
       for(int i = 0; i <temp.set.length;i++)
       {
           T.insert(temp.set[i]);
       }
       return T;
    }
  
    public Set intersection(Set T) {
        int len;
        Set empt = new Set();
        if(this.size < T.size){
            len = this.size;
            for( int i = 0; i < len; i++)
            {
                
                if(contains(T.set,this.set[i]))
                    empt.insert(this.set[i]);
            }
        }
        else
        {
            len = T.size;
            for( int i = 0; i < len; i++)
            {
                if(contains(T.set,this.set[i]))
                    empt.insert(this.set[i]);
            }        
        }
        return empt;
   }
   
   public Set setdifference(Set T) {
        int len;
        Set empt = new Set();
        if(this.size > T.size){
            len = this.size;
            for( int i = 0; i < len; i++)
            {
                if(false == contains(T.set,this.set[i]))
                    empt.insert(this.set[i]);
                    
            }
        }
        else if( this.size < T.size)
        {
            System.out.println("hit");
            len = this.size;
            for( int i = 0; i < len; i++)
            {
                if(false == contains(T.set,this.set[i]))
                    empt.insert(this.set[i]);
                System.out.println(this.set[i]);
                
            }        
        }
        
        return empt;
   }
     
}