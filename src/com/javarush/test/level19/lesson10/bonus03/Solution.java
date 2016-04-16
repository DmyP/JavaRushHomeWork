package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>


Парочка советов:
1. Решение задачи не предполагает наличие пробелов в тегах. Т.о. теги типа
< span > или < / span >
можете не искать.
Зато в файле могут присутствовать теги вроде
<span xx..xx>
или
<span
xx..xx>

2. Переход строки пробелом можно не заменять.
3. Потестируйте вариант наличия в файле русских букв.
4. Попробуйте программу на следующих тестах:
<span
текст>  SOME русский текст</span> 12345<span>раз<span>два<span>три</span></span></span>

Ожидаемый результат:
<span текст>  SOME русский текст</span>
<span>раз<span>два<span>три</span></span></span>
<span>два<span>три</span></span>
<span>три</span>

еще один тест:
<span
текст>  SOME <span>раз</span> русский текст <span>два</span></span>

Ожидаемый результат:
<span текст>  SOME <span>раз</span> русский текст <span>два</span></span>
<span>раз</span>
<span>два</span>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader =  new BufferedReader(new FileReader(file.readLine()));
        //String tag = args[0];
        String tag = "span";
        String str = "";
        while (bufferedReader.ready()) {
            str = str.concat(bufferedReader.readLine());
        }
        str = str.replaceAll("\r\n", "");

        TreeMap <Integer, Integer> indexList = new TreeMap<>();

        String tagOpen = "<".concat(tag);
        String tagClose = "</".concat(tag);
        int len = tag.length();
        int index = 0;

        while ((index < str.length()) && (index != -1)) {
            index = str.indexOf(tagOpen, index);
            int index2 = str.indexOf(tagClose, index + len);
            int k = index + len;
            if (index2 != -1) {
                while (str.substring(k, index2).contains(tagOpen)) {
                    k = index2 + len;
                    index2 = str.indexOf(tagClose, k);
                }
            }
            if (index != -1 && index2 != -1) {
                indexList.put(index, index2);
                index += len;
            }
        }
        for(Map.Entry<Integer,Integer> pair : indexList.entrySet()) {
            System.out.println(str.substring(pair.getKey(), pair.getValue() + len + 3));
        }
    }
}
