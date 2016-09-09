
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhuuphu
 */
public abstract class CauHoi implements Serializable{
    private String tenCauHoi;
    private String doKho;
    private String chuong;
    private String monHoc;
    private double diem;
    public CauHoi(){
        this.diem=0.5;
        this.doKho="De";
    }
    public CauHoi(String tenCauHoi){
        this.tenCauHoi=tenCauHoi;
    }
    public CauHoi(String monhoc,String chuong,String tencauhoi){
        this.monHoc=monhoc;
        this.chuong=chuong;
        this.tenCauHoi=tencauhoi;
    }
    public CauHoi(String tench,String dokho,String chuong,String monhoc){
        this.tenCauHoi=tench;
        this.doKho=dokho;
        this.chuong=chuong;
        this.monHoc=monhoc;
        this.diem=1.0;
    }
    public void setmonHoc(String monhoc){
        this.monHoc=monhoc;
    }
    public String getmonHoc(){
        return this.monHoc;
    }
    public void settenCauHoi(String tencauhoi){
        this.tenCauHoi=tencauhoi;
    }
    public String gettenCauHoi(){
        return this.tenCauHoi;
    }
    public String getdoKho(){
        return this.doKho;
    }
    public String getchuong(){
        return this.chuong;
    }
    public void setchuong(String chuong){
        this.chuong=chuong;
    }
    public double getdiem(){
        return this.diem;
    }
    public void setdoKho(String dokho){
        this.doKho=dokho;
    }
    public  void setDiem(double diem){
        this.diem=diem;
    }
    public abstract String inCauHoi();
    public abstract String getDapAn();
    public abstract int getsoLuongDapAn();
}
