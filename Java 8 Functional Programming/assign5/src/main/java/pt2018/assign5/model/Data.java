package pt2018.assign5.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Data
{
	private List<MonitoredData> dataList = new ArrayList<>();

	public Data()
	{
		String fileName = "D://Activities.txt";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try (Stream<String> stream = Files.lines(Paths.get(fileName)))
		{

			dataList = stream.map(line ->
			{
				try
				{
					Date startDate = format.parse(line.substring(0, 19));
					Date endDate = format.parse(line.substring(21, 40));
					String activity = line.substring(42).trim();
					MonitoredData monitoredData = new MonitoredData(startDate, endDate, activity);
					return monitoredData;
				}
				catch (ParseException e)
				{
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toList());

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public long distinctDays()
	{
		return dataList.stream().map(monitoredData -> monitoredData.toString().substring(4, 10)).distinct().count();
	}

	public Map<String, Integer> activityOccurrences()
	{
		Map<String, Integer> occurrencesMap = new HashMap<>();
		occurrencesMap = dataList.stream().collect(
				Collectors.groupingBy(MonitoredData::getActivity, Collectors.reducing(0, e -> 1, Integer::sum)));
		return occurrencesMap;
	}

	public Map<Integer, Map<String, Integer>> activityOccurrencesOnDays()
	{
		Map<Integer, Map<String, Integer>> mapTask3 = new HashMap<>();
		mapTask3 = dataList.stream().collect(Collectors.groupingBy(d -> d.getDay(),
				Collectors.groupingBy(MonitoredData::getActivity, Collectors.reducing(0, e -> 1, Integer::sum))));
		return mapTask3;
	}

	public Map<String, Date> totalDurationForEachActivity()
	{
		Map<String, Date> map = new HashMap<>();
		dataList.forEach(data ->
		{
			long totalDuration = dataList.stream().filter(d -> d.getActivity().equals(data.getActivity()))
					.mapToLong(d -> d.getEndTime().getTime() - d.getStartTime().getTime()).sum();
			if (totalDuration > 36000000)
			{
				map.put(data.getActivity(), new Date(totalDuration));
			}
		});
		return map;
	}

	public List<String> shortActivities(Map<String, Integer> map)
	{
		List<String> list = new ArrayList<>();
		map.keySet().forEach(activity ->
		{
			float o = (float) dataList.stream().filter(d -> d.getActivity().equals(activity))
					.filter(d -> d.getEndTime().getTime() - d.getStartTime().getTime() < 300000).count();
			if (o / map.get(activity) >= 0.9)
			{
				list.add(activity);
			}
		});
		return list;
	}
	
}
