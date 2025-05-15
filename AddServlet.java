package hu.alkfejl.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import hu.alkfejl.controller.ZeneController;
import hu.alkfejl.model.Zene;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Zene zene = new Gson().fromJson(req.getReader(),Zene.class);

            ZeneController zc = ZeneController.getInstance(this.getClass());

            Cookie[] sutik = req.getCookies();
            if (sutik != null) {
                for (Cookie c : sutik) {
                    if(c.getValue() != null){
                        c.setValue("modded"+c.getValue());
                    }
                }
            }

            if (zc.add(zene)){
                resp.setStatus(200);
            }else{
                resp.setStatus(500);
            }

        }catch (JsonParseException e){
            resp.setStatus(400);
        }

    }
}
