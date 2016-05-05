package cbedoy.cbchatmediacell;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cbedoy.cbchatmediacell.models.Message;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bedoy on 5/5/16.
 */
public class ChatMessageCell extends AbstractAdapter<Message>
{
    public ChatMessageCell(List<Message> dataModel) {
        super(dataModel);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;

        if (convertView == null)
        {
            convertView = Utils.viewFromResource(R.layout.chat_message_cell);

            viewHolder = new ViewHolder();
            viewHolder.avatarView = (CircleImageView) convertView.findViewById(R.id.chat_avatar_view);
            viewHolder.nicknameView = (TextView) convertView.findViewById(R.id.chat_nickname_view);
            viewHolder.dateView = (TextView) convertView.findViewById(R.id.chat_date_view);
            viewHolder.messageView = (TextView) convertView.findViewById(R.id.chat_message_view);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Message item = getElementAtIndex(position);

        viewHolder.nicknameView.setText(item.getNickname());
        viewHolder.dateView.setText(item.getDate());
        viewHolder.avatarView.setImageResource(item.getResource());

        return convertView;
    }

    private class ViewHolder
    {
        CircleImageView avatarView;
        TextView nicknameView;
        TextView dateView;
        TextView messageView;
    }
}
