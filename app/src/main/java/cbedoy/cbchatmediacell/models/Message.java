package cbedoy.cbchatmediacell.models;

/**
 * Created by bedoy on 5/5/16.
 */
public class Message
{
    private String nickname;
    private String date;
    private String message;
    private String avatar;
    private Metadata metadata;
    private int resource;

    public Metadata getMetadata() {
        return metadata;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getNickname() {
        return nickname;
    }

    public int getResource() {
        return resource;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
