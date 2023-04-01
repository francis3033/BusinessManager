package businessOffice;

/* This class was created by me and is a subclass of the super class Worker.
 * Since the Worker class was abstract and had 5 abstract methods, there was 5
 * methods need to be overrided in this class. This SalariedWorker class has a 
 * field yearlySalary to keep track of the yearly salary of the current 
 * SalariedWorker object.
 */
public class SalariedWorker extends Worker {
   private double yearlySalary;

   /* This constructor first calls on the super constructor which sets the name
    * to the current object and hours to 0. Then it will set yearlySalary equal 
    * to the parameter.
    */
   public SalariedWorker(String name, double yearlySalary) {
      super(name);
      this.yearlySalary = yearlySalary;
   }

   /* This overriding method returns the pay of a SalariedWorker, which is 
    * this salary divided by 26 pay periods.
    */
   @Override
   public double getPay() {
      return (yearlySalary / 26.0);
   }
   
   /* This method adds hours to the SalariedWorker object only if the worker 
    * hasn't reached the max of 80 hours in a pay period already.
    */
   @Override
   public boolean addHours(int hours) {
      if ((this.hours + hours) > 80) {
         return false;
      }
      this.hours += hours;
      return true;
   }

   // This resets the hours for the worker, indicating a new pay period
   @Override
   public void newPay() {
      this.hours = 0;
   }

   /* This method returns 0 for a SalariedWorker because their sales don't
    *  affect their pay.
    */
   @Override
   public double getSale() {
      return 0.0;
   }

   // Does nothing because sales don't affect their pay
   @Override
   public void addSale(double saleAmt) {
      return;
   }
}
