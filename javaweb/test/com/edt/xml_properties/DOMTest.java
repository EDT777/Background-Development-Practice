package com.edt.xml_properties;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DOMTest {
    @Test
    public void testGetDocument() throws Exception {



        //获取 文档对象 Document 对象
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("contacts.xml"));
        //获取根元素 对象
        Element root = doc.getDocumentElement();
        //获取此名字的 元素对象们
        NodeList list = root.getElementsByTagName("linkman");
        //从集合中去获取第二个元素对象
        Element element = (Element) list.item(1);
        //获取第二个元素对象里的name元素
        NodeList nameList = element.getElementsByTagName("name");
        Element nameE1 = (Element) nameList.item(0);
        //获取元素的文本
        String name = nameE1.getTextContent();
        System.out.printf(name);


        //插入一个元素对象
        Element linkman = doc.createElement("linkman");
        Element nameEl = doc.createElement("name");
        nameEl.setTextContent("小豪");
        Element emailEl = doc.createElement("emailEl");
         emailEl.setTextContent("www.123.com");
        Element addressEl = doc.createElement("address");
        addressEl.setTextContent("东莞");
        Element group = doc.createElement("group");
        group.setTextContent("javaaa学院");
        linkman.appendChild(nameEl);
        linkman.appendChild(emailEl);
        linkman.appendChild(addressEl);
        linkman.appendChild(group);

        root.appendChild(linkman);
        //将内存中的DOM 同步到磁盘的xml中
        //创建同步类对象
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(doc), new StreamResult("D:\\IDEA-Project\\javaweb\\resources\\contacts.xml"));


    }
}
