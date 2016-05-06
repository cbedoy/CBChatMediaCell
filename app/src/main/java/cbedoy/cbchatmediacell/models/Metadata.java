package cbedoy.cbchatmediacell.models;

/**
 * Created by bedoy on 5/5/16.
 */
public class Metadata
{
    private float thumbnailHeight;
    private String title;
    private float thumbnailWidth;
    private String thumbnailURL;
    private String description;
    private String type;
    private String provider;
    private String url;
    private String version;
    private String providerName;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setThumbnailHeight(float thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public void setThumbnailWidth(float thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public float getThumbnailHeight() {
        return thumbnailHeight;
    }

    public float getThumbnailWidth() {
        return thumbnailWidth;
    }

    public String getDescription() {
        return description;
    }

    public String getProvider() {
        return provider;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }


}
