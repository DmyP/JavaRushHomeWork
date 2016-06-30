package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class First {
    public String[] second = new String[]{"some string", "some string", "need CDATA because of < and >", ""};
}
