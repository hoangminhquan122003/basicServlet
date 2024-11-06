/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import database.KhachHangDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.KhachHang;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

/**
 *
 * @author Admin
 */
@WebServlet(name = "thaydoianh", urlPatterns = {"/thay-doi-anh"})
public class thaydoianh extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        KhachHang kh=(KhachHang) session.getAttribute("khachHang");
        if(kh!=null){
            try {
                String folder=getServletContext().getRealPath("avatar");
                File file;
                int maxFileSize=1000*1024;
                int maxMemSize=1000*1024;
                String contentType=request.getContentType();
                if(contentType.indexOf(contentType)>=0){
                    DiskFileItemFactory factory= new DiskFileItemFactory();
                    factory.setSizeThreshold(maxMemSize);
                    ServletFileUpload upload= new ServletFileUpload(factory);
                    upload.setSizeMax(maxFileSize);
                    List<FileItem> files= upload.parseRequest(request);
                    for (FileItem file1 : files) {
                        if(!file1.isFormField()){
                            String fileName=System.currentTimeMillis()+file1.getName();
                            String path =folder+"\\"+fileName;
                            file= new File(path);
                            file1.write(file);
                            kh.setThayDoiAnh(fileName);
                            KhachHangDAO khDAO=new KhachHangDAO();
                            khDAO.updateImage(kh);
                            kh=khDAO.selectById(kh);
                        }else{
                            String name=file1.getFieldName();
                            String value=file1.getString();
                            System.out.println(name+":"+value);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
