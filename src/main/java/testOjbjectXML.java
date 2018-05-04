import io.github.oliviercailloux.opendata.entity.Course;
import io.github.oliviercailloux.opendata.entity.ObjectsXML;

public class testOjbjectXML {

	public static void main(String[] args) throws NullPointerException, IllegalArgumentException, Exception {

		ObjectsXML o = new ObjectsXML();
		Course c = new Course();
		c.setCourseName("java");
		c.setCredits(24);
		o.encodingCourse(c, "course.xml");
	}

}
