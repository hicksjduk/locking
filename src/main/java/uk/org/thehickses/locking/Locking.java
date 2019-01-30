package uk.org.thehickses.locking;

import java.util.concurrent.locks.Lock;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class Locking 
{
    public static void doWithLock(Lock lock, Runnable process)
    {
        lock.lock();
        try
        {
            process.run();
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public static <T> T doWithLock(Lock lock, Supplier<T> process)
    {
        lock.lock();
        try
        {
            return process.get();
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public static boolean doWithLock(Lock lock, BooleanSupplier process)
    {
        lock.lock();
        try
        {
            return process.getAsBoolean();
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public static int doWithLock(Lock lock, IntSupplier process)
    {
        lock.lock();
        try
        {
            return process.getAsInt();
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public static long doWithLock(Lock lock, LongSupplier process)
    {
        lock.lock();
        try
        {
            return process.getAsLong();
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public static double doWithLock(Lock lock, DoubleSupplier process)
    {
        lock.lock();
        try
        {
            return process.getAsDouble();
        }
        finally
        {
            lock.unlock();
        }
    }
}
