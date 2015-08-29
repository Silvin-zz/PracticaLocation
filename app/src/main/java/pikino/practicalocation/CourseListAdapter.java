package pikino.practicalocation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by silviobravocado on 29/08/15.
 */
public class CourseListAdapter extends BaseAdapter {

    private Context     context;
    List<CourseModel>   rowItems;


    public CourseListAdapter(Context context, List<CourseModel> rowItems) {
        this.context        = context;
        this.rowItems       = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null){

            LayoutInflater lay = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView        = lay.inflate(R.layout.activity_course_list, parent, false);
        }
        TextView courseName    = (TextView) convertView.findViewById(R.id.courseName);
        TextView courseCost    = (TextView) convertView.findViewById(R.id.courseCost);

        CourseModel course     = this.rowItems.get(position);
        courseName.setText(course.getName());
        courseCost.setText(course.getCost());
        return convertView;
    }

}
