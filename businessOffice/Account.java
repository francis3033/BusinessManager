package businessOffice;
/* This Account class has 4 private fields and is used to keep track of all of
 * the workers working for the company. The first field name is used to keep 
 * track of the name of the company. The next field maxEmployees is the max 
 * number of employees a company can hold in their system if they have a 
 * free plan. The next field employeesList is a DatarrayList object that keeps 
 * of the employees in the system. And lastly, the boolean freePlan field is 
 * used to keep track if a company has the paid plan or the free plan.
 */
public class Account {
   private String name;
   private int maxEmployees;
   private DatarrayList employeesList;
   private boolean freePlan;

   /* This first constructor sets the name of the current company to the String
    * that was passed in. Sets employeesList into a new DatarrayList object and
    * sets freePlan equal to false because this constructor is used for the 
    * paid plan.
    */
   public Account(String name) {
      this.name = name;
      employeesList = new DatarrayList();
      freePlan = false;
   }

   /* This second constructor sets the name of the current company to the String
    * that was passed in. Sets maxEmployees to what was passed in the parameter.
    * Then creates a new DatarrayList object with a capacity of maxEmployees. 
    * And finally set freePlan to true because this constructor is used for the 
    * free plan.
    */
   public Account(String name, int maxEmployees) {
      this.name = name;
      this.maxEmployees = maxEmployees;
      employeesList = new DatarrayList(maxEmployees);
      freePlan = true;
   }

   // Returns the name of the company with the current account
   public String getAccountName() {
      return name;
   }

   /* This method creates and adds a CommissionedWorker object and adds it to 
    * the list of employees if it passes the special conditions that are 
    * detailed in the private hireCommissionedCheck method. If the values 
    * passed in don't meet the requirements, then nothing happens and false is
    * returned. Otherwise a new CommissonedWorker object is created and added 
    * to the employeesList and true is returned.
    */
   public boolean hireCommissionedWorker(String name, double commissionRate) {
      if (!(hireCommissionedCheck(name, commissionRate))) {
         return false;
      } else {
         CommissionedWorker cw = new CommissionedWorker(name, commissionRate);
         employeesList.add(cw);
         return true;
      }
   }

   /* Added myself
    * This private method is here to check the conditions for adding a new 
    * CommissionedWorker in the employeesList. First the name passed in is 
    * checked to see if it's null or empty, it also checks if the commissionRate
    * is in the range of (0,100]. Next it checks if the account is at 
    * maxEmployees or not. And lastly checks if the person that's trying to be 
    * added is already in the list or not. If the parameters don't meet any one 
    * of these conditions, then false is returned. And the parameters pass all 
    * of the conditions, then true is returned.
    */
   
   private boolean hireCommissionedCheck(String name, double commissionRate) {
      if ((name == null) || (name.isEmpty()) || 
            ((commissionRate <= 0.0) && (commissionRate > 100))) {
         return false;
      } else if (freePlan && (employeesList.getSize() >= maxEmployees)) {
         return false;
      } else if (isEmployee(name)) {
         return false;
      } else {
         return true;
      }
   }

   /* This method creates and adds a SalariedWorker object and adds it to 
    * the list of employees if it passes the special conditions that are 
    * detailed in the private hireSalariedCheck method. If the values 
    * passed in don't meet the requirements, then nothing happens and false is
    * returned. Otherwise a new SalariedWorker object is created and added 
    * to the employeesList and true is returned.
    */
   public boolean hireSalariedWorker(String name, double yearlySalary) {
      if (!(hireSalariedCheck(name, yearlySalary))) {
         return false;
      } else {
         SalariedWorker sw = new SalariedWorker(name, yearlySalary);
         employeesList.add(sw);
         return true;
      }
   }

   /* Added myself
    * This private method is here to check the conditions for adding a new 
    * SalariedWorker in the employeesList. First the name passed in is 
    * checked to see if it's null or empty, it also checks if the yearlySalary
    * is strictly greater than 0. Next it checks if the account is at 
    * maxEmployees or not. And lastly checks if the person that's trying to be 
    * added is already in the list or not. If the parameters don't meet any one 
    * of these conditions, then false is returned. And the parameters pass all 
    * of the conditions, then true is returned.
    */
   private boolean hireSalariedCheck(String name, double yearlySalary) {
      if ((name == null) || (name.isEmpty()) || (yearlySalary <= 0.0)) {
         return false;
      } else if (freePlan && (employeesList.getSize() >= maxEmployees)) {
         return false;
      } else if (isEmployee(name)) {
         return false;
      } else {
         return true;
      }
   }

   /* This method checks if the name given is in the list of employees or not. 
    * It iterates through the employees and checks if the name passed in is the 
    * same as the workers being checked. If the names match up, then true is 
    * returned, otherwise false will be returned.
    */
   public boolean isEmployee(String name) {
      for (int i = 0; i < employeesList.getSize(); i++) {
         if (((Worker) employeesList.get(i)).isName(name)) {
            return true;
         }
      }
      return false;
   }

   // This method returns the number of employees in the list.
   public int numEmployees() {
      return employeesList.getSize();
   }

   /* This method returns the employee limit if the current account is a free
    * plan account. Otherwise the max integer value is returned because a paid 
    * account can add as many employees to the account as possible.
    */
   public int employeeLimit() {
      if (freePlan) {
         return maxEmployees;
      } else {
         return Integer.MAX_VALUE;
      }
   }

   /* Added myself
    * This private method is here to check the conditions for adding hours to a 
    * specified employee. First the name passed in is checked to see if it's 
    * null or empty, it also checks if the number of hours is strictly greater 
    * than 0. Next it checks if the person that's trying to add hours is an 
    * employee. If the parameters don't meet any one of these conditions, then
    * false is returned. And the parameters pass all of the conditions, then
    * true is returned.
    */
   private boolean workHoursCheck(String name, int numHours) {
      if ((name == null) || (name.isEmpty()) || (numHours <= 0)) {
         return false;
      } else if (!isEmployee(name)) {
         return false;
      } else {
         return true;
      }
   }

   /* This method adds hours to the specified worker if the conditions with the
    * parameters are met. The method will iterate through the list of 
    * employees until the match is found the the hours are added. Finally if the 
    * process runs smoothly then the hours will be added and true will be
    * returned. Otherwise, false is returned.
    */
   public boolean workHours(String name, int numHours) {
      if (!(workHoursCheck(name, numHours))) {
         return false;
      } else {
         for (int i = 0; i < employeesList.getSize(); i++) {
            if (((Worker) employeesList.get(i)).isName(name)) {
               return ((Worker) employeesList.get(i)).addHours(numHours);
            }
         }
         return false;
      }
   }

   /* This method returns the number of hours the worker has. It first checks if
    * the name is null or empty, it also checks if the person isn't an employee 
    * in the system. If any of these conditions aren't met, then -1 will be 
    * returned. Otherwise the code will continue and find the specific worker 
    * and return their hours.
    */
   public int numHours(String name) {
      if (name.isEmpty() || name == null || !(isEmployee(name))) {
         return -1;
      }
      for (int i = 0; i < employeesList.getSize(); i++) {
         if (((Worker) employeesList.get(i)).isName(name)) {
            return ((Worker)employeesList.get(i)).getHours();
         }
      }
      return -1;
   }

   /* Added myself
    * This private method is here to check the conditions for adding a sale to a 
    * specified employee. First the name passed in is checked to see if it's 
    * null or empty, it also checks if the number of sales is strictly greater 
    * than 0. Next it checks if the person that's trying to add hours is an 
    * employee. If the parameters don't meet any one of these conditions, then
    * false is returned. And the parameters pass all of the conditions, then
    * true is returned.
    */
   private boolean makeSaleCheck(String name, double saleAmt) {
      if ((name == null) || (name.isEmpty()) || (saleAmt <= 0.0)) {
         return false;
      } else if (!isEmployee(name)) {
         return false;
      } else {
         return true;
      }
   }

   /* This method adds a sale amount to a specified worker. First the method 
    * will check the specified conditions in the makeSaleCheck method. If those
    * conditions are met with the parameters then the method will continue to 
    * iterate through the employees to match the right name. Next it will add 
    * the sales to the specified employee and return true.
    */
   public boolean makeSale(String name, double saleAmt) {
      if (!makeSaleCheck(name, saleAmt)) {
         return false;
      } else {
         for (int i = 0; i < employeesList.getSize(); i++) {
            if (((Worker) employeesList.get(i)).isName(name)) {
                  ((Worker) employeesList.get(i)).addSale(saleAmt);
                  return true;
               }
            }
         }
      return false;
   }

   /* This method returns the amount of sales made by the specified employee. If 
    * the name is empty or null or the employee isn't a part of the company then
    *  the method will return -1. Otherwise the method will go through the list
    *  of employees and return the sale from that employee.
    */
   public double amtSalesMade(String name) {
      if (name.isEmpty() || name == null || !(isEmployee(name))) {
         return -1.0;
      }
      for (int i = 0; i < employeesList.getSize(); i++) {
         if (((Worker) employeesList.get(i)).isName(name)) {
               return ((CommissionedWorker) employeesList.get(i)).getSale();
         }
      }
      return -1.0;
   }

   /* This method returns the amount of pay that the specified employee should 
    * be receiving. If the name is empty or null or the employee isn't a part of
    * the company then the method will return -1. Otherwise the method will go
    * through the list of employees and return the pay from that employee.
    */
   public double getPayAmount(String name) {
      if (name.isEmpty() || name == null || !(isEmployee(name))) {
         return -1.0;
      }
      for (int i = 0; i < employeesList.getSize(); i++) {
         if (((Worker) employeesList.get(i)).isName(name)) {
            return ((Worker) employeesList.get(i)).getPay();
         }
      }
      return -1.0;
   }

   /* This method gathers all the pay from all the employees and returns the 
    * total payroll for the company.
    */
   public double getPayroll() {
      double payroll = 0.0;
      for (int i = 0; i < employeesList.getSize(); i++) {
         payroll += ((Worker) employeesList.get(i)).getPay();
      }
      return payroll;
   }

   /* This method resets all of the employees hours and sales to start a new pay
   period.
   */
   public void newPayPeriod() {
      for (int i = 0; i < employeesList.getSize(); i++) {
         ((Worker) employeesList.get(i)).newPay();
      }
   }

   /* This method either will return 0 if the company has a the free plan or
    * return the price for the paid plan.
    */
   public double billAmount() {
      if (freePlan) {
         return 0.0;
      } else {
         return (10.0 * employeesList.getSize());
      }
   }

}
