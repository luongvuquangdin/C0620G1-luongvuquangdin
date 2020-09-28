import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product=request.getParameter("Product");
        String price=request.getParameter("Price");
        String percent=request.getParameter("Percent");
        double DiscountAmount=Integer.parseInt(price)*Integer.parseInt(percent)*0.01;
        double amount=Integer.parseInt(price)-DiscountAmount;
        request.setAttribute("discount",String.valueOf(DiscountAmount));
        request.setAttribute("amount",String.valueOf(amount));
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
