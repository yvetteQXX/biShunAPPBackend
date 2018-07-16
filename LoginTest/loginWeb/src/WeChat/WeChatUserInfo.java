package WeChat;

/**
 * Created by hasee on 2018/7/12.
 */
public class WeChatUserInfo {
    private String openId;
    private String nickName;
    private String headImgUrl;
    private String sex;

    public WeChatUserInfo() {
        openId = "remoteID";
        nickName = "remoteName";
        headImgUrl = "remoteUrl";
        sex = "remoteSex";
    }

    public WeChatUserInfo(String openId, String nickName, String headImgUrl) {
        this.openId = openId;
        this.nickName = nickName;
        this.headImgUrl = headImgUrl;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String displayInfo(){
        String displayInfoString = "\"name\":\"" + nickName + "\\\\," + "\\\\avatarURL\\\\:\\\\" + headImgUrl+"\\\\";
        return displayInfoString;
    }
}
