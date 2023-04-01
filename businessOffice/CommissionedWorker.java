package businessOffice;

/* This class was created by me and is a subclass of the super class Worker.
 * Since the Worker class was abstract and had 5 abstract methods, there was 5
 * methods need to be overrided in this class. This CommissionedWorker class has
 * 2 fields: sales and commissionRate. The field sales keeps track of the number 
 * of sales of that worker and commissionRate represents their commission rate.
 */
public class CommissionedWorker extends Worker {
   private double sales;
   private double commissionRate;

   /* This constructor first calls on the super constructor which sets the name
    * to the current object and hours to 0. Then it will set commissionRate
    * equal to the parameter.
    */
   public CommissionedWorker(String name, double commissionRate) {
      super(name);
      this.commissionRate = commissionRate;
   }
   
   // This method adds the sales to the total amount of sales of the worker.
   @Override
   public void addSale(double saleAmt) {
      this.sales += saleAmt;
   }
   
   /* Returns the pay of the worker, which is the number of sales times the 
    * commission rate.
    */
   @Override
   public double getPay() {
      return (sales * commissionRate) * 0.01;
   }
   
   // This method adds the hours to the total amount of hours of the worker.
   @Override
   public boolean addHours(int hours) {
      this.hours += hours;
      return true;
   }

   //This resets the hours and sales for the worker, indicating a new pay period
   @Override
   public void newPay() {
      this.sales = 0;
      this.hours = 0;
   }
   
   //This method returns the number of sales the worker has.
   @Override
   public double getSale() {
      return sales;
   } 
}
