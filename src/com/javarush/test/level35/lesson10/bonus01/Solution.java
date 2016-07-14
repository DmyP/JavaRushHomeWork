package com.javarush.test.level35.lesson10.bonus01;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
      //  Set<? extends Animal> allAnimals = getAllAnimals("C://pathToClasses/");
        Set<? extends Animal> allAnimals = getAllAnimals("/Users/inna/Documents/class");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animalSet = new HashSet<>();
        if ((pathToAnimals != null) || (!pathToAnimals.endsWith("\\")) || (!pathToAnimals.endsWith("/"))) {
                    pathToAnimals = pathToAnimals + "/";
        }

        File directory = new File(pathToAnimals);
        String[] clazzes = directory.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        });

        if (clazzes.length == 0) {
            return animalSet;
        }
        try {
            for (String cls : clazzes) {
                try {
                    String finalPathToAnimals = pathToAnimals;
                    ClassLoader loader = new ClassLoader() {
                        @Override
                        public Class<?> findClass(String className) throws ClassNotFoundException {
                            try {
                                byte b[] = fetchClassFromFS(finalPathToAnimals + className + ".class");
                                return defineClass(null, b, 0, b.length);
                            }
                            catch (FileNotFoundException ex) {
                                return super.findClass(className);
                            }
                            catch (IOException ex) {
                                return super.findClass(className);
                            }
                        }
                    };
                    String clsName = cls.substring(0, cls.length() - 6);
                    Class clazz = loader.loadClass(clsName);

                    boolean hasInterface = false;
                    Class[] interfaces = clazz.getInterfaces();
                    for (Class i : interfaces) {
                        if (Animal.class.getSimpleName().equals(i.getSimpleName())) {
                            hasInterface = true;
                            break;
                        }
                    }
                    if (!hasInterface) continue;

                    boolean hasConstructor = false;
                    Constructor[] constructors = clazz.getConstructors();
                    for (Constructor c : constructors) {
                        if (c.getModifiers()==1 && c.getParameterTypes().length == 0) {
                            hasConstructor = true;
                            break;
                        }
                    }
                    if (!hasConstructor) continue;
                    animalSet.add((Animal) clazz.newInstance());
                } catch (ClassNotFoundException e) {
                } catch (InstantiationException e) {
                } catch (IllegalAccessException e) {
                } catch (ClassFormatError e) {
                } catch (ClassCastException e) {
                }
            }
        }
        catch (Exception e) {
            return animalSet;
    }
    return animalSet;
    }

    public static byte[] fetchClassFromFS(String path) throws IOException
    {
        InputStream inputStream = new FileInputStream(path);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        return bytes;
    }
}