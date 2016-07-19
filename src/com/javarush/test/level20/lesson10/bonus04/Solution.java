package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21
Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable {
    private TreeNode root = new TreeNode();

    class TreeNode implements Serializable {
        private String data;
        private TreeNode parent;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {}

        public TreeNode(TreeNode parent, String value) {
            this.data = value;
            this.parent = parent;
        }
    }

    public String getParent(String value) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()) {
            TreeNode node = arrayDeque.poll();

            if (value.equals(node.data)) {
                return node.parent.data;
            }
            else {
                if (node.left != null) arrayDeque.add(node.left);
                if (node.right != null) arrayDeque.add(node.right);
            }
        }
        return null;
    }

    @Override
    public Iterator<String> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<String> {
        private ArrayList<String> nodes = new ArrayList<>();
        private Iterator<String> iterator;
        private String currentValue;

        public NodeIterator() {
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            arrayDeque.add(root);

            while (!arrayDeque.isEmpty()) {
                TreeNode node = arrayDeque.poll();

                if (node.data != null) nodes.add(node.data);

                if (node.left != null) arrayDeque.add(node.left);
                if (node.right != null) arrayDeque.add(node.right);
            }

            iterator = nodes.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public String next() {
            currentValue = iterator.next();
            return currentValue;
        }

        @Override
        public void remove() {
            Solution.this.remove(currentValue);
        }
    }

    @Override
    public void clear() {
        root = new TreeNode();
    }

    @Override
    public boolean remove(Object obj) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        String data = (String)obj;
        while (!arrayDeque.isEmpty()) {
            TreeNode node = arrayDeque.poll();
            if (data.equals(node.data)) {
                TreeNode parent = node.parent;
                if (parent.left == node) parent.left = null;
                else parent.right = null;
                return true;
            }
            else {
                if (node.left != null) arrayDeque.add(node.left);
                if (node.right != null) arrayDeque.add(node.right);
            }
        }
        return false;
    }

    @Override
    public boolean add(String str) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        while (true) {
            TreeNode node = arrayDeque.poll();
            if (node.left == null) {
                node.left = new TreeNode(node, str);
                break;
            }
            else arrayDeque.add(node.left);

            if (node.right == null) {
                node.right = new TreeNode(node, str);
                break;
            }
            else arrayDeque.add(node.right);
        }
        return true;
    }

    @Override
    public int size() {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        int size = 0;
        while (!arrayDeque.isEmpty()) {
            TreeNode node = arrayDeque.poll();
            size++;
            if (node.left != null) arrayDeque.add(node.left);
            if (node.right != null) arrayDeque.add(node.right);
        }
        return size - 1;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
    }
}
