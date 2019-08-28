package threads;

/**
 *
 * @author B Ricks, PhD <bricks@unomaha.edu>
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            UnsafeAccount b = new UnsafeAccount();            
            b.DepositCash();            
            b.DepositCash();            
            System.out.println("Two sequential for loops:");            
            b.PrintBalance();
            
            //Thread code with unlocked code underneath.
            
            final UnsafeAccount b2 = new UnsafeAccount();
            
            //Create two runnable instances pointing to b2
            
            //Create wto threads pointing to these runnables
            
            //Start these threads
            
            //Wait for these threads to finish
            
            //Print the sum
            
            System.out.println("Two threads unlocked");
            b2.PrintBalance();
            
            
            //Threaded code with locked code underneath
            final LockedAccount b3 = new LockedAccount();
            
           //Create two runnable instances pointing to b2
            
            //Create wto threads pointing to these runnables
            
            //Start these threads
            
            //Wait for these threads to finish
            
            //Print the sum
            
            System.out.println("Two threads locked");
            b3.PrintBalance();
            
        } catch (Exception ex) {
            ex.printStackTrace();;
        }
    }
    
}
