package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>utils.resolveScreenName</b> method.
 * <p>
 * Detects a type of object (e.g., user, community, application) and its ID by screen name.
 *
 * @see <a href="https://vk.com/dev/utils.resolveScreenName">https://vk.com/dev/utils.resolveScreenName</a>
 */
public class ResolveScreenName extends VkMethod<ResolveScreenName.Response> {
    public ResolveScreenName(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("utils.resolveScreenName");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public ResolveScreenName setScreenName(String screenName) {
        return addParam("screen_name", screenName);
    }

    @Override
    public ResolveScreenName addParam(String key, Object value) {
        return (ResolveScreenName) super.addParam(key, value);
    }

    /**
     * Response to <b>utils.resolveScreenName</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Object type (user, group, application).
             */
            @SerializedName("type")
            private String type;

            /**
             * Object ID.
             */
            @SerializedName("object_id")
            private Integer objectId;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Integer getObjectId() {
                return objectId;
            }

            public void setObjectId(Integer objectId) {
                this.objectId = objectId;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "type='" + type + '\'' +
                        ", objectId=" + objectId +
                        '}';
            }
        }
    }
}
