package week11.file;

import java.io.File;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirectoryInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory name: ");
        String dirName = sc.nextLine();
        File file = new File(dirName);
        
        if (file.exists()) {
            System.out.println("Name: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            
            if (file.isDirectory()) {
                System.out.println("Type: Directory");
                System.out.println("Size: " + file.length() + " bytes");
                long lastModified = file.lastModified();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("Last Modified: " + sdf.format(new Date(lastModified)));
                
                File[] files = file.listFiles();
                if (files != null) {
                    System.out.println("Files in directory:");
                    for (File f : files) {
                        System.out.println(" - " + f.getName());
                    }
                } else {
                    System.out.println("Unable to list files.");
                }
            } else if (file.isFile()) {
                System.out.println("Type: File");
                System.out.println("Size: " + file.length() + " bytes");
                long lastModified = file.lastModified();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("Last Modified: " + sdf.format(new Date(lastModified)));
            } else {
                System.out.println("Type: Unknown");
            }
        } else {
            System.out.println("The specified path does not exist.");
        }
        
        sc.close();
    }
}