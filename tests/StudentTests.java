package tests;

import businessOffice.Account;
import businessOffice.BusinessOffice;
import businessOffice.DatarrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

//These are my student tests to test the methods for the project.
public class StudentTests {
   
   //This method checks if my add method works the right way. (DatarrayList)
   @Test
   public void testDatarrayAdd() {
      DatarrayList list = new DatarrayList();
  
      assertTrue(list.add("String"));
      assertFalse(list.add(null));
   }
   
   //Tests my get methods for getting size and capacity. (DatarrayList)
   @Test
   public void testDatarrayGetSizeCapacity() {
      DatarrayList list = new DatarrayList(17);
      
      assertEquals(17, list.getCapacity());
      
      list.add("YES");
      list.add("NO");
      
      assertEquals(2, list.getSize());
   }
   
   //Test my get method to retrieve an object at the position. (DatarrayList)
   @Test
   public void testDatarrayGetPos() {
      DatarrayList list = new DatarrayList(17);
      
      list.add("YES");
      list.add("NO");
      
      assertEquals("NO", list.get(1));
   }
   
   // Tests if the method returns the right name to the account. (Account)
   @Test
   public void testAccountName() {
      Account account1 = BusinessOffice.createAccount("Not Free", 20);
      
      assertEquals("Not Free", account1.getAccountName());
   }
   
   /*Tests the hireCommissedWoker method and its conditions. This also tests my
    * hireSalariedWorker method because the codes are almost identical.
    * (Account)
    */
   @Test
   public void testHireWorker1() {
      Account account1 = BusinessOffice.createAccount("Not Free", 2);
      
      assertFalse(account1.hireCommissionedWorker(null, 30));
      assertFalse(account1.hireSalariedWorker("Francis", -3));
      
      account1.hireCommissionedWorker("Worker1", 2);
      assertFalse(account1.hireCommissionedWorker("Worker1", 40));
      
      account1.hireSalariedWorker("Worker2", 5);
      assertFalse(account1.hireCommissionedWorker("Worker3", 4));
   }
   
   /*Tests the hireCommissedWoker method and its conditions. This also tests my
    * hireSalariedWorker method because the codes are almost identical.
    * (Account)
    */
   @Test
   public void testHireWorker2() {
      Account account1 = BusinessOffice.createAccount("Free");
      
      assertTrue(account1.hireSalariedWorker("Francis Otoo", 68));
   }
   
   //Tests if the employee checker is work right or not. (Account)
   @Test
   public void testIsEmployee() {
      Account account = BusinessOffice.createAccount("Company");
      
      account.hireCommissionedWorker("Francis Otoo", 90);
      
      assertTrue(account.isEmployee("Francis Otoo"));
      assertFalse(account.isEmployee("Francis"));
   }
   
   //Tests if I get the right number of employees. (Account)
   @Test
   public void testNumOfEmployees() {
      Account account = BusinessOffice.createAccount("Company");
      
      account.hireCommissionedWorker("Francis Otoo", 90);
      account.hireCommissionedWorker("Jacky John", 40);
      account.hireSalariedWorker("Him", 38);
      account.hireCommissionedWorker("LeGoat James", 99);
      
      assertEquals(4, account.numEmployees());
   }
   
   //Tests if the right employee limits are set. (Account)
   @Test
   public void testEmployeeLimit() {
      Account account1 = BusinessOffice.createAccount("Company");
      Account account2 = BusinessOffice.createAccount("NotCompany", 2);
      
      assertEquals(2, account2.employeeLimit());
      assertEquals(Integer.MAX_VALUE, account1.employeeLimit());
   }
   
   /* Tests workHours and numHours methods together. Also no need to really check
    * for the conditions because the same conditions have been test already
    * (Account)
    */
   @Test
   public void testWorkHours1() {
      Account account = BusinessOffice.createAccount("Company");
      
      account.hireCommissionedWorker("Francis Otoo", 90);
      
      assertTrue(account.workHours("Francis Otoo", 46));
      assertEquals(46, account.numHours("Francis Otoo"));
      
      account.hireSalariedWorker("Him", 20);
      
      assertTrue(account.workHours("Him", 70));
      assertFalse(account.workHours("Him", 11));
   }
   
   /* Tests makeSale and getSale methods together. Also no need to really check
    * for the conditions because the same conditions have been test already
    * (Account)
    */
   @Test
   public void testMakeSale() {
      Account account = BusinessOffice.createAccount("Company");

      account.hireCommissionedWorker("Francis Otoo", 90);
      account.hireSalariedWorker("Him", 20);

      assertTrue(account.makeSale("Francis Otoo", 1000.0));
      assertTrue(account.makeSale("Him", 28));
   }
}
