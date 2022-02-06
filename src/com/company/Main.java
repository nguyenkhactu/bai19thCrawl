package com.company;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }

    }
}
