package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution s = (Solution) o;
        return (first == s.first || (first != null && first.equals(s.first)))
                && (last == s.last || (last != null && last.equals(s.last)));
    }

    @Override
    public int hashCode() {
        return 31 * (first == null ? 0 : first.hashCode()) + (last==null ? 0 : last.hashCode()) ;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        s.add(new Solution(null, "Duck"));
        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
