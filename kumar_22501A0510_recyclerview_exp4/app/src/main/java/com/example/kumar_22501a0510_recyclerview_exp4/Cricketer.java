package com.example.kumar_22501a0510_recyclerview_exp4;
public class Cricketer {
    private int cpic;
    private String cname,crole;
    public Cricketer(int cpic, String cname, String crole) {
        this.cpic = cpic;
        this.crole = crole;
        this.cname = cname;
    }
    public int getCpic() {
        return cpic;
    }
    public String getCname() {
        return cname;
    }
    public String getCrole() {
        return crole;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public void setCpic(int cpic) {
        this.cpic = cpic;
    }
    public void setCrole(String crole) {
        this.crole = crole;
    }
}
