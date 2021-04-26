package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollSettingsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getLongPollSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getLongPollSettings">https://vk.com/dev/groups.getLongPollSettings</a>
 */
public class GroupsGetLongPollSettings extends GetMethod<GroupsGetLongPollSettingsResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    public GroupsGetLongPollSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetLongPollSettings();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    @Override
    protected Class<? extends GroupsGetLongPollSettingsResult> getResultType() {
        return GroupsGetLongPollSettingsResult.class;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsGetLongPollSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
