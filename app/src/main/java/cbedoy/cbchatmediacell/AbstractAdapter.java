package cbedoy.cbchatmediacell;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by bedoy on 5/5/16.
 */
public abstract class AbstractAdapter<T> extends BaseAdapter
{
    private List<T> mDataModel;

    public AbstractAdapter(List<T> dataModel){
        mDataModel = dataModel;
    }

    @Override
    public int getCount() {
        return mDataModel.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public T getElementAtIndex(int index){
        return mDataModel.get(index);
    }

}
