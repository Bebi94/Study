package com.bkacad.app.view;

import java.util.Scanner;

import com.bkacad.app.exception.WrongUserInputException;

public class MenuView extends AbstractView{

    @Override
    public void render() throws Exception {
        System.out.println("type [A] to Add, [C] to Change, [D] to Delete, [L] to Show all movies");
        Scanner scn = new Scanner(System.in);
        String selection = scn.nextLine();
        switch (selection) {
            case "A":
                MovieAddView mav = new MovieAddView();
                mav.render();
                break;
            /*case "C":
                MovieChangeView mcv = new MovieChangeView();
                mcv.render();
                break;
            case "D":
                MovieDeleteView mdv = new MovieDeleteView();
                mdv.render();
                break;
            case "L":
                MovieController.listMovie().render();
                break;*/
            default:
                ErrorView ev = new ErrorView(new WrongUserInputException("Lựa chọn sai!!!!!"));
                ev.render();
                break;
        }


        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
    
}
