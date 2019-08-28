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
            
            Runnable Alice = ()->b2.DepositCash();            
            Runnable Bob = ()->b2.DepositCash();
            
            Thread AliceThread = new Thread(Alice);
            Thread BobThread = new Thread(Bob);
            
            AliceThread.start();
            BobThread.start();
            
            AliceThread.join();
            BobThread.join();
            
            System.out.println("Two threads unlocked");
            b2.PrintBalance();
            
            
            //Threaded code with locked code underneath
            final LockedAccount b3 = new LockedAccount();
            
            Runnable AliceLocked = ()->b3.DepositCash();
            Runnable BobLocked = ()->b3.DepositCash();
            
            Thread AliceThreadLocked = new Thread(AliceLocked);
            Thread BobThreadLocked = new Thread(BobLocked);
            
            AliceThreadLocked.start();
            BobThreadLocked.start();
            
            AliceThreadLocked.join();
            BobThreadLocked.join();
            
            System.out.println("Two threads locked");
            b3.PrintBalance();
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();;
        }
    }
    
}
