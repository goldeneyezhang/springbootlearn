package com.yibo.testhystrix;

import com.yibo.testhystrix.command.CommandHelloWorld;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String s = new CommandHelloWorld("Bob").execute();
        System.out.println(s);
    }
}
