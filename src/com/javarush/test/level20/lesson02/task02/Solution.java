package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/Users/inna/Documents/1.txt");
            InputStream inputStream = new FileInputStream("/Users/inna/Documents/1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setBirthDate(new Date());
            user.setCountry(User.Country.UKRAINE);
            user.setFirstName("G");
            user.setLastName("GG");
            user.setMale(true);
            User user1 = new User();
            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (int i = 0; i < users.size(); i++) {
                printWriter.println(users.get(i).getFirstName());
                printWriter.println(users.get(i).getLastName());
                if (users.get(i).getBirthDate() != null) printWriter.println(users.get(i).getBirthDate().getTime());
                else printWriter.println("null");
                printWriter.println(users.get(i).isMale());
                if (users.get(i).getCountry() != null) printWriter.println(users.get(i).getCountry());
                else printWriter.println("null");
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = reader.readLine()) != null){
                User user = new User();
                if (!("null".equals(str))) user.setFirstName(str);
                else  user.setFirstName(null);
                str = reader.readLine();
                if (!("null".equals(str))) user.setLastName(str);
                else  user.setLastName(null);
                str = reader.readLine();
                if (!("null".equals(str))) user.setBirthDate(new Date(Long.parseLong(str)));
                else user.setBirthDate(null);
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                str = reader.readLine();
                if ("null".equals(str)) user.setCountry(null);
                else user.setCountry(User.Country.valueOf(str));
                users.add(user);
            }

            reader.close();
        }
    }
}
