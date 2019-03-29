package pt2018.assign5.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import pt2018.assign5.model.Data;
import pt2018.assign5.view.View;

public class MainController
{
	private Data data;
	private View view = new View();

	public MainController()
	{
		data = new Data();
		view.setVisible(true);

		view.actionListenerForButton1(al ->
		{
			long numberOfDistinctDays = data.distinctDays();
			view.getTextArea().setText("");
			view.getTextArea().append(Long.toString(numberOfDistinctDays));
		});

		view.actionListenerForButton2(al ->
		{
			view.getTextArea().setText("");
			Map<String, Integer> occurrencesMap = data.activityOccurrences();
			occurrencesMap.keySet().forEach(key ->
			{
				view.getTextArea().append(key + " " + occurrencesMap.get(key) + "\n");
			});
		});

		view.actionListenerForButton3(al ->
		{
			view.getTextArea().setText("");
			Map<Integer, Map<String, Integer>> mapTask3 = data.activityOccurrencesOnDays();
			mapTask3.keySet().forEach(key ->
			{
				view.getTextArea().append(key + "\n");
				mapTask3.get(key).keySet().forEach(secondKey ->
				{
					view.getTextArea().append("\t" + secondKey + " " + mapTask3.get(key).get(secondKey) + "\n");
				});
			});
		});

		view.actionListenerForButton4(al ->
		{
			view.getTextArea().setText("");
			Map<String, Date> map = data.totalDurationForEachActivity();
			map.keySet().forEach(key ->
			{
				view.getTextArea().append(key + "\n");
			});
		});

		view.actionListenerForButton5(al ->
		{
			view.getTextArea().setText("");
			Map<String, Integer> occurrencesMap = data.activityOccurrences();
			List<String> list = data.shortActivities(occurrencesMap);
			list.forEach(activity ->
			{
				view.getTextArea().append(activity + "\n");
			});
		});

	}

}
