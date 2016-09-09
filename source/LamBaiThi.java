
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhuuphu
 */
public class LamBaiThi extends javax.swing.JFrame{

    /**
     * Creates new form LamBaiThi
     */
    private DeThi dethi;
    private MonHoc monhoc;
    String []dsCautl;
    
    public LamBaiThi(int selectedIndexMonHoc,int selectedIndexDeThi) {
        this.monhoc=NganHangCauHoi.dsMonHoc().get(selectedIndexMonHoc);
        this.dethi=NganHangCauHoi.docDSDeThituObject("dsDe"+monhoc.gettenMonHoc()+".txt").get(selectedIndexDeThi);
        dsCautl=new String[dethi.soLuongCauHoi()];
       
        
        this.setLayout(new BorderLayout(20,20));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Làm bài thi");
        JPanel tieude=this.creatTieuDe();
        JPanel dscauhoi=this.creatDsCauHoi();
        JPanel nopbai=this.creatNopBai();
        JScrollPane jsp=new JScrollPane(dscauhoi);
        add(tieude,BorderLayout.NORTH);
        add(jsp,BorderLayout.CENTER);
        add(nopbai,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        
    }
    /**
     * tao tieu de cho de thi
     * @return 
     */
    private JPanel creatTieuDe(){
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,2,5,5));
        JLabel tendethi=new JLabel("Đề thi môn:"+this.dethi.getmonHoc());
        JLabel thoigian=new JLabel("Thời gian:"+this.dethi.getthoiGian()+"phút");
        panel.add(tendethi);
        panel.add(thoigian);
        return panel;
        
    }
    private JPanel creatDsCauHoi(){
        JPanel panel=new JPanel();
        int row=dethi.soLuongCauHoi();
        panel.setLayout(new GridLayout(row,1,10,10));
        ArrayList<CauHoi>dsCauHoi=dethi.getdsCauHoi();
     
        for(int i=0;i<row;i++){
            if(dsCauHoi.get(i) instanceof CauHoiTN){
                panel.add(this.creatCauHoiTN((CauHoiTN)dsCauHoi.get(i), i+1));
                
                
            }else{
                
                panel.add(this.creatCauHoiTL((CauHoiTL)dsCauHoi.get(i), i+1));
            }
        }
        return panel;
        
    }
    private JPanel creatCauHoiTN(CauHoiTN cauhoi,int index){
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(2,1,5,5));
        JTextField jtf=new JTextField("Câu "+index+":"+cauhoi.gettenCauHoi()+"("+cauhoi.getdiem()+")");
        jtf.setEditable(false);
        panel.add(jtf); 
        panel.add(this.creatDapAnTN(cauhoi,index));
        return panel;
    }
    private JPanel creatDapAnTN(CauHoiTN cauhoi,final int index){
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,cauhoi.getsoLuongDapAn(),5,5));
        ButtonGroup bg=new ButtonGroup();
        //String []daABC={"A","B","C","D","E","F"};
        for(int i=0;i<cauhoi.getsoLuongDapAn();i++){
            String da=cauhoi.getdsDapAn().get(i);
            if(da.charAt(0)=='~'){
                da=da.substring(1);
            }
            final JRadioButton jb=new JRadioButton(da);
            jb.addMouseListener(new java.awt.event.MouseListener(){
                
                @Override
               public void mouseClicked(MouseEvent evt){
             
               dsCautl[index-1]=jb.getText();
                
               }
               //public void mouseEvent

                @Override
                public void mouseEntered(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
               // public void mouseEvent

                @Override
                public void mouseExited(MouseEvent e) {
                 //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
               //public void mouseEvent

                @Override
                public void mousePressed(MouseEvent e) {
                 //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                //public void mouseEvent

                @Override
                public void mouseReleased(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                



            });
            bg.add(jb);
            panel.add(jb);
            
        }
        return panel;
    }
    private JPanel creatCauHoiTL(CauHoiTL cauhoi,int index){
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(2,1,5,5));
        JLabel tencauhoi=new JLabel("Câu "+index+":"+cauhoi.gettenCauHoi());
        panel.add(tencauhoi);
        panel.add(this.creatDapAnTL());
        return panel;
    }
    
    private JPanel creatDapAnTL(){
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,1));
        JTextField jtf=new JTextField();
        panel.add(jtf);
        return panel;
    }
    private JPanel creatNopBai(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btn=new JButton("Nộp bài thi");
        btn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               double diem=NganHangCauHoi.chamDiemBaiThi(dsCautl, dethi);
               new DiemLamBai(diem);
               
                      
                  
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        panel.add(btn);
        return panel;
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
