import WeChat.WeChatLoadUtil;
import WeChat.WeChatOauth2Token;
import WeChat.WeChatUserInfo;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hasee on 2018/7/12.
 */
@WebServlet(name = "WeChatServlet")
public class WeChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String username = "";
        final String code = request.getParameter("code");


        WeChatOauth2Token wat;
        wat = WeChatLoadUtil.getAccess(code);

        String accesToken = wat.getAccessToken();
        String openid = wat.getOpenId();
//        out.print("openid:" + wat.getOpenId() + " ; accesstoken:" + wat.getAccessToken());

        WeChatUserInfo userInfo;
        userInfo = WeChatLoadUtil.getUserInfo(accesToken, openid);
//        out.print(userInfo.displayInfo());
        if(userInfo != null)
            out.print("\"name\":\"" + userInfo.getNickName() + "\"," + "\"avatarURL\":\"" + userInfo.getHeadImgUrl()+"\",");
//            out.print("nickName:" + userInfo.getNickName() + "headImageUrl" + userInfo.getHeadImgUrl());
//        out.print("code:" + code);

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doPost(request,response);
    }
}
