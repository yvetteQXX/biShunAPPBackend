package WeChat;

import Util.CommonUtil;
import Util.HttpUtils;
import net.sf.json.JSONObject;

/**
 * Created by hasee on 2018/7/12.
 */
public class WeChatLoadUtil {
    private static WeChatOauth2Token wat = new WeChatOauth2Token();
    private static WeChatUserInfo userInfo = new WeChatUserInfo();

    public static WeChatOauth2Token getAccess(String code){
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=" + Constants.WEIXIN_APP_ID +
                "&secret=" + Constants.WEIXIN_APP_SECRET +
                "&code=" + code +
                "&grant_type=authorization_code";
        JSONObject jsonObject = CommonUtil.httpsRequest(url,"GET",null);
        if(null != jsonObject){
            try{
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setOpenId(jsonObject.getString("openid"));
//                user.setNickName(jsonObject.getString("nickname"));
//                user.setHeadImgUrl(jsonObject.getString("headimgurl"));
//                user.setOpenId(jsonObject.getString("openid"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return wat;
    }

    public static WeChatUserInfo getUserInfo(String accessToken,String openId){
        // ƴ�������ַ
        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // ͨ����ҳ��Ȩ��ȡ�û���Ϣ
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                // �û��ı�ʶ
                userInfo.setOpenId(jsonObject.getString("openid"));
                // �ǳ�
//                userInfo.setNickname(jsonObject.getString("nickname"));
                userInfo.setNickName(jsonObject.getString("nickname"));
                //�Ա�
                userInfo.setSex(jsonObject.getString("sex"));
                // �û�ͷ��
                userInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
            } catch (Exception e) {
                userInfo = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                return userInfo;
            }
        }
        return userInfo;
    }
}
