package com.zk.test;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.UUID;

public class DataUpdater implements Watcher, Runnable {

    public static void main(String[] args) {
        DataUpdater dataUpdater = new DataUpdater();
        dataUpdater.run();
    }

    private static String hostPort = "localhost:2181";
    private static String zooDataPath = "/MyConfig";
    ZooKeeper zk;

    public DataUpdater() {
        try {
            zk = new ZooKeeper(hostPort, 2000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent.toString());

    }

    @Override
    public void run() {
        while (true) {
            String uuID = UUID.randomUUID().toString();
            byte zoo_date[] = uuID.getBytes();
            try {
                zk.setData(zooDataPath, zoo_date, -1);
                Thread.sleep(5000);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
