package com.bkacad.app.view;

import java.util.Scanner;

import com.bkacad.app.App;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.utils.ViewHelper;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar;

public class ErrorView extends AbstractView{
    String msg;
    Scanner input = App.getInput();
    public ErrorView(AbstractException e){
        this.msg = e.getMessage();
    }
    public ErrorView(String msg){
        this.msg = msg;
    }
    public void render(){
        System.out.println("--[Error]--");
        System.out.println(this.msg);
        System.out.println("Press any key to continue...");
        input.nextLine();
        ViewHelper.clearConsole();
    }
}
