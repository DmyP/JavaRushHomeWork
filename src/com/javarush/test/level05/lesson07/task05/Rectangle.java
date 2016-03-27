package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота).
Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private float left;
    private float top;
    private float width;
    private float heigh;

    public void initialize(float left, float top, float width, float heigh) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.heigh = heigh;
    }

    public void initialize(float left, float top) {
        this.left = left;
        this.top = top;
        this.width = 0;
        this.heigh = 0;
    }
    public void initialize(float left, float top, float width) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.heigh = width;
    }
    public void initialize(Rectangle rectangle) {
        this.left = rectangle.left;
        this.top = rectangle.top;
        this.width = rectangle.width;
        this.heigh = rectangle.heigh;
    }
}
