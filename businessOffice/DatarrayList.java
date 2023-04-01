package businessOffice;

/* This DatarrayList class is used to create a new DatarrayList object and use
 * various methods to help store objects. This class has 3 private fields: 
 * objects, increment, and objectCount. The array objects is the array that is
 * used to store the objects. Each DatarrayList object also has an increment 
 * that acts as an initial cap for the size of the array of objects, and is also
 * the number that the size of the array is increased by when it gets full. And 
 * finally the objectCount field is there to help keep track the amount of 
 * objects are in the array. There are a total of 6 methods and 2 of those 6 
 * are constructors.
 */

public class DatarrayList {
   private Object[] objects;
   private int increment;
   private int objectCount = 0;

   /* This constructor creates a new DatarrayList object with the parameter of 
    * the integer increment. The constructor first checks if increment is 
    * greater than or equal to 0. If so, then it sets the objects field equal to
    * a new Objects array with size passed in. If not, then the constructor will
    * make the size of the array 1. Finally increment is set to the value that
    * was passed in.
    */
  public DatarrayList(int increment) {
   if (increment >= 0) {
      objects = new Object[increment];
   } else {
      objects = new Object[1];
   }
   this.increment = increment;
  }

  /* This is the second constructor that sets the objects array size to 1 and 
   * increment to 1.
   */
  public DatarrayList() {
   objects = new Object[1];
   increment = 1;
  }

  /* This add method returns a boolean and attempts to add the object passed in.
   * First, the method checks if the size of the objects array needs to be 
   * increased or not. If it does then the process happens, otherwise nothing
   * happens and the code continues. Next, if the object isn't null then the 
   * method will iterate through the array to find the next "empty" (null) spot
   * and add it to the array. It also increases the objectCount by 1 if added, 
   * and true is returned. If the newElement object is null then the method 
   * will return false and do nothing.
   */
  
  public boolean add(Object newElement) {
     if (objects.length == objectCount) {
        Object[] temp = new Object[objects.length + increment];
        
        for (int k = 0; k < objectCount; k++) {
           temp[k] = objects[k];
        }
        objects = temp;
     }
    if (newElement != null) {
       for (int i = objectCount; i < objects.length; i++) {
          if (objects[i] == null) {
             objects[i] = newElement;
             objectCount++;
             return true;
          }
       }
    }
    return false;
  }

  // This method is used to return the number of objects in the objects array
  public int getSize() {
    return objectCount;
  }

  // This method returns the capacity of the objects array
  public int getCapacity() {
    return objects.length;
  }

  /* This method returns the object that is at the position that is passed in.
   * It checks if the position requested is in the range of the capacity 
   * [0,capacity). If it's not in the range then the method will return null,
   * otherwise the object at the position is returned.
   */
  public Object get(int pos) {
    if ((pos < 0) || (pos >= objects.length)) {
       return null;
    } else {
       return objects[pos];
    }
  }
}
