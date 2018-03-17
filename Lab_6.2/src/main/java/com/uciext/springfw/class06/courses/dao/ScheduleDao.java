package com.uciext.springfw.class06.courses.dao;

import java.util.List;

import com.uciext.springfw.class06.courses.model.Course;
import com.uciext.springfw.class06.courses.model.Schedule;

public interface ScheduleDao {

	public void insertSchedule(Schedule schedule);
	public Schedule findScheduleById(int scheduleId);
	public List<Schedule> findSchedules();
	public List<Schedule> findSchedulesByCourse(Course course);

}
