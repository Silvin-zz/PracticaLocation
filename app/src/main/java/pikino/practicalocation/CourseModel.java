package pikino.practicalocation;

/**
 * Created by silviobravocado on 29/08/15.
 */
public class CourseModel {

    private String name;
    private String description;
    private String teacher;
    private String centerName;
    private String cost;
    private String urlImage;
    private String startDate;
    private double latitude;
    private double longitude;


    public CourseModel(String name, String description, String teacher, String centerName, String cost, double latitude, double longitude, String urlImage, String startDate) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.centerName = centerName;
        this.cost = cost;
        this.latitude = latitude;
        this.longitude = longitude;
        this.urlImage  = urlImage;
        this.startDate = startDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
