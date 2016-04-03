package  com.javarush.test.level14.lesson06.home01;


class RussianHen extends Hen{

        @Override
        int getCountOfEggsPerMonth() {
            return 1;
        }

        @Override
        String getDescription() {
           return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }
    }

