package server;

public class Student {

    private String reg;
    private String session;
    private String sem;
    private String year;
    private String cgpa;
    private String roll;

    private String name;
    private String f_name;
    private String m_name;
    private String nid;
    private String address;

    public Student()
    {

    }

    public void addInfo(String[] s1, String[]s2)
    {
        this.name = s1[0];
        this.f_name = s1[1];
        this.m_name = s1[2];
        this.nid = s1[3];
        this.address = s1[4];
   // }

    //public void addAcademicInfo(String reg,String session,String sem,String year,String cgpa,String roll)
    //{//
        this.reg = s2[0];
        this.session = s2[1];
        this.sem = s2[2];
        this.year =s2[3];
        this.cgpa = s2[4];
        this.roll = s2[5];
    }
}
