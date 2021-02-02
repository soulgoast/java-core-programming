/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.qunce.xml;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @ClassName DomReader
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2020/7/4 7:15
 * @ModifyDate 2020/7/4 7:15
 * @Version 1.0
 */
public class DomReader {

    @Test
    public void read() {
        try {
            File file = new File("data.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Node parentNode = document.getParentNode();
            System.out.println(parentNode.getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}