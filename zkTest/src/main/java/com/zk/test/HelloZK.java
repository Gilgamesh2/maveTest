package com.zk.test;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloZK {
    public static void main(String[] args) {
        String hostPort = "127.0.0.1:2181";
        String path = "/";
        List<String> zChildren = new ArrayList<String>();
        try {
            ZooKeeper zk = new ZooKeeper(hostPort, 2000, null);
            zChildren = zk.getChildren(path, false);
            for (String z : zChildren) {
                System.out.println(z);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }
}
