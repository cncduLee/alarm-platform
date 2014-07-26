package com.wangyin.mq.impl;

import com.wangyin.common.Message;
import com.wangyin.mq.IMQ;
import com.wangyin.mq.code.MyRuler;
import com.wangyin.mq.code.Ruler;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wylipengming on 2014/7/26.
 * 本地调研的实现
 */
@Component("IMQInJvm")
public class IMQInJvmImpl implements IMQ<Message> {
    //大小
    private int capacity;

    //Main lock guarding all access
    final ReentrantLock lock = new ReentrantLock();

    private static PriorityQueue<Message> que;

    private static class SiglentonHolder{
        private final static IMQInJvmImpl singleton = new IMQInJvmImpl();
    }

    public static IMQInJvmImpl getInstance(){
        return SiglentonHolder.singleton;
    }

    private IMQInJvmImpl() {
        this(Integer.MAX_VALUE);
    }

    private IMQInJvmImpl(int capacity) {
        this(capacity,null);
    }

    private IMQInJvmImpl(int capacity, Ruler<? super Message> comparator) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        if (comparator == null) {
            comparator = new MyRuler();
        }
        que = new PriorityQueue<Message>(comparator);
    }

    @Override
    public Boolean offer(Message m) {
        final ReentrantLock lock = this.lock;
        lock.lock(); // Never contended, but necessary for visibility
        try {
            if (m == null){
                return false;
            }
            if (!que.offer(m)){
                return true;
            }
        } finally {
            lock.unlock();
        }
        return false;
    }

    @Override
    public Message poll() {
        final ReentrantLock lock = this.lock;
        lock.lock(); // Never contended, but necessary for visibility
        try {
            return que.poll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Message peek() {
        final ReentrantLock lock = this.lock;
        lock.lock(); // Never contended, but necessary for visibility
        try {
            return que.peek();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Boolean isEmpty() {
        final ReentrantLock lock = this.lock;
        lock.lock(); // Never contended, but necessary for visibility
        try {
            return que.isEmpty();
        } finally {
            lock.unlock();
        }
    }
}
