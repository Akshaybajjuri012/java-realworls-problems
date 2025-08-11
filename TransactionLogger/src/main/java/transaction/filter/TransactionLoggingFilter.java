package transaction.filter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
public class TransactionLoggingFilter implements Filter{
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        @SuppressWarnings("unused")
		HttpServletRequest httpRequest = (HttpServletRequest) request;

        String amount = request.getParameter("amount");
        String ipAddress = request.getRemoteAddr();
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("[" + timestamp + "] Transaction Request from IP: "
                + ipAddress + " | Amount: Rs." + amount);

        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {}

}
