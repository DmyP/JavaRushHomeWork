package com.javarush.test.level23.lesson04.task02;

class Zoo
{
    private static int count = 7;
    private int mouseCount = 1;

    public static int getAnimalCount()
    {
        return count;
    }

    public int getMouseCount()
    {
        return mouseCount;
    }

    public static class Mouse
    {
        private Zoo sss;
        public Mouse()
        {
        }
        public int getTotalCount()
        {
            sss = new Zoo();
            return count + sss.getMouseCount(); //ошибка компиляции.
        }
    }
}
class Home
{
    public static void main(String[] args)
    {
        Zoo.Mouse mouse = new Zoo.Mouse();
        mouse.getTotalCount();
    }
}
