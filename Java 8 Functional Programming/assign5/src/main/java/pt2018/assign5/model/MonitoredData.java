package pt2018.assign5.model;

import java.util.Date;

public class MonitoredData
{
	private Date startTime;
	private Date endTime;
	private String activity;

	public MonitoredData(Date startTime, Date endTime, String activity)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getEndTime()
	{
		return endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	public String getActivity()
	{
		return activity;
	}

	public void setActivity(String activity)
	{
		this.activity = activity;
	}
	
	public int getDay()
	{
		return Integer.parseInt(toString().substring(8, 10));
	}

	@Override
	public String toString()
	{
		return startTime.toString() + "\t" + endTime.toString() + "\t" + activity;
	}

}
