package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.adapters.deserializers.MessagesSendResultDeserializer;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.helpers.attachments.Attachable;
import api.longpoll.bots.helpers.attachments.MessageDocAttachable;
import api.longpoll.bots.helpers.attachments.MessagePhotoAttachable;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.Forward;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.Template;
import api.longpoll.bots.model.objects.additional.VkAttachment;
import api.longpoll.bots.model.response.GenericResponse;
import api.longpoll.bots.suppliers.PeerIdSupplier;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.send</b> method.
 * <p>
 * Sends a message.
 *
 * @see <a href="https://vk.com/dev/messages.send">https://vk.com/dev/messages.send</a>
 */
public class Send extends VkMethod<Send.Response> {
    /**
     * List of objects to attach.
     */
    private final List<Attachable> attachables = new ArrayList<>();

    /**
     * Supplies {@code peer_id}.
     */
    private final PeerIdSupplier peerIdSupplier = new PeerIdSupplier();

    public Send(String accessToken) {
        super(accessToken);
        addParam("random_id", (int) System.currentTimeMillis());
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("messages.send");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    @Override
    public Response execute() throws VkApiException {
        List<VkAttachment> attachments = new ArrayList<>();
        for (Attachable attachable : attachables) {
            attachments.add(attachable.attach());
        }
        if (!attachments.isEmpty()) {
            setAttachment(attachments);
        }
        return super.execute();
    }

    public Send addPhoto(File photo) {
        attachables.add(new MessagePhotoAttachable(
                photo,
                peerIdSupplier,
                getParams().get("access_token")
        ));
        return this;
    }

    public Send addPhoto(Path photo) {
        return addPhoto(photo.toFile());
    }

    public Send addDoc(File doc) {
        attachables.add(new MessageDocAttachable(
                doc,
                peerIdSupplier,
                getParams().get("access_token")
        ));
        return this;
    }

    public Send addDoc(Path doc) {
        return addDoc(doc.toFile());
    }

    public Send setAttachment(VkAttachment... vkAttachments) {
        return setAttachment(Arrays.asList(vkAttachments));
    }

    public Send setAttachment(List<VkAttachment> vkAttachments) {
        return setAttachment(toCommaSeparatedValues(vkAttachments));
    }

    public Send setAttachment(String attachment) {
        return addParam("attachment", attachment);
    }

    public Send setUserId(int userId) {
        peerIdSupplier.setPeerId(userId);
        return addParam("user_id", userId);
    }

    public Send setRandomId(int randomId) {
        return addParam("random_id", randomId);
    }

    public Send setPeerId(int peerId) {
        peerIdSupplier.setPeerId(peerId);
        return addParam("peer_id", peerId);
    }

    public Send setDomain(String domain) {
        return addParam("domain", domain);
    }

    public Send setChatId(int chatId) {
        return addParam("chat_id", chatId);
    }

    public Send setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public Send setUserIds(List<Integer> userIds) {
        return addParam("user_ids", toCommaSeparatedValues(userIds));
    }

    public Send setMessage(String message) {
        return addParam("message", message);
    }

    public Send setLatitude(float latitude) {
        return addParam("lat", latitude);
    }

    public Send setLongitude(float longitude) {
        return addParam("long", longitude);
    }

    public Send setReplyTo(int replyTo) {
        return addParam("reply_to", replyTo);
    }

    public Send setForwardMessages(Integer... forwardMessages) {
        return setForwardMessages(Arrays.asList(forwardMessages));
    }

    public Send setForwardMessages(List<Integer> forwardMessages) {
        return addParam("forward_messages", toCommaSeparatedValues(forwardMessages));
    }

    public Send setStickerId(int stickerId) {
        return addParam("sticker_id", stickerId);
    }

    public Send setDontParseLinks(boolean dontParseLinks) {
        return addParam("dont_parse_links", dontParseLinks ? 1 : 0);
    }

    public Send setDisableMentions(boolean disableMentions) {
        return addParam("disable_mentions", disableMentions ? 1 : 0);
    }

    public Send setKeyboard(Keyboard keyboard) {
        return addParam("keyboard", keyboard);
    }

    public Send setTemplate(Template template) {
        return addParam("template", template);
    }

    public Send setForward(Forward forward) {
        return addParam("forward", getGson().toJson(forward));
    }

    public Send setPayload(JsonElement payload) {
        return addParam("payload", payload);
    }

    @Override
    public Send addParam(String key, Object value) {
        return (Send) super.addParam(key, value);
    }

    /**
     * Result to <b>messages.send</b> request.
     */
    @JsonAdapter(MessagesSendResultDeserializer.class)
    public static class Response extends GenericResponse<Object> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Peer ID.
             */
            @SerializedName("peer_id")
            private Integer peerId;

            /**
             * Message ID.
             */
            @SerializedName("message_id")
            private Integer messageId;

            /**
             * Error message, if message is not delivered.
             */
            @SerializedName("error")
            private String error;

            public Integer getPeerId() {
                return peerId;
            }

            public void setPeerId(Integer peerId) {
                this.peerId = peerId;
            }

            public Integer getMessageId() {
                return messageId;
            }

            public void setMessageId(Integer messageId) {
                this.messageId = messageId;
            }

            public String getError() {
                return error;
            }

            public void setError(String error) {
                this.error = error;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "peerId=" + peerId +
                        ", messageId=" + messageId +
                        ", error='" + error + '\'' +
                        '}';
            }
        }
    }
}
