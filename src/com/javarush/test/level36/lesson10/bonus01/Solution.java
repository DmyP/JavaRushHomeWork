package com.javarush.test.level36.lesson10.bonus01;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Осваиваем ClassLoader и Reflection
Аргументом для класса Solution является абсолютный путь к пакету,
например, "C:\JavaRushHomeWork\src\com\javarush\test\level36\lesson10\bonus01\data\second".
Имя пакета может содержать File.separator.
В этом пакете находятся только скомпилированные классы.
Известно, что каждый класс имеет конструктор без параметров и реализует интерфейс HiddenClass.
Считайте все классы с файловой системы, создайте фабрику - реализуйте метод getHiddenClassObjectByKey.
Известно, что есть только один класс, простое имя которого начинается с String key без учета регистра.
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;
    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution("/Users/inna/Documents/class2");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File directory = new File(packageName);
        String [] classFiles =  directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains(".class");
            }
        });
        for (String str : classFiles){
            final String pathToFile = directory.getAbsolutePath() + File.separator;
            ClassLoader classLoader = new ClassLoader() {
                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    String className = pathToFile + name + ".class";
                    Path path = Paths.get(className);
                    try {
                        byte [] buffer = Files.readAllBytes(path);
                        return defineClass(null, buffer, 0, buffer.length);
                    } catch (IOException e) {
                        return super.findClass(name);
                    }
                }
            };
            String subName = str.substring(0,str.lastIndexOf("."));
            Class clazz = classLoader.loadClass(subName);
            if(HiddenClass.class.isAssignableFrom(clazz)){
                hiddenClasses.add(clazz);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for(Class clazz: hiddenClasses){
            if(clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())){
                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for(Constructor constructor: constructors){
                        if(constructor.getParameterTypes().length == 0){
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                }
                catch (InstantiationException e) {}
                catch (IllegalAccessException e) {}
                catch (InvocationTargetException e) {}
            }
        }
        return null;
    }
}