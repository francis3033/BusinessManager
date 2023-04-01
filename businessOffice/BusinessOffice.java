package businessOffice;

/* This class is just to create a new account depending if the business wanted 
 * a freePlan or a paidPlan. The only methods it contains are two overloaded
 * static constructors. This class also has no fields.
 */
public class BusinessOffice {
  
   /* This constructor represents the paid plan because there's no parameter for
    * a maximum amount of employees. If name is empty or null then null will be
    * returned. Otherwise, a new account object will be created with the
    * parameter and return that account.
    */
  public static Account createAccount(String name) {
    if ((name.isEmpty()) || (name == null)) {
       return null; 
    } else {
       Account account = new Account(name);
       return account;
    }
  }

  /* This constructor represents the free plan because there's a max amount of
   * employees this account can have. If name is empty or null then or if 
   * the max employees requested was less than 1, then null would be returned. 
   * Otherwise a new free plan account will be made with the parameters and 
   * returned.
   */
  public static Account createAccount(String name, int maxEmployees) {
   if ((name.isEmpty()) || (name == null) || (maxEmployees < 1)) {
      return null;
   } else {
      Account account = new Account(name, maxEmployees);
      return account;
   }
  }

}
