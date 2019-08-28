package threads;

/**
 *
 * @author B Ricks, PhD <bricks@unomaha.edu>
 */
public class UnsafeAccount extends BankAccount {
    
    @Override
    public void DepositADollar(){
        //balance = balance + 1;
        balance++;
    }
    
    
}
