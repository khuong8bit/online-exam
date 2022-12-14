/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kma.online_exam.controller.giaovien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kma.online_exam.dao.DethiDao;
import kma.online_exam.dao.KetquaDao;
import kma.online_exam.dao.LophocDao;
import kma.online_exam.models.Dethi;
import kma.online_exam.models.Ketqua;
import kma.online_exam.models.Lophoc;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author KK
 */
@WebServlet(name = "ExportExcelController", urlPatterns = {"/ExportToExcel"})
public class ExportExcelController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int classid = Integer.parseInt(request.getParameter("classID"));
        int examid = Integer.parseInt(request.getParameter("examID"));
        KetquaDao dao = new KetquaDao();
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Bangdiem");
        HSSFCellStyle style = createStyleForTitle(workbook);
        
        try {
            List<Ketqua> list = dao.listKetquaDethiLop(examid, classid);
            
            if(list.size() == 0){
                String message = "Kh??ng c?? d??? li???u. L???p n??y ch??a c?? sinh vi??n n??o.";
                request.setAttribute("message", message);
                KetquaDao kqdao = new KetquaDao();
                DethiDao dedao = new DethiDao();
                LophocDao lopdao = new LophocDao();
                
                //L???y danh s??ch k???t qu???
                List<Ketqua> listkq = kqdao.listKetquaDethiLop(examid, classid);
                request.setAttribute("listKetqua", listkq);

                //L???y th??ng tin ????? thi
                Dethi de = dedao.findDethiById(examid);
                request.setAttribute("dethi", de);

                //L???y th??ng tin l???p
                Lophoc lop = lopdao.findLophocById(classid);
                request.setAttribute("lophoc", lop);
                
                RequestDispatcher rd = request.getRequestDispatcher("views/giaovien/viewResult.jsp");
                rd.forward(request, response);
            }
            
            for(Ketqua kq : list){
                System.out.println(kq.getSinhvien().getHoten() + " | " + kq.getDiem());
            }

            int rownum = 0;
            Cell cell;
            Row row;

            row = sheet.createRow(rownum);

             // STT
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell.setCellStyle(style);

             // M?? SV
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("M?? SV");
            cell.setCellStyle(style);

             // H??? v?? t??n
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("H??? v?? t??n");
            cell.setCellStyle(style);

             // Ng??y thi
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ng??y thi");
            cell.setCellStyle(style);

             // Th???i gian l??m b??i
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("TG l??m b??i");
            cell.setCellStyle(style);

             // ??i???m
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("??i???m");
            cell.setCellStyle(style);
            
             // Note
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Note");
            cell.setCellStyle(style);
            
            for(Ketqua kq : list){
                rownum++;
                row = sheet.createRow(rownum);

                 // STT
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(rownum);

                 // M?? SV
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(kq.getSinhvien().getMasv());

                 // H??? v?? t??n
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(kq.getSinhvien().getHoten());
                
                if(kq.getNgaythi()!= null){
                    // Ng??y thi
                    cell = row.createCell(3, CellType.STRING);
                    String ngaythi = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(kq.getNgaythi());
                    cell.setCellValue(ngaythi);

                     // Th???i gian l??m b??i
                    cell = row.createCell(4, CellType.STRING);
                    int phut = kq.getTglambai()/60;
                    int giay = kq.getTglambai()%60;
                    cell.setCellValue(phut + " ph??t " + giay + " gi??y");

                     // ??i???m
                    cell = row.createCell(5, CellType.NUMERIC);
                    cell.setCellValue(kq.getDiem());
                }
                // Note C???m thi
                cell = row.createCell(6, CellType.NUMERIC);
                if(kq.isCamthi() == true)
                    cell.setCellValue("C???m thi");
            }
            
            for(int i = 0; i <= 5 ; i++) { 
                //T??? ?????ng thay ?????i k??ch th?????c c???t
                sheet.autoSizeColumn(i);
            }

            String path = request.getServletContext().getRealPath("") + "/files";
            String filename = "Bangdiem" + classid + examid + ".xls";
            String filepath = path + "/" + filename;
            File file = new File(filepath);
            System.out.println(file.getParentFile());
            
            
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
            System.out.println("Exported bang diem: " + file.getAbsolutePath());
            outFile.close();
            workbook.close();
            
            
            //Download
            OutputStream out = response.getOutputStream();

            response.setContentType("text/html");
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition",
                            "attachment; filename=" + filename);
            FileInputStream in = new FileInputStream(filepath);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
            
//            String URL = "ViewResult?classID=" + classid
//                    + "&examID=" +examid;
//            response.sendRedirect(URL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

    }

}
