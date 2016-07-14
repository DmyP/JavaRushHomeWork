package com.javarush.test.level36.lesson08.bonus01;

/* Разбираемся в красно-черном дереве
Дана реализация красно-черного дерева.
Некоторые методы сломаны. Разберитесь в коде и исправьте ошибки.
Метод main не участвует в тестировании.
Все модификатры правильные.
Имена переменных и методов не изменяйте.
*/
public class Solution {
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(10);
        redBlackTree.insert(20);
        redBlackTree.insert(30);
        redBlackTree.insert(40);
        try {
            NodeHelperTestSolution.getEmptyNode();
            System.out.println(NodeHelperTestSolution.getFromTreeNodeByName("current",redBlackTree));
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
    }
}
