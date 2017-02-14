package com.rednavis.demo.jelly;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.jelly.JellyContext;
import org.apache.commons.jelly.XMLOutput;

/**
 * Demonstrates HTML file generation from XML jelly template using context parameters.
 *
 * @author Alex Oreshkevich
 * @see http://commons.apache.org/proper/commons-jelly/tutorial.html#embeddingjelly
 */
public class HtmlPageDemo
{

    public static final String DEMO_1_TEMPLATE_NAME = "demo1.xml";

    public static void main(String[] args)
            throws Exception
    {

        run("name", "#000000", "http://www.intalion.hu/wp-content/uploads/2014/06/feather.png?78de1c",
            Arrays.asList("one", "two", "three"), DEMO_1_TEMPLATE_NAME);
    }

    public static void run(String name,
                           String background,
                           String url,
                           List<String> hobbiesList,
                           String template)
            throws Exception
    {

        OutputStream output = new FileOutputStream("build/demopage.html");
        JellyContext context = new JellyContext();

        context.setVariable("name", name);
        context.setVariable("background", background);
        context.setVariable("url", url);
        context.setVariable("hobbies", hobbiesList);

        XMLOutput xmlOutput = XMLOutput.createXMLOutput(output);
        context.runScript("src/main/resources/" + template, xmlOutput);
        xmlOutput.flush();
    }
}
