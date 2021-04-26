package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetCallbackConfirmationCodeResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getCallbackConfirmationCode</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackConfirmationCode">https://vk.com/dev/groups.getCallbackConfirmationCode</a>
 */
public class GroupsGetCallbackConfirmationCode extends GetMethod<GroupsGetCallbackConfirmationCodeResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsGetCallbackConfirmationCode(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetCallbackConfirmationCode();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    @Override
    protected Class<? extends GroupsGetCallbackConfirmationCodeResult> getResultType() {
        return GroupsGetCallbackConfirmationCodeResult.class;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetCallbackConfirmationCode setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
