package com.extremesolutions.rest.dto;



import java.util.List;



public class DoctorDto {
	
    private Long id;
    private String firstName;
    private String lastName;
	private String title;
	private String about;
	private List<TimeScheduleDto> timeSchedules;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<TimeScheduleDto> getTimeSchedules() {
		return timeSchedules;
	}

	public void setTimeSchedules(List<TimeScheduleDto> timeSchedules) {
		this.timeSchedules = timeSchedules;
	}

	@Override
	public String toString() {
		return "DoctorDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", about=" + about + ", timeSchedules=" + timeSchedules + "]";
	}

}
