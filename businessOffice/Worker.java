package businessOffice;

/* This is a super abstract class name Worker that has two fields and has 8 
 * methods, 5 of them being abstract. The fields name and hours represent that
 * all Worker objects will have a name and a number of hours.
 */
public abstract class Worker {
   protected String name;
   protected int hours;

   // This is a constructor that sets name to the parameter and hours to 0.
   public Worker(String name) {
      this.name = name;
      hours = 0;
   }
   
   // This method checks if a name matches up with the current Worker name.
   public boolean isName(String name) {
      return this.name.equals(name);
   }
   
   // Returns the number of hours of the current Worker.
   public int getHours() {
      return hours;
   }
   
   // Abstract class
   public abstract boolean addHours(int hours);
 
   // Abstract class
   public abstract void newPay();
 
   // Abstract class
   public abstract double getPay();
   
   // Abstract class
   public abstract double getSale();
   
   // Abstract class
   public abstract void addSale(double saleAmt);
}
