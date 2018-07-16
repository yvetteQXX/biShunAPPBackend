package WeChat;

/**
 * Created by hasee on 2018/7/12.
 */
public class WeChatOauth2Token {
    // ��ҳ��Ȩ�ӿڵ���ƾ֤
    private String accessToken;
    // ƾ֤��Чʱ��
    private int expiresIn;
    // ����ˢ��ƾ֤
    private String refreshToken;
    // �û���ʶ
    private String openId;
    // �û���Ȩ������
    private String scope;

    public WeChatOauth2Token(){
        accessToken="";
        expiresIn = 0;
        refreshToken = "";
        openId = "";
        scope = "";
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
