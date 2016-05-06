package cbedoy.cbchatmediacell;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cbedoy.cbchatmediacell.models.Message;

public class MainActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_view_controller);

        ChatMessageCell chatMessageCell = new ChatMessageCell(createFakeInformation());

        listView = (ListView) findViewById(R.id.chat_list_view);

        listView.setAdapter(chatMessageCell);

        EmbedlyService.init();

        EmbedlyService.scrappingWithUrl("https://www.facebook.com/");

    }

    private List<Message> createFakeInformation()
    {
        List<Message> list = new ArrayList<>();
        Message message;
        message = new Message();
        message.setDate("One day ago");
        message.setMessage(getString(R.string.LoremTextSmall));
        message.setNickname("Paulina Robledo");
        message.setResource(R.drawable.avatar_3);
        list.add(message);

        message = new Message();
        message.setDate("Two days ago");
        message.setMessage(getString(R.string.LoremTextMedium));
        message.setNickname("Nata Romo");
        message.setResource(R.drawable.avatar_2);
        list.add(message);

        message = new Message();
        message.setDate("15 minutes ago");
        message.setMessage(getString(R.string.LoremTextBig));
        message.setNickname("David Israel");
        message.setResource(R.drawable.avatar_5);
        list.add(message);

        message = new Message();
        message.setDate("11 minutes ago");
        message.setMessage(getString(R.string.LoremTextMedium));
        message.setNickname("Alejandra Oregel");
        message.setResource(R.drawable.avatar_4);
        list.add(message);

        message = new Message();
        message.setDate("Just now");
        message.setMessage(getString(R.string.LoremTextBig));
        message.setNickname("Priscila Aguilar");
        message.setResource(R.drawable.avatar_1);
        list.add(message);

        return list;
    }
}
