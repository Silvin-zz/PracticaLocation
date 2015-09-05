package pikino.practicalocation;

import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by silviobravocado on 29/08/15.
 */
public class LoadAsyncCourse extends AsyncTask<String, String, ArrayList<CourseModel>> {


    private Context context;
    private ListFragment listFragment;
    private ProgressDialog progressDialog;


    public LoadAsyncCourse(Context context, ListFragment listFragment) {
        this.context = context;
        this.listFragment = listFragment;
        this.progressDialog = new ProgressDialog(this.context);

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressDialog.setTitle("Loading Courses ......");
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }


    @Override
    protected ArrayList<CourseModel> doInBackground(String... params) {
        ArrayList<CourseModel> courseObjects  = new ArrayList<CourseModel>();
        String json   = this.getCourseJSONResult(params[0]);
        try{

            JSONObject course   = new JSONObject(json);
            JSONArray  tmpArray = course.getJSONArray("data");


            for(int i = 0; i < tmpArray.length(); i++){


                JSONObject  obj = tmpArray.getJSONObject(i);

                String name         = obj.getString("course_name");
                String description  = obj.getString("course_description");
                String teacher      = obj.getString("teacher_name");
                String centerName   = obj.getString("center_name");
                String cost         = obj.getString("cost");
                String urlImage     = obj.getString("course_image");
                String startDate    = obj.getString("date");
                double latitude     = Double.parseDouble(obj.getString("center_lt"));
                double longitude    = Double.parseDouble(obj.getString("center_lng"));
                courseObjects.add(new CourseModel(name,description,teacher,centerName,cost,latitude,longitude, urlImage,startDate));

            }



        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return courseObjects;


    }

    @Override
    protected void onPostExecute(ArrayList<CourseModel> courseModels) {

        super.onPostExecute(courseModels);
        CourseListAdapter courseAdapter =  new CourseListAdapter(this.context, courseModels);
        this.listFragment.setListAdapter(null);
        this.listFragment.setListAdapter(courseAdapter);
        this.progressDialog.dismiss();

    }


    private String getCourseJSONResult(String jsonURL){

        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        try
        {
            URL url     = new URL(jsonURL);
            connection  = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.connect();

            int status  = connection.getResponseCode();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null)
            {
                builder.append(line);
            }
        }catch (Exception ex)
        {
            Log.e("Error", "No pudimos conectarnos con el servidor: " + ex);
        }
        finally
        {
            connection.disconnect();
        }
        return builder.toString();
    }

}
