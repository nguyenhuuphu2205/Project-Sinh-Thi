
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
public class Chuong implements Serializable {
   private String tenChuong;
   private ArrayList<CauHoiTN> dsCauHoitn=new ArrayList<CauHoiTN>();
   private ArrayList<CauHoiTL> dsCauHoitl=new ArrayList<CauHoiTL>();
   private String monHoc;
   public Chuong(){
       this.tenChuong="";
   }
   public Chuong(String tenchuong,String monhoc){
       this.tenChuong=tenchuong;
       this.monHoc=monhoc;
   }
   public String gettenChuong(){
       return tenChuong;
   }
   public ArrayList<CauHoiTN> getdsCauHoitn(){
       return dsCauHoitn;
   }
   public ArrayList<CauHoiTL> getdsCauHoitl(){
       return dsCauHoitl;
   }
   public String getmonHoc(){
       return monHoc;
   }
   
   
   public void settenChuong(String chuong){
       this.tenChuong=chuong;
   }
   public void setmonHoc(String monhoc){
       this.monHoc=monhoc;
}
   public void themCauHoi(CauHoi ch){
       if(ch instanceof CauHoiTN){
           dsCauHoitn.add((CauHoiTN) ch);
       }else{
           dsCauHoitl.add((CauHoiTL)ch);
       }
       
           
       
   }
   public void xoaCauHoiTN(int i){
   if(i>=0&&i<dsCauHoitn.size())
       dsCauHoitn.remove(i);
   }
   public void xoaCauHoiTL(int i){
       if(i>=0&&i<dsCauHoitl.size()){
           dsCauHoitl.remove(i);
       }
   }
   public void inTTinChuong(){
       System.out.println("Chuong"+":"+this.tenChuong+"monhoc:"+this.monHoc);
       for(CauHoiTL i:dsCauHoitl){
           System.out.println(i.inCauHoi());
           
       }
       for(CauHoiTN i:dsCauHoitn){
           System.out.println(i.inCauHoi());
       }
   }
   public void setdsCauHoi(ArrayList<CauHoi>dsCauHoi){
       
   this.dsCauHoitl = new ArrayList<CauHoiTL>();
   this.dsCauHoitn = new ArrayList<CauHoiTN>();
   for(int i=0;i<dsCauHoi.size();i++){
       CauHoi ch=dsCauHoi.get(i);
       if(ch.getchuong().equals(this.tenChuong)){
//               System.out.println(ch.getchuong() + "    " + this.tenChuong);
               this.themCauHoi(ch);
               
           }
       }       
       
   }
   
}
