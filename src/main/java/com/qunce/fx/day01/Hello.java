/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.qunce.fx.day01;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @ClassName Hello
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2021/1/21 21:50
 * @ModifyDate 2021/1/21 21:50
 * @Version 1.0
 */
public class Hello extends Application {

    public static void main(String[] args) {
        System.out.println("Hello World");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }
}