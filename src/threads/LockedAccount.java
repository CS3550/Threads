package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author B Ricks, PhD <bricks@unomaha.edu>
 */
public class LockedAccount extends BankAccount {

    Lock lock = new ReentrantLock();

    @Override
    public void DepositADollar() {
       lock.lock();
        try {
            balance++;
        } finally {
            lock.unlock();
        }
    }
}
