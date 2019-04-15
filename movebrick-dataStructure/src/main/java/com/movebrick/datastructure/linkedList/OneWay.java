package com.movebrick.datastructure.linkedList;

import java.util.LinkedList;

/**
 * 单向链表
 * 说明：链表是离散存储线性结构
 * n个节点离散分配，彼此通过指针相连，每个节点只有一个前驱节点，每个节点只有一个后续节点，首节点没有前驱节点，尾节点没有后续节点。
 * 链表优点：
 * 空间没有限制
 * 插入删除元素很快
 * 链表缺点：
 * 存取速度很慢
 * <p>
 * 确定一个链表我们只需要头指针，通过头指针就可以把整个链表都能推导出来了～
 * <p>
 * 链表又分了好几类：
 * 单向链表
 * 一个节点指向下一个节点
 * 双向链表
 * 一个节点有两个指针域
 * 循环链表
 * 能通过任何一个节点找到其他所有的节点，将两种(双向/单向)链表的最后一个结点指向第一个结点从而实现循环
 */
public class OneWay {

    public static class Node<E> {
        E item;
        Node<E> next;
        //Node<E> prev;

//        Node(Node<E> prev, E element, Node<E> next) {
//            this.item = element;
//            this.next = next;
//            this.prev = prev;
//        }

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }

        Node() {
        }

        Node(E item) {
            this.item = item;
        }
    }

    transient static Node first = new Node();

    /**
     * 向链表添加数据
     *
     * @param value 要添加的数据
     */
    public static void addData(int value) {
        //初始化要加入的节点
        Node newNode = new Node(value);
        //临时节点
        Node temp = first;
        // 找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        // 已经包括了头节点.next为null的情况了～
        temp.next = newNode;
    }

    /**
     * 遍历链表
     *
     * @param head 头节点
     */
    public static void traverse(Node head) {
        //临时节点，从首节点开始
        Node temp = head.next;
        while (temp != null) {
            System.out.println("输出：" + temp.item);
            //继续下一个
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        OneWay ow = new OneWay();

        OneWay.addData(1);
        OneWay.addData(2);
        OneWay.addData(3);
        OneWay.traverse(first);
        //LinkedList
    }
}
