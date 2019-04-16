package server;

import java.io.*;

public class Certificate {

    private String file = "person.txt";
    private String cfile;
    BufferedWriter bw = null;
    FileWriter fw = null;

    BufferedReader br = null;
    FileReader fr = null;

    public Certificate()
    {

    }

    public void writeCertificate(String st) throws IOException {

        cfile = "certificate-" + st + ".txt";
        SearchFile search = new SearchFile("academic.txt");
        String str = search.SearchInFile(st);
        printAcademicInfo(cfile, str);

        search = new SearchFile("person.txt");
        str = search.SearchInFile(st);
        printPersonalInfo(cfile, str);
    }

    public void printAcademicInfo(String cfile, String content) throws IOException {

        fw = new FileWriter(cfile,true);
        bw = new BufferedWriter(fw);
        bw.flush();
        String [] words = content.split(",");

        bw.write("_________________Academic Information_________________"+"\n\n");
        bw.write("registration number: "+ words[0]+"\n");
        bw.write("session: "+ words[1]+"\n");
        bw.write("semester: "+ words[2]+"\n");
        bw.write("year: "+ words[3]+"\n");
        bw.write("cgpa: "+ words[4]+"\n");
        bw.write("class-roll: "+ words[5]+"\n");
        bw.write("\n\n\n");

    }

    public void printPersonalInfo(String cfile, String content)  throws IOException
    {
        fw = new FileWriter(cfile,true);
        bw = new BufferedWriter(fw);
        bw.flush();

        bw.write("_________________Personal Information_________________"+"\n\n");
        String [] words = content.split(",");
        bw.write("name: "+ words[0]);
        bw.write("father's name: "+ words[1]);
        bw.write("mother's name: "+ words[2]);
        bw.write("nid: "+ words[3]);
        bw.write("address: "+ words[4]);
        bw.write("\n");


    }
}
