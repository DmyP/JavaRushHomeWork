package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0},
                {0, 0, 0},
                {1, 1, 0},
        };
        int count = getRectangleCount(a);
        System.out.println("Count = " + count + ". Должно быть 2");
        a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        count = getRectangleCount(a);
        System.out.println("Count = " + count + ". Должно быть 2");
        a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };
        count = getRectangleCount(a);
        System.out.println("Count = " + count + ". Должно быть 3");
        a = new byte[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };

        count = getRectangleCount(a);
        System.out.println("Count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int counter = 0;
        boolean previosOneExist = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    counter++;
                    for (int k = i; k < a.length; k++) {
                        if (a[k][j] == 0) break;
                        for (int l = j; l < a[k].length; l++) {
                            if (a[k][l] == 0) break;
                            else a[k][l] = 0;
                        }
                    }
                }
            }
        }


        return counter;
    }
    }

