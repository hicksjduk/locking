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
        try (CloseableLock c = closeable(lock))
        {
            process.run();
        }
    }

    public static <T> T doWithLock(Lock lock, Supplier<T> process)
    {
        try (CloseableLock c = closeable(lock))
        {
            return process.get();
        }
    }

    public static boolean doWithLock(Lock lock, BooleanSupplier process)
    {
        try (CloseableLock c = closeable(lock))
        {
            return process.getAsBoolean();
        }
    }

    public static int doWithLock(Lock lock, IntSupplier process)
    {
        try (CloseableLock c = closeable(lock))
        {
            return process.getAsInt();
        }
    }

    public static long doWithLock(Lock lock, LongSupplier process)
    {
        try (CloseableLock c = closeable(lock))
        {
            return process.getAsLong();
        }
    }

    public static double doWithLock(Lock lock, DoubleSupplier process)
    {
        try (CloseableLock c = closeable(lock))
        {
            return process.getAsDouble();
        }
    }

    private static CloseableLock closeable(Lock lock)
    {
        lock.lock();
        return () -> lock.unlock();
    }

    @FunctionalInterface
    private static interface CloseableLock extends AutoCloseable
    {
        void close();
    }
}
