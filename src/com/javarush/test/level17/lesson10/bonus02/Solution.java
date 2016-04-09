package com.javarush.test.level17.lesson10.bonus02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception  {
  
        if ("-c".equals(args[0])) {
            int i = 0;
            while (1 + 3 * i < args.length){
                String name = args[1 + 3 * i];
                Sex sex = "м".equals(args[2 + 3 * i]) ? Sex.MALE : Sex.FEMALE;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date bd = dateFormat.parse(args[3 + 3 * i]);
                Person person = (sex == Sex.MALE) ? Person.createMale(name, bd) : Person.createFemale(name, bd);
                allPeople.add(person);
                System.out.println(allPeople.size()-1);
                i++;
            }
        }
        else if ("-u".equals(args[0])) {
            int i = 0;
            while (1 + 4 * i < args.length) {
                int index = Integer.parseInt(args[1 + 4*i]);
                String name = args[2 + 4 * i];
                Sex sex = "м".equals(args[3 + 4 * i]) ? Sex.MALE : Sex.FEMALE;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date bd = dateFormat.parse(args[4 + 4 * i]);

                Person person = allPeople.get(index);
                person.setName(name);
                person.setSex(sex);
                person.setBirthDay(bd);
                i++;
            }
        }
        else if ("-d".equals(args[0])) {
            int i = 0;
            while (1 + 1 * i < args.length) {
                int index = Integer.parseInt(args[1 + 1*i]);
                Person person = allPeople.get(index);
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
                i++;
            }
        }
        else if ("-i".equals(args[0])) {
            int i = 0;
            while (1 + 1 * i < args.length) {
                int id = Integer.parseInt(args[1 + 1*i]);
                Person person = allPeople.get(id);
                DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String bd = dateFormat.format(person.getBirthDay());

                System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " +  bd);
                i++;
            }
        }
    }
}
