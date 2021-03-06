package com.example.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoaerisproject.R;
import com.aerisweather.aeris.model.ObservationPeriod;
import com.aerisweather.aeris.util.FileUtil;
import com.aerisweather.aeris.util.WeatherUtil;

public class RecentObsHolder implements AdapterHolder<ObservationPeriod> {

	ImageView weatherIcon;
	TextView day;
	TextView date;
	TextView weatherDesc;
	TextView temp;

	@Override
	public View inflateview(LayoutInflater mInflater) {
		View v = mInflater.inflate(R.layout.listview_recent_observations, null,
				false);
		weatherIcon = (ImageView) v.findViewById(R.id.ivListIcon);
		weatherDesc = (TextView) v.findViewById(R.id.tvListDesc);
		temp = (TextView) v.findViewById(R.id.tvListTemp);
		date = (TextView) v.findViewById(R.id.tvListDate);
		day = (TextView) v.findViewById(R.id.tvListDay);
		return v;
	}

	@Override
	public void populateView(ObservationPeriod t, int position) {
		weatherIcon.setImageResource(FileUtil.getDrawableByName(t.ob.icon,
				day.getContext()));
		day.setText(WeatherUtil.getFormatFromISO(t.ob.dateTimeISO, "h:mm aa"));
		date.setText(WeatherUtil.getDayFromISO(t.ob.dateTimeISO));
		weatherDesc.setText(t.ob.weather);
		if (t.ob.tempF != null) {
			temp.setText(t.ob.tempF.toString());
		} else {
			temp.setText("--");
		}
	}
}
