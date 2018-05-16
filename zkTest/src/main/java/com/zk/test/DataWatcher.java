package com.zk.test;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DataWatcher implements Watcher, Runnable {
    public static void main(String[] args) throws KeeperException, InterruptedException {
        DataWatcher dataWatcher = new DataWatcher();
        dataWatcher.printDate();
        dataWatcher.run();
        System.out.println(1111);
    }

    private static String hostPort = "localhost:2181";
    private static String zooDataPath = "/MyConfig";
    byte zoo_date[] = null;
    ZooKeeper zooKeeper;

    public DataWatcher() {
        try {
            zooKeeper = new ZooKeeper(hostPort, 2000, this);
            if (zooKeeper != null) {
                if (zooKeeper.exists(zooDataPath, this) == null) {
                    zooKeeper.create(zooDataPath, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public void printDate() throws KeeperException, InterruptedException {
        zoo_date = zooKeeper.getData(zooDataPath, this, null);
        String z = new String(zoo_date);
        System.out.printf("\n Current Data @ZK Path %s : %s", zooDataPath, z);

    }

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent.toString());
        if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
            try {
                printDate();
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
