
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nguyenhuuphu
 */
public class DeThi implements Serializable {

    private ArrayList<CauHoi> dsCauHoi = new ArrayList<CauHoi>();

    private String hocKi;
    private String monHoc;
    private String loaiKi;
    private int thoiGian;
    private int maDe;

    public DeThi() {
        this.monHoc="";
    }

    public DeThi(String monhoc, String hocki, String loaiki, int thoigian, int made) {
        this.monHoc = monhoc;

        this.hocKi = hocki;
        this.loaiKi = loaiki;
        this.thoiGian = thoigian;
        this.maDe = made;

    }

    public ArrayList<CauHoi> getdsCauHoi() {
        return dsCauHoi;
    }
    public void setdsCauHoi(ArrayList<CauHoi> dsCauHoi){
        this.dsCauHoi=dsCauHoi;
    }

    public void themCauHoi(CauHoi cauhoi) {
        dsCauHoi.add(cauhoi);
    }

    public boolean xoaCauHoi(int i) {
        if (i >= 0 && i < dsCauHoi.size()) {
            dsCauHoi.remove(i);
            return true;
        } else {
            return false;
        }
    }
    public void suaCauHoi(int i,CauHoi cauhoi){
        dsCauHoi.set(i, cauhoi);
    }

    public int getmaDe() {
        return this.maDe;
    }

    public void setmaDe(int made) {
        this.maDe = made;
    }

    public String gethocKi() {
        return this.hocKi;
    }

    public void sethocKi(String hocki) {
        this.hocKi = hocki;
    }

    public String getmonHoc() {
        return this.monHoc;
    }

    public void setmonHoc(String monhoc) {
        this.monHoc = monhoc;
    }

    public String getloaiKi() {
        return this.loaiKi;
    }

    public void setloaiKi(String loaiki) {
        this.loaiKi = loaiki;
    }

    public int soLuongCauHoi() {
        return dsCauHoi.size();
    }

    public int getthoiGian() {
        return this.thoiGian;
    }

    public void setthoiGian(int thoigian) {
        this.thoiGian = thoigian;
    }
    public int soLuongCauHoiTN(){
        int socau=0;
        for(CauHoi i:dsCauHoi){
            if(i instanceof CauHoiTN){
                socau++;
            }
        }
        return socau;
    }
    public int soLuongCauHoiTL(){
        int socau=0;
        for(CauHoi i:dsCauHoi){
            if(i instanceof CauHoiTL){
                socau++;
            }
        }
        return socau;
    }
    /**
     * xuat de thi ra file txt
     */
    public void inDeThi() {
        try {
            FileWriter f = new FileWriter("De thi"+this.monHoc +this.maDe+ ".txt");
            BufferedWriter out = new BufferedWriter(f);

            out.write("\t\t\t\t\t\t\t" + "De Thi Mon:" + this.monHoc);
            out.newLine();
            out.write("\t\t\t\t\t\t\t       " + "Ki:" + this.loaiKi + "    " + "Nam Hoc:" + this.hocKi + "  Ma De:" + this.maDe);
            out.newLine();
            out.write("\t\t\t\t\t\t\t\t" + "Thoi Gian:" + this.thoiGian + "phut" + "\n");
            out.newLine();
            int i = 1;
            String thutuDA = "ABCDEFGH";
            for (CauHoi e : dsCauHoi) {
                if (e instanceof CauHoiTN) {
                    out.write("Cau " + i + ":" + e.gettenCauHoi()+"("+e.getdiem()+")");
                    out.newLine();
                    int j = 0;
                    for (String d : ((CauHoiTN) e).getdsDapAn()) {
                        out.write(thutuDA.charAt(j) + "." + ((d.charAt(0)=='~')?d.substring(1):d));
                        out.newLine();
                        j++;
                    }
                    i++;
                } else {
                    out.write("Cau " + i + ":" + e.gettenCauHoi()+"("+e.getdiem()+")");
                    out.newLine();
                    i++;
                }

            }
            out.flush();

            out.close();

        } catch (IOException ex) {

        }
    }
    /**
     *  xuat danh sach dap an cua cac cau hoi trong de thi ra file txt.
     */
    public void inDapAn() {
         try{
             FileWriter f=new FileWriter("Dap an "+this.monHoc+this.maDe+".txt");
             BufferedWriter out=new BufferedWriter(f);
             out.write("Dap an:"+this.monHoc+"Ma De:"+this.maDe);
             out.newLine();
             int i=1;
             for(CauHoi e:this.dsCauHoi){
                 out.write("Cau "+i+e.getDapAn());
                 out.newLine();
                 i++;
             }
             out.flush();
             out.close();
         }catch(IOException e){}
    }
    /**
     * Xao tron thu tu cau hoi trong danh sach cau hoi cua de thi va xao tron dap an cua cau hoi trac nghiem
     * 
     */
    public void daoCauHoi(){
        for(int i=0;i<dsCauHoi.size();i++){
            for(CauHoi e:dsCauHoi){
                if(e instanceof CauHoiTN){
                    ((CauHoiTN) e).daoDapAn();
                }
            }
            int j=NganHangCauHoi.rand(0,1);
            if(j==1){
                if(dsCauHoi.get(i) instanceof CauHoiTN){
                    CauHoiTN temp=new CauHoiTN();
                    temp=(CauHoiTN)dsCauHoi.get(i);
                    dsCauHoi.remove(i);
                    dsCauHoi.add(temp);
                }
                else{
                    CauHoiTL temp=new CauHoiTL();
                    temp=(CauHoiTL)dsCauHoi.get(i);
                    dsCauHoi.remove(i);
                    dsCauHoi.add(temp);
                }
            }
        }
    }

    /*public static void main(String[] args) {
        DeThi de = new DeThi();
            ArrayList<MonHoc> dsmonhoc=NganHangCauHoi.dsMonHoc();
            MonHoc mon1=dsmonhoc.get(0);
            de=NganHangCauHoi.taoDeThiTuDong(mon1,"TN va TL",7,"chung");
            
            
           
   
   
        de.sethocKi (

    "2015-2016");
    de.setloaiKi (

    "he");
    de.setthoiGian (

    90);
    de.setmaDe(NganHangCauHoi.rand(100,567));
    
    de.inDeThi ();
    de.inDapAn();
    NganHangCauHoi.ghiDeThiRaObject(de);

}
*/

}
