package DAO;

import java.util.List;


import persistence.Meeting;

public interface MeetingDAO {
	public void addMeeting(Meeting meeting);
	 
	 public List<Meeting> getMeetings();
	 
	 public Meeting getMeeting(long id);
	 
	 public void deleteMeeting(long id);

}
