
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nguyenhuuphu
 */
public class NganHangCauHoi {

    /**
     * Doc du lieu tu file text
     * </br>return Object MonHoc
     *
     * @param filename
     * @return
     */
    public static MonHoc docFileText(String filename) {
        MonHoc mon1 = new MonHoc();

        try {
            FileReader f = new FileReader(filename);
            BufferedReader in = new BufferedReader(f);
            String monhoc = in.readLine();
            String mahocphan = in.readLine();
            String gioithieu = in.readLine();
            mon1.settenMonHoc(monhoc);
            mon1.setgioiThieu(gioithieu);
            mon1.setmaHocPhan(mahocphan);
            String c = in.readLine();
            while (c != null) {
                Chuong ch = new Chuong();
                ch.settenChuong(c);
                ch.setmonHoc(monhoc);

                String d = in.readLine();
                while (true) {
                    if (d.charAt(0) == '#') {
                        break;
                    }
                    if (d.equals("TN")) {
                        CauHoiTN t = new CauHoiTN();
                        String dokho = in.readLine();
                        String tencauhoi = in.readLine();
                        String dapan1 = in.readLine();
                        String dapan2 = in.readLine();
                        String dapan3 = in.readLine();
                        String dapan4 = in.readLine();
                        t.settenCauHoi(tencauhoi);
                        t.setchuong(c);
                        t.setmonHoc(monhoc);
                        t.setsoLuongDapAn(4);
                        t.setdoKho(dokho);

                        t.themDapAn(dapan1);
                        t.themDapAn(dapan2);
                        t.themDapAn(dapan3);
                        t.themDapAn(dapan4);
                        ch.themCauHoi(t);

                    } else if (d.equals("TL")) {
                        CauHoiTL t = new CauHoiTL();
                        String dokho = in.readLine();
                        String tencauhoi = in.readLine();
                        String dapan = in.readLine();
                        t.settenCauHoi(tencauhoi);
                        t.setdapAn(dapan);
                        t.setdoKho(dokho);
                        t.setmonHoc(monhoc);
                        t.setchuong(c);
                        ch.themCauHoi(t);

                    }
                    d = in.readLine();
                }
                mon1.themChuong(ch);
                c = in.readLine();

            }
            in.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return mon1;
    }

    /**
     * 
     * Ghi 1 arraylist monhoc ra object vao file "monhoc.dat"
     *
     * @param dsmonhoc
     */
    public static void ghiRaObject(ArrayList<MonHoc> dsmonhoc) {
        try {
            
            
            FileOutputStream f = new FileOutputStream("monhoc.dat");
            ObjectOutputStream out = new ObjectOutputStream(f);
            
            
            for (MonHoc mon1 : dsmonhoc) {
                out.writeObject(mon1);
            }
            out.flush();
            out.close();
            f.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * phuong thuc tra ve danh sach cau hoi trong 1 mon
     *
     * @param mon1
     * @return
     */
    public static ArrayList<CauHoi> dsCauHoiMon(MonHoc mon1) {
        ArrayList<CauHoi> dscauhoimon = new ArrayList<CauHoi>();
        for (Chuong chuong11 : mon1.getdsChuong()) {
            for (CauHoiTN e : chuong11.getdsCauHoitn()) {
                dscauhoimon.add(e);
            }
            for (CauHoiTL e : chuong11.getdsCauHoitl()) {
                dscauhoimon.add(e);
            }
        }
        return dscauhoimon;
    }
    public static ArrayList<CauHoiTN>dsCauHoiTNMon(MonHoc mon1){
        ArrayList<CauHoiTN>dsCauHoiTN=new ArrayList<CauHoiTN>();
        for(Chuong chuong11:mon1.getdsChuong()){
            for(CauHoiTN e:chuong11.getdsCauHoitn()){
                dsCauHoiTN.add(e);
            }
            
        }
        return dsCauHoiTN;
    }
    public static ArrayList<CauHoiTL>dsCauHoiTLMon(MonHoc mon1){
        ArrayList<CauHoiTL>dscauhoi=new ArrayList<CauHoiTL>();
        for(Chuong chuong11:mon1.getdsChuong()){
            for(CauHoiTL e:chuong11.getdsCauHoitl()){
                dscauhoi.add(e);
            }
        }
        return dscauhoi;
    }

    /**
     * Tao ngau nhien 1 so trong khoa max min cho truoc
     * </br>return randomNum
     *
     * @param min
     * @param max
     * @return
     */
    public static int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    /**
     * Doc du lieu
     * phuong thu tra ve arraylist monhoc trong file "monhoc.dat"
     *
     * @return dsMonHoc
     */
    public static ArrayList<MonHoc> dsMonHoc() {
        ArrayList<MonHoc> dsmonhoc = new ArrayList<MonHoc>();
        try {
            FileInputStream f = new FileInputStream("monhoc.dat");
            ObjectInputStream in = new ObjectInputStream(f);
            MonHoc mon1 = new MonHoc();
            mon1 = (MonHoc) in.readObject();
            while (mon1 != null) {
                dsmonhoc.add(mon1);
                mon1 = (MonHoc) in.readObject();
            }
            in.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return dsmonhoc;
    }

    /**
     * sinh de thi tu dong cua 1 mon hoc.
     * </br>
     * tra ve 1 de thi
     *
     * @param mon1
     * @param loaide trac nghiem :"Trắc nghiệm", tu luan:"Tự luận", ca trac nghiem va tu
     * luan:"Trắc nghiệm và Tự luận"
     * @param soluongcau
     * @param thutu trac nghiem tu luan rieng ;"rieng" else :"chung"
     * @return
     */
    public static DeThi taoDeThiTuDong(MonHoc mon1, String loaide, int soluongcau, String thutu,String dokho) {
        DeThi de = new DeThi();
        ArrayList<CauHoi> dsCauHoi = NganHangCauHoi.dsCauHoiMon(mon1);
        if (soluongcau > dsCauHoi.size()) {
            return null;
        }
        for (int i = 0; i < dsCauHoi.size(); i++) {         //xao tron danh sach cac cau hoi dau vao
            int j = NganHangCauHoi.rand(0, 1);
            if (j == 1) {
                CauHoi temp = dsCauHoi.get(i);
                dsCauHoi.remove(i);
                dsCauHoi.add(temp);
            }
        }
        ArrayList<CauHoiTN> dsCauHoiTN = new ArrayList<CauHoiTN>();
        ArrayList<CauHoiTL> dsCauHoiTL = new ArrayList<CauHoiTL>();
        for (int i = 0; i < dsCauHoiTL.size(); i++) {       //xao tron cau ho tu luan
            int j = NganHangCauHoi.rand(0, 1);
            if (j == 1) {
                CauHoiTL temp = dsCauHoiTL.get(i);
                dsCauHoiTL.remove(i);
                dsCauHoiTL.add(temp);
            }
        }
        for (int i = 0; i < dsCauHoiTN.size(); i++) {       //xao tron cac cau hoi trac nghiem trong ds cau hoi dau vao 
            int j = NganHangCauHoi.rand(0, 1);
            if (j == 1) {
                CauHoiTN temp = dsCauHoiTN.get(i);
                dsCauHoiTN.remove(i);
                dsCauHoiTN.add(temp);
            }
        }
        for (CauHoi e : dsCauHoi) {
            if (e instanceof CauHoiTN) {
                dsCauHoiTN.add((CauHoiTN) e);
            } else {
                dsCauHoiTL.add((CauHoiTL) e);
            }

        }
       if (loaide.equals("Trắc nghiệm") && soluongcau > dsCauHoiTN.size()) {
            return null;
        }else{
        if (loaide.equals("Tự luận") && soluongcau > dsCauHoiTL.size()) {
            return null;
        }}
        if (loaide.equals("Trắc nghiệm")) {
            int i=0;
            while(de.soLuongCauHoi()<soluongcau){
                if(dokho.equals("Bất kì")){
                    de.themCauHoi(dsCauHoiTN.get(i));
                    i++;
                }else{
                    CauHoiTN ch=dsCauHoiTN.get(i);
                    if(ch.getdoKho().equals(dokho)){
                        de.themCauHoi(ch);
                        i++;
                    }else
                        i++;
                }
                
            }
            
        }else{
        if (loaide.equals("Tự luận")) {
           int i=0;
            while(de.soLuongCauHoi()<soluongcau){
                if(dokho.equals("Bất kì")){
                    de.themCauHoi(dsCauHoiTL.get(i));
                    i++;
                }else{
                    CauHoiTL ch=dsCauHoiTL.get(i);
                    if(ch.getdoKho().equals(dokho)){
                        de.themCauHoi(ch);
                        i++;
                    }else
                        i++;
                }
                
            }
        }else{
        
            int k=0;
            ArrayList<CauHoi> list=new ArrayList<CauHoi>();
            while (list.size()<soluongcau) {
                if(dokho.equals("Bất kì")){
                    list.add(dsCauHoi.get(k));
                    k++;
                }
                else{
                    CauHoi ch=dsCauHoi.get(k);
                    if(ch.getdoKho().equals(dokho)){
                        list.add(ch);
                        k++;
                    }else{
                        k++;
                    }
                        
                        }
                
            }
            if(thutu.equals("riêng")){
                for(CauHoi ch:list){
                    if(ch instanceof CauHoiTN){
                        de.themCauHoi(ch);
                    }
                }
                for(CauHoi ch:list){
                    if(ch instanceof CauHoiTL){
                        de.themCauHoi(ch);
                    }
                }
            }else{
                for(CauHoi ch:list){
                    de.themCauHoi(ch);
                }
            }
            
            
        }
        }
        return de;
        
    }
    /**
     * Ghi ds De thi ra file Object
     * @param dsDeThi 
     */
    public static void ghiDeThiRaObject(ArrayList<DeThi> dsDeThi){
        try{
           FileOutputStream f=new FileOutputStream("dsDe"+dsDeThi.get(0).getmonHoc()+".txt");
           ObjectOutputStream out=new ObjectOutputStream(f);
           out.writeObject(dsDeThi);
           out.flush();
           out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<DeThi> docDSDeThituObject(String tenfile){
        ArrayList<DeThi> dsDeThi=new ArrayList<DeThi>();
        try{
            FileInputStream f=new FileInputStream(tenfile);
            ObjectInputStream in =new ObjectInputStream(f);
           dsDeThi=(ArrayList<DeThi>)in.readObject();
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return dsDeThi;
    }
    /**
     * Cham diem 1 bai thi trac nghiem
     * @param dapanlam
     * @param de
     * @return 
     */
    public static double chamDiemBaiThi(String[]dapanlam,DeThi de){
        double diem=0;
        for(int i=0;i<de.soLuongCauHoi();i++){
            CauHoiTN cauhoi=(CauHoiTN)de.getdsCauHoi().get(i);
            if(dapanlam[i].equals(cauhoi.getStringDapAn())){
                diem+=cauhoi.getdiem();
            }
        }
        return diem;
    }
    /**
     * return cauhoi câu hoi tương đương trong danh sach cau hoi
     * @param ch
     * @param dsCauHoi
     * @return 
     */
    public static CauHoi cauHoiTuongDuong(CauHoi ch,ArrayList<CauHoi> dsCauHoi){
        
        for(int i=0;i<dsCauHoi.size();i++){
        int j=NganHangCauHoi.rand(0,1);
        if(j==1){
            CauHoi temp=dsCauHoi.get(i);
            dsCauHoi.remove(i);
            dsCauHoi.add(temp);
            
        }
        }
        for(int i=0;i<dsCauHoi.size();i++){
            if(dsCauHoi.get(i).getchuong().equals(ch.getchuong())&&dsCauHoi.get(i).getdoKho().equals(ch.getdoKho())){
                return dsCauHoi.get(i);
            }
        }
        return null;
    }
    public static String [] toArrayString_MonHoc(ArrayList<MonHoc> dsMonHoc){
        String []list=new String[dsMonHoc.size()];
        for(int i=0;i<list.length;i++){
            list[i]=dsMonHoc.get(i).gettenMonHoc();
        }
        return list;
    }
    public static String [] toArrayString_dsCauHoiMon(MonHoc monhoc){
        String []list=new String[monhoc.soLuongCauHoi()];
        ArrayList<CauHoi> dsCauHoi=NganHangCauHoi.dsCauHoiMon(monhoc);
        for(int i=0;i<list.length;i++){
            list[i]=dsCauHoi.get(i).gettenCauHoi();
        }
        return list;
    }
    public static String [] toArrayString_dsDapAn(CauHoi cauhoi){
        int soluongdapan;
        if(cauhoi instanceof CauHoiTN){
            soluongdapan=((CauHoiTN) cauhoi).getsoLuongDapAn();
        }
        else{
            soluongdapan=1;
        }
        String list[]=new String [soluongdapan];
        for(int i=0;i<soluongdapan;i++){
            if(cauhoi instanceof CauHoiTN){
                list[i]=((CauHoiTN) cauhoi).getdsDapAn().get(i);
            }
            else{
                list[i]=((CauHoiTL)cauhoi).getDapAn();
            }
    }
        return list;
    }
   
   public static void main(String[] args) {
        System.out.println("Thanh cong");
        ArrayList<MonHoc> dsMonHoc = new ArrayList<MonHoc>();
        MonHoc mon1 = new MonHoc();
        mon1 = NganHangCauHoi.docFileText("toanrr.txt");
        MonHoc mon2 = new MonHoc();
        mon2 = NganHangCauHoi.docFileText("laptrinhhuongdoituong.txt");
        dsMonHoc.add(mon1);
        dsMonHoc.add(mon2);
        NganHangCauHoi.ghiRaObject(dsMonHoc);
    }

}
