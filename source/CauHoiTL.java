
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
public class CauHoiTL extends CauHoi implements Serializable {
    private String dapAn;
    public CauHoiTL(){
        super();
        this.dapAn="Khong co dap an";
    }
    public CauHoiTL(String tencauhoi){
        super(tencauhoi);
    }
    public CauHoiTL(String monhoc,String chuong,String tencauhoi){
        super(monhoc,chuong,tencauhoi);
    }
    public String getDapAn(){
        return this.dapAn;
    }
    public void setdapAn(String s){
        this.dapAn=s;
    }
    public String inCauHoi(){
        return gettenCauHoi();
    }
    public int getsoLuongDapAn(){
        return 1;
    }
   
}
