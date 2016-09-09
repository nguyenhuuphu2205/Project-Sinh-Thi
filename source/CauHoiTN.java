
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
public class CauHoiTN extends CauHoi implements Serializable {
    private ArrayList<String> dsDapAn=new ArrayList<String>();
    private int soLuongDapAn;
    private String dapAn;
    public CauHoiTN(){
        super();
        this.soLuongDapAn=4;
    }
    public CauHoiTN(String tencauhoi){
        super(tencauhoi);
    }
    public CauHoiTN(String monhoc,String chuong,String tencauhoi){
        super(monhoc,chuong,tencauhoi);
    }
    public void setdapAn(int i,String dapan){
        this.dsDapAn.set(i, dapan);
    }
    public int getsoLuongDapAn(){
        return dsDapAn.size();
    }
    public ArrayList<String> getdsDapAn(){
         return this.dsDapAn;
    }
    public void setsoLuongDapAn(int soluongdapan){
        this.soLuongDapAn=soluongdapan;
    }
    
    public void themDapAn(String da){
        this.dsDapAn.add(da);
    }
    public void xoaDapAn(int i){
        if(i<dsDapAn.size())
            dsDapAn.remove(i);
    }
    public String getDapAn(){
        String dsDA="ABCDEFGHIJK";
        int i=0;
        for(String e:dsDapAn){
            if(e.charAt(0)=='~')
                    return dsDA.substring(i, i+1);
            i++;
        
        }
        return "";
    }
    public String getStringDapAn(){
        for(String da:dsDapAn){
            if(da.charAt(0)=='~'){
                return da.substring(1);
            }
        }
        return "";
    }
    public void getdapAn(int i){
        this.dapAn=dsDapAn.get(i);
    }
    public String inCauHoi(){
        String []dsDA={"A","B","C","D","E","F"};
        StringBuffer e=new StringBuffer();
        e.append(gettenCauHoi());
        e.append("\n");
        for(int i=0;i<dsDapAn.size();i++){
            e.append(dsDA[i]);
            e.append(".");
            String s=dsDapAn.get(i);
            if(s.charAt(0)=='~')
                e.append(s.substring(1));
            else
                e.append(s);
           e.append("\n");
        }
        String e1=e.toString();
        return e1;
    }
    
    public void daoDapAn(){
        for(int i=0;i<this.dsDapAn.size();i++){
            int j=NganHangCauHoi.rand(0, 1);
            if(j==1){
                String temp=dsDapAn.get(i);
                dsDapAn.remove(i);
                dsDapAn.add(temp);
            }
        }
    }
   
   
    
}
