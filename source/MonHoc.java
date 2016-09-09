
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhuuphu
 */
public class MonHoc implements Serializable{
    private String tenMonHoc;
    private String maHocPhan;
    private String gioiThieu;
    private ArrayList<Chuong> dsChuong=new ArrayList<Chuong>();
    private int soLuongChuong;
    public MonHoc(){
        this.tenMonHoc="";
        this.soLuongChuong=dsChuong.size();
    }
    public MonHoc(String tenmonhoc){
        this.tenMonHoc=tenmonhoc;
                
    }
    /**
     * </br>
     * Tao ra 1 doi tuong mon hoc voi 3 tham so:tenmonhoc,mahocphan,gioithieu
     * @param tenmonhoc
     * @param mahocphan
     * @param gioithieu 
     */
    public MonHoc(String tenmonhoc,String mahocphan,String gioithieu){
        this.tenMonHoc=tenmonhoc;
        this.maHocPhan=mahocphan;
        this.gioiThieu=gioithieu;
        
    }
    /**
     * return ten_mon_hoc
     * @return 
     */
    public String gettenMonHoc(){
        return this.tenMonHoc;
    }
    /**
     * set ten_mon_hoc
     * @param tenmonhoc 
     */
    public void settenMonHoc(String tenmonhoc){
        this.tenMonHoc=tenmonhoc;
    }
    public String getmaHocPhan(){
        return this.maHocPhan;
    }
    public void setmaHocPhan(String mahocphan){
        this.maHocPhan=mahocphan;
    }
    public String getgioiThieu(){
        return this.gioiThieu;
    }
    public void setgioiThieu(String gioithieu){
        this.gioiThieu=gioithieu;
    }
    /**
     * return danh sach chuong cua mon hoc
     * @return 
     */
   
    public ArrayList<Chuong> getdsChuong(){
        return  dsChuong;
    }
    public int soLuongChuong(){
        
        
        return dsChuong.size();
    }
                
    
    public boolean xoaChuong(int i){
        if(i<dsChuong.size()){
            dsChuong.remove(i);
            return true;
        }
        else
            return false;
    }
    /**
     * Them chuong vao mon hoc
     * @param chuong 
     */
    public void themChuong(Chuong chuong){
        dsChuong.add(chuong);
    }
    /**
     * return so luong tat ca cac cau hoi ca trac nghiem va tu luan trong mon hoc
     * @return 
     */
    public int soLuongCauHoi(){
        int soluongcauhoi=0;
        for(Chuong ch:dsChuong){
            soluongcauhoi+=ch.getdsCauHoitn().size()+ch.getdsCauHoitl().size();
        }
        return soluongcauhoi;
    }
    public void setdsCauHoi(ArrayList<CauHoi>dsCauHoi){
        
        for(Chuong ch:dsChuong){
            ch.setdsCauHoi(dsCauHoi);
        }
    }
    public void setsoLuongChuong(int sochuong){
        this.soLuongChuong=sochuong;
    }
}
