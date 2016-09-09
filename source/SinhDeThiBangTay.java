
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
public class SinhDeThiBangTay extends javax.swing.JDialog {

    /**
     * Creates new form SinhDeThiBangTay
     */
    private int selectedIndex;
    private MonHoc monhoc;
    private ArrayList<MonHoc> dsMonHoc = NganHangCauHoi.dsMonHoc();
    private ArrayList<CauHoi> dsCauHoi;
    private ArrayList<CauHoiTN> dsCauHoiTN;
    private ArrayList<CauHoiTL> dsCauHoiTL;
    private DeThi dethi = new DeThi();
    private String loaicauhoi;
    private ArrayList<DeThi> dsDeThi = new ArrayList<DeThi>();

    /**
     * set list ds ten cau hoi vao list
     *
     * @param loaicauhoi
     */
    private void setData_dsCauHoi(String loaicauhoi) {

        if (loaicauhoi.equals("Trắc nghiệm")) {
            String[] dsTenCauHoiTN = new String[dsCauHoiTN.size()];
            for (int i = 0; i < dsTenCauHoiTN.length; i++) {
                dsTenCauHoiTN[i] = dsCauHoiTN.get(i).gettenCauHoi();
            }
            this.jL_dsCauHoi.setListData(dsTenCauHoiTN);

        } else if (loaicauhoi.equals("Tự luận")) {
            String[] dsTenCauHoiTL = new String[dsCauHoiTL.size()];
            for (int i = 0; i < dsTenCauHoiTL.length; i++) {
                dsTenCauHoiTL[i] = dsCauHoiTL.get(i).gettenCauHoi();
            }
            this.jL_dsCauHoi.setListData(dsTenCauHoiTL);
        } else {
            String[] dsTenCauHoi = new String[dsCauHoi.size()];
            for (int i = 0; i < dsTenCauHoi.length; i++) {
                dsTenCauHoi[i] = dsCauHoi.get(i).gettenCauHoi();
            }
            this.jL_dsCauHoi.setListData(dsTenCauHoi);
        }

    }

    /**
     * return cau hoi Được lựa chọn
     *
     * @param selectedIndex
     * @param loaicauhoi
     * @return
     */
    public CauHoi selectedCauHoi(int selectedIndexCauHoi) {
        if (loaicauhoi.equals("Trắc nghiệm")) {
            return dsCauHoiTN.get(selectedIndexCauHoi);
        } else if (loaicauhoi.equals("Tự luận")) {
            return dsCauHoiTL.get(selectedIndexCauHoi);
        } else {
            return dsCauHoi.get(selectedIndexCauHoi);
        }

    }

    /**
     * set thong tin cua cau hoi duoc lua chon ra ô text
     *
     * @param loaicauhoi
     */
    public void setData(int selectedIndexCauHoi, String loaicauhoi1) {

        String a = new String();
        StringBuffer f = new StringBuffer();

        if (loaicauhoi1.equals("Trắc nghiệm")) {
            CauHoiTN ch = dsCauHoiTN.get(selectedIndexCauHoi);

            f.append(ch.inCauHoi());
            f.append("\nThông tin chi tiết \n");
            f.append("Đáp án:" + ch.getDapAn() + "\n");
            f.append("Độ khó:" + ch.getdoKho() + "\n");
            f.append("Chương:" + ch.getchuong());
            f.append("\n Các đáp án có thể xáo trộn được");

        } else if (loaicauhoi1.equals("Tự luận")) {
            CauHoiTL ch = dsCauHoiTL.get(selectedIndexCauHoi);
            f.append(ch.gettenCauHoi() + "\n");
            f.append("Thông tin chi tiết \n");
            f.append("Đáp án:" + ch.getDapAn());
            f.append("Độ khó:" + ch.getdoKho() + "\n");
            f.append("Chương:" + ch.getchuong());
        } else {
            CauHoi ch = dsCauHoi.get(selectedIndexCauHoi);

            f.append(ch.inCauHoi() + "\n");
            f.append("Thông tin chi tiết \n");
            f.append("Đáp án:" + ch.getDapAn());
            f.append("\nChuong:" + ch.getchuong());
            f.append("\nĐộ khó:" + ch.getdoKho());

        }
        a = f.toString();

        this.jTextArea_Thong_tin_cauHoi.setText(a);
    }

    /**
     * set list ds cau hoi de thi
     */
    public void setData_dsCauHoi_deThi() {
        String[] list = new String[dethi.getdsCauHoi().size()];
        for (int i = 0; i < dethi.getdsCauHoi().size(); i++) {
            list[i] = dethi.getdsCauHoi().get(i).gettenCauHoi();
        }
        this.jList_dsCauHoiDeThi.setListData(list);
    }

    public void setData_text_deThi() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Bài thi môn:" + this.dethi.getmonHoc());

        buffer.append("\nKì:" + this.dethi.getloaiKi() + "-Năm học:" + dethi.gethocKi() + "Mã đề:" + dethi.getmaDe());
        buffer.append("\nThời gian" + this.dethi.getthoiGian() + "\n");
        for (int i = 0; i < dethi.getdsCauHoi().size(); i++) {
            buffer.append("Câu " + (i + 1) + "(" + dethi.getdsCauHoi().get(i).getdiem() + "điểm)\n");
            buffer.append(dethi.getdsCauHoi().get(i).inCauHoi() + "\n");

            this.jTextArea_tex_dethi.setText(buffer.toString());
        }
    }

    /**
     * set thong tin ve nam hoc, ki loai de
     */
    private void setThongTinDeThi() {
        this.dethi.sethocKi(this.jText_Nam_hoc.getText());
        Integer i = Integer.valueOf(this.jText_Thoi_gian.getText());
        this.dethi.setthoiGian(i.intValue());
        String ki = new String();
        if (this.jRadio_ki1.isSelected()) {
            ki = "1";

        } else if (this.jRadio_ki2.isSelected()) {
            ki = "2";
        } else {
            ki = "hè";
        }
        this.dethi.setloaiKi(ki);
        dethi.setmonHoc(monhoc.gettenMonHoc());
        dethi.setmaDe(NganHangCauHoi.rand(100, 300));
    }

    private String loaicauhoi_selected() {
        if (this.jRadio_Tat_ca.isSelected()) {
            return "Tất cả";
        } else if (this.jRadio_trac_nghiem.isSelected()) {
            return "Trắc nghiệm";
        } else {
            return "Tự luận";
        }
    }

    public SinhDeThiBangTay(int selectedIndex) {
        this.selectedIndex = selectedIndex;

        this.monhoc = dsMonHoc.get(selectedIndex);
        dsCauHoi = NganHangCauHoi.dsCauHoiMon(monhoc);

        this.dsCauHoiTN = NganHangCauHoi.dsCauHoiTNMon(monhoc);
        this.dsCauHoiTL = NganHangCauHoi.dsCauHoiTLMon(monhoc);
        this.setTitle("Sinh đề thi bằng tay");
        dethi.setmonHoc(monhoc.gettenMonHoc());
        //this.dsDeThi=NganHangCauHoi.docDSDeThituObject("dsDe"+this.monhoc.gettenMonHoc()+".txt");
        initComponents();
        this.setVisible(true);
        this.setLocation(100, 100);
        this.setData_dsCauHoi("Tất cả");
        this.loaicauhoi = "Tất cả";
        setData(0, "Tất cả");
        this.jRadio_Tat_ca.setSelected(true);
        this.setThongTinDeThi();
        this.dsDeThi = NganHangCauHoi.docDSDeThituObject("dsDe" + this.monhoc.gettenMonHoc() + ".txt");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jL_dsCauHoi = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Thong_tin_cauHoi = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jB_Chon_ngau_nhien = new javax.swing.JButton();
        jRadio_Tat_ca = new javax.swing.JRadioButton();
        jRadio_trac_nghiem = new javax.swing.JRadioButton();
        jRadio_Tu_luan = new javax.swing.JRadioButton();
        jB_them_vao_de_thi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTex_Diem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_dsCauHoiDeThi = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_tex_dethi = new javax.swing.JTextArea();
        jLabel_xoa_CauHoi = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jText_Thoi_gian = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jText_Nam_hoc = new javax.swing.JTextField();
        jRadio_ki1 = new javax.swing.JRadioButton();
        jRadio_ki2 = new javax.swing.JRadioButton();
        jRadio_ki_he = new javax.swing.JRadioButton();
        jLabel_Cau_Hoi_tuong_duong = new javax.swing.JLabel();
        jLabel_Xao_tron_cau_hoi = new javax.swing.JLabel();
        jLabel_xuat_ra_file = new javax.swing.JLabel();
        jB_Luu = new javax.swing.JButton();
        jB_Huy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Danh sách câu hỏi");

        jL_dsCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jL_dsCauHoiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jL_dsCauHoi);

        jTextArea_Thong_tin_cauHoi.setColumns(20);
        jTextArea_Thong_tin_cauHoi.setRows(5);
        jScrollPane2.setViewportView(jTextArea_Thong_tin_cauHoi);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Dạng câu hỏi");

        jB_Chon_ngau_nhien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jB_Chon_ngau_nhien.setText("Chọn ngẫu nhiên");
        jB_Chon_ngau_nhien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_Chon_ngau_nhienActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadio_Tat_ca);
        jRadio_Tat_ca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadio_Tat_ca.setText("Tất cả");
        jRadio_Tat_ca.setBorderPainted(true);
        jRadio_Tat_ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadio_Tat_caActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadio_trac_nghiem);
        jRadio_trac_nghiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadio_trac_nghiem.setText("Trắc nghiệm");
        jRadio_trac_nghiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadio_trac_nghiemActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadio_Tu_luan);
        jRadio_Tu_luan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadio_Tu_luan.setText("Tự luận");
        jRadio_Tu_luan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadio_Tu_luanActionPerformed(evt);
            }
        });

        jB_them_vao_de_thi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_them_vao_de_thi.setText("Thêm vào đề");
        jB_them_vao_de_thi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_them_vao_de_thiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Điểm cho câu hỏi");

        jTex_Diem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTex_Diem.setText("0.25");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Câu hỏi trong đề thi");

        jScrollPane3.setViewportView(jList_dsCauHoiDeThi);

        jTextArea_tex_dethi.setColumns(20);
        jTextArea_tex_dethi.setRows(5);
        jScrollPane4.setViewportView(jTextArea_tex_dethi);

        jLabel_xoa_CauHoi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_xoa_CauHoi.setForeground(new java.awt.Color(51, 51, 255));
        jLabel_xoa_CauHoi.setText("<html><u>Xóa khỏi đề thi</html>");
        jLabel_xoa_CauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_xoa_CauHoiMouseClicked(evt);
            }
        });

        jLabel6.setText("Thời gian");

        jLabel7.setText("Năm học");

        jLabel8.setText("Kì");

        jText_Thoi_gian.setText("60");

        jLabel9.setText("phút");

        jText_Nam_hoc.setText("2015-2016");

        buttonGroup2.add(jRadio_ki1);
        jRadio_ki1.setSelected(true);
        jRadio_ki1.setText("1");

        buttonGroup2.add(jRadio_ki2);
        jRadio_ki2.setText("2");

        buttonGroup2.add(jRadio_ki_he);
        jRadio_ki_he.setText("Hè");

        jLabel_Cau_Hoi_tuong_duong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_Cau_Hoi_tuong_duong.setForeground(new java.awt.Color(0, 51, 255));
        jLabel_Cau_Hoi_tuong_duong.setText("<html><u>Câu hỏi tương đương</html>");
        jLabel_Cau_Hoi_tuong_duong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Cau_Hoi_tuong_duongMouseClicked(evt);
            }
        });

        jLabel_Xao_tron_cau_hoi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_Xao_tron_cau_hoi.setForeground(new java.awt.Color(51, 0, 255));
        jLabel_Xao_tron_cau_hoi.setText("<html><u>Xóa trộn câu hỏi trong đề thi<html>");
        jLabel_Xao_tron_cau_hoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Xao_tron_cau_hoiMouseClicked(evt);
            }
        });

        jLabel_xuat_ra_file.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_xuat_ra_file.setForeground(new java.awt.Color(51, 0, 204));
        jLabel_xuat_ra_file.setText("<html><u>Xuất ra file</html>");
        jLabel_xuat_ra_file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_xuat_ra_fileMouseClicked(evt);
            }
        });

        jB_Luu.setBackground(new java.awt.Color(204, 255, 51));
        jB_Luu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jB_Luu.setForeground(new java.awt.Color(255, 51, 51));
        jB_Luu.setText("Lưu");
        jB_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_LuuActionPerformed(evt);
            }
        });

        jB_Huy.setBackground(new java.awt.Color(102, 255, 255));
        jB_Huy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jB_Huy.setForeground(new java.awt.Color(255, 0, 0));
        jB_Huy.setText("Hủy");
        jB_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_HuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadio_Tat_ca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadio_trac_nghiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadio_Tu_luan))
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(0, 932, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Cau_Hoi_tuong_duong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_xoa_CauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jB_Chon_ngau_nhien, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_xuat_ra_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel_Xao_tron_cau_hoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTex_Diem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(339, 339, 339)
                                                .addComponent(jB_them_vao_de_thi)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jB_Luu)
                                .addGap(70, 70, 70)
                                .addComponent(jB_Huy)
                                .addGap(287, 287, 287))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jText_Nam_hoc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadio_ki1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadio_ki2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadio_ki_he))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jText_Thoi_gian)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(264, 264, 264)))
                        .addGap(716, 716, 716))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_Chon_ngau_nhien)
                            .addComponent(jB_them_vao_de_thi)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTex_Diem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadio_Tat_ca)
                            .addComponent(jRadio_trac_nghiem)
                            .addComponent(jRadio_Tu_luan))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_xoa_CauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Cau_Hoi_tuong_duong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jText_Thoi_gian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jText_Nam_hoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_xuat_ra_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Xao_tron_cau_hoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jRadio_ki1)
                            .addComponent(jRadio_ki2)
                            .addComponent(jRadio_ki_he))
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_Huy)
                            .addComponent(jB_Luu)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadio_trac_nghiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadio_trac_nghiemActionPerformed
        // TODO add your handling code here:
        this.loaicauhoi = "Trắc nghiệm";
        this.setData_dsCauHoi("Trắc nghiệm");

    }//GEN-LAST:event_jRadio_trac_nghiemActionPerformed

    private void jRadio_Tu_luanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadio_Tu_luanActionPerformed
        // TODO add your handling code here:
        this.loaicauhoi = "Tự luận";
        this.setData_dsCauHoi("Tự luận");
    }//GEN-LAST:event_jRadio_Tu_luanActionPerformed

    private void jRadio_Tat_caActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadio_Tat_caActionPerformed
        // TODO add your handling code here:
        this.loaicauhoi = "Tất cả";
        this.setData_dsCauHoi("Tất cả");

    }//GEN-LAST:event_jRadio_Tat_caActionPerformed

    private void jL_dsCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jL_dsCauHoiMouseClicked
        // TODO add your handling code here:
        int selectedCauHoi = this.jL_dsCauHoi.getSelectedIndex();

        this.setData(selectedCauHoi, this.loaicauhoi);

    }//GEN-LAST:event_jL_dsCauHoiMouseClicked

    private void jB_Chon_ngau_nhienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_Chon_ngau_nhienActionPerformed
        // TODO add your handling code here:
        int random;
        if (loaicauhoi.equals("Trắc nghiệm")) {
            random = NganHangCauHoi.rand(0, dsCauHoiTN.size() - 1);
        } else if (loaicauhoi.equals("Tự luận")) {
            random = NganHangCauHoi.rand(0, dsCauHoiTL.size() - 1);
        } else {
            random = NganHangCauHoi.rand(0, dsCauHoi.size() - 1);
        }
        this.jL_dsCauHoi.setSelectedIndex(random);
        setData(random, loaicauhoi);

    }//GEN-LAST:event_jB_Chon_ngau_nhienActionPerformed

    private void jB_them_vao_de_thiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_them_vao_de_thiActionPerformed
        // TODO add your handling code here:
        this.setThongTinDeThi();
        CauHoi ch = this.selectedCauHoi(this.jL_dsCauHoi.getSelectedIndex());
        Double i = Double.valueOf(this.jTex_Diem.getText());
        ch.setDiem(i.doubleValue());
        dethi.themCauHoi(ch);
        this.setData_dsCauHoi_deThi();
        this.setData_text_deThi();

    }//GEN-LAST:event_jB_them_vao_de_thiActionPerformed

    private void jLabel_xoa_CauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_xoa_CauHoiMouseClicked
        // TODO add your handling code here:
        int selectedCauHoi = this.jList_dsCauHoiDeThi.getSelectedIndex();
        dethi.xoaCauHoi(selectedCauHoi);
        this.setData_dsCauHoi_deThi();
        this.setData_text_deThi();
    }//GEN-LAST:event_jLabel_xoa_CauHoiMouseClicked

    private void jLabel_Cau_Hoi_tuong_duongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Cau_Hoi_tuong_duongMouseClicked
        // TODO add your handling code here:
        CauHoi ch = this.selectedCauHoi(this.jList_dsCauHoiDeThi.getSelectedIndex());
        CauHoi temp = NganHangCauHoi.cauHoiTuongDuong(ch, dsCauHoi);
        if (temp != null) {
            dethi.suaCauHoi(this.jList_dsCauHoiDeThi.getSelectedIndex(), temp);
        }
        this.setData_dsCauHoi_deThi();
        this.setData_text_deThi();
    }//GEN-LAST:event_jLabel_Cau_Hoi_tuong_duongMouseClicked

    private void jLabel_Xao_tron_cau_hoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Xao_tron_cau_hoiMouseClicked
        // TODO add your handling code here:
        dethi.daoCauHoi();
        this.setData_dsCauHoi_deThi();
        this.setData_text_deThi();
    }//GEN-LAST:event_jLabel_Xao_tron_cau_hoiMouseClicked

    private void jLabel_xuat_ra_fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_xuat_ra_fileMouseClicked
        // TODO add your handling code here:
        dethi.inDeThi();
        dethi.inDapAn();
    }//GEN-LAST:event_jLabel_xuat_ra_fileMouseClicked

    private void jB_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_LuuActionPerformed
        // TODO add your handling code here:
        dsDeThi.add(dethi);
        NganHangCauHoi.ghiDeThiRaObject(dsDeThi);
        this.dispose();
    }//GEN-LAST:event_jB_LuuActionPerformed

    private void jB_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_HuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jB_HuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jB_Chon_ngau_nhien;
    private javax.swing.JButton jB_Huy;
    private javax.swing.JButton jB_Luu;
    private javax.swing.JButton jB_them_vao_de_thi;
    private javax.swing.JList<String> jL_dsCauHoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Cau_Hoi_tuong_duong;
    private javax.swing.JLabel jLabel_Xao_tron_cau_hoi;
    private javax.swing.JLabel jLabel_xoa_CauHoi;
    private javax.swing.JLabel jLabel_xuat_ra_file;
    private javax.swing.JList<String> jList_dsCauHoiDeThi;
    private javax.swing.JRadioButton jRadio_Tat_ca;
    private javax.swing.JRadioButton jRadio_Tu_luan;
    private javax.swing.JRadioButton jRadio_ki1;
    private javax.swing.JRadioButton jRadio_ki2;
    private javax.swing.JRadioButton jRadio_ki_he;
    private javax.swing.JRadioButton jRadio_trac_nghiem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTex_Diem;
    private javax.swing.JTextArea jTextArea_Thong_tin_cauHoi;
    private javax.swing.JTextArea jTextArea_tex_dethi;
    private javax.swing.JTextField jText_Nam_hoc;
    private javax.swing.JTextField jText_Thoi_gian;
    // End of variables declaration//GEN-END:variables
}
