package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author CJYong
 * @create 2021-07-27 11:01
 */
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取要下载的内容
        String downloadFilename = "3.jpg";

        //2.读取要下载的内容(通过servletContext对象可以读取)
        ServletContext  servletContext = getServletContext();
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFilename);
        System.out.println("下载的文件类型为：" + mimeType);

        //4.在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        //5.告诉客户端收到的数据是用于下载使用（还是使用响应头）
//        Content-Disposition 响应头表示收到的数据怎么处理   URLEncoder.encode解决附件中文名乱码的问题
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(downloadFilename,"UTF-8"));


        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFilename);
        //获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();


        //3.把下载的文件内容回传给客户端
        //读取输入流中的全部数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);



    }

}
