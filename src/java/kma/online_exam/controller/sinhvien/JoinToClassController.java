/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kma.online_exam.controller.sinhvien;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kma.online_exam.Utils.AppUtils;
import kma.online_exam.dao.LophocDao;
import kma.online_exam.models.Lophoc;
import kma.online_exam.models.Sinhvien;
import kma.online_exam.models.SinhvienLop;
import kma.online_exam.models.UserAccount;

/**
 *
 * @author KK
 */
@WebServlet(name = "JoinToClassController", urlPatterns = {"/JoinToClass"})
public class JoinToClassController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            RequestDispatcher rd = request.getRequestDispatcher("views/sinhvien/JoinToClass.jsp");
            rd.forward(request, response);   
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        UserAccount loginedUser = AppUtils.getLoginedUser(request.getSession());
        String usnameLogined = "";
        if(loginedUser != null) usnameLogined = loginedUser.getUsername();
        
        String action = request.getParameter("action");
        try {
            if(action == null) doGet(request, response);
            else if(action.equals("joinClass")){
                int classid = Integer.parseInt(request.getParameter("classID"));
                String pass = request.getParameter("matkhau");
                
                LophocDao dao = new LophocDao();
                if(dao.checkJoin(classid, pass)){
                    
                    //Ki???m tra Sinh vi??n c?? trong l???p ch??a
                    if(dao.isExistSvTrongLop(classid, usnameLogined)){
                        String mes = "B???n ???? tham gia l???p h???c n??y r???i.";
                        request.setAttribute("message", mes);
                        RequestDispatcher rd = request.getRequestDispatcher("views/sinhvien/JoinToClass.jsp");
                        rd.forward(request, response);
                    }
                    else{ //them sv vao lop  
                        Lophoc lop = new Lophoc();
                        lop.setClassid(classid);

                        Sinhvien sv = new Sinhvien();
                        sv.setMasv(usnameLogined);

                        SinhvienLop svlop = new SinhvienLop();
                        svlop.setLophoc(lop);
                        svlop.setSinhvien(sv);
                        dao.insertSvToLophoc(svlop); //th??m c??? v??o b???ng KQ
                        
                        dao.updateSiso(classid);

                        response.sendRedirect("Classes");
                    }
                    
                }
                else{
                    String mes = "Nh???p sai m?? l???p ho???c m???t kh???u";
                    request.setAttribute("message", mes);
                    RequestDispatcher rd = request.getRequestDispatcher("views/sinhvien/JoinToClass.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
