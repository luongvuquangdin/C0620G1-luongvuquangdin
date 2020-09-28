import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InformationServlet",urlPatterns = {"","/Customer"})
public class InformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList=new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội",
                "https://lh3.googleusercontent.com/proxy/c8X_2R2z1jZ5pDYOFgqR2msvJSpDmx8TKV7A6FLO9VpNx8FF9EfwLNQydTKF5WMkIe1cSYlyqlFyCyxdsbSWC8PjsVBJqzB-Tp7dY3KRYO8Xog"));
        customerList.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắt Giang",
                "https://baohoahaudoanhnhan.vn/wp-content/uploads/2018/03/Hoang-Yen-Chipi-1.jpg"));
        customerList.add(new Customer("Nguyên Thái Hòa","1983-08-22","Nam Định",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTtcLLDni4AnsKDYwqcC_NsIhyHmk3BH15XYw&usqp=CAU"));
        customerList.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR6r-qeBL7L-e1LpptUaIoi1hyCEZH6C17cug&usqp=CAU"));
        customerList.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRQgxLk4-LCzHCxHA6s8E-ImCJlJ6evzSsMww&usqp=CAU"));
        request.setAttribute("customerInfomation",customerList);
        request.getRequestDispatcher("display.jsp").forward(request,response);

    }
}
