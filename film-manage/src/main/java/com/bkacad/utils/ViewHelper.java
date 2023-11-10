package com.bkacad.utils;

import java.io.IOException;

public class ViewHelper {
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        catch (final IOException  e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
