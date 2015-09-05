package pikino.practicalocation;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by silviobravocado on 29/08/15.
 */
public class CourseFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LoadAsyncCourse ct = new LoadAsyncCourse(getActivity(), this);
        //ct.execute("http://200.76.164.35:8094/bedu/api/v1/action/offertbycategory/1");
        ct.execute("http://200.76.164.35:8094/bedu/api/v1/action/offertbycategorycenter/1/2");

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        CourseModel course  = (CourseModel) getListAdapter().getItem(position);
        Intent intent       = new Intent(getActivity(), MapsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(generateBundleForMap(course));
        startActivity(intent);


    }

    private Bundle generateBundleForMap(CourseModel course){

        Bundle dictionary = new Bundle();

        dictionary.putString("name"         , course.getName());
        dictionary.putString("description"  , course.getDescription());
        dictionary.putDouble("latitude"     , course.getLatitude());
        dictionary.putDouble("longitude"    , course.getLongitude());
        dictionary.putString("teacher"      , course.getTeacher());
        dictionary.putString("center"       , course.getCenterName());

        return dictionary;




    }

}
