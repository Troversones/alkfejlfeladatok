package hu.alkfejl.servlet;

import com.google.gson.Gson;
import hu.alkfejl.controller.ZeneController;
import hu.alkfejl.model.Zene;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/api/list","/alista"})
public class FindServlet extends HttpServlet {
    public int counter = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Zene zene = new Zene();

        if (req.getParameter("hossz") != null) {
            zene.setHossz(Integer.parseInt(req.getParameter("hossz")));
        }
        zene.setCim(req.getParameter("cim"));
        zene.setEloado(req.getParameter("eloado"));

        ZeneController zc = ZeneController.getInstance(this.getClass());

        Cookie c = new Cookie("request-number",Integer.toString(counter++));
        c.setPath("/");
        c.setMaxAge(999);

        var result = zc.find(zene);
        Gson gson = new Gson();
        String json = gson.toJson(result);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().println(json);
        resp.addCookie(c);

        resp.setStatus(200);

    }
}
