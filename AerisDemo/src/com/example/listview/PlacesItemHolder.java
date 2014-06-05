package com.example.listview;

import org.apache.commons.lang3.text.WordUtils;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoaerisproject.R;
import com.hamweather.aeris.model.Place;
import com.hamweather.aeris.response.PlacesResponse;

public class PlacesItemHolder implements AdapterHolder<PlacesResponse> {

	private TextView placeTextView;
	private ImageView icon;
	private TextView countTextView;

	@Override
	public View inflateview(LayoutInflater mInflater) {
		View view = mInflater.inflate(R.layout.drawer_list_item, null, false);
		placeTextView = (TextView) view.findViewById(R.id.title);
		icon = (ImageView) view.findViewById(R.id.icon);
		countTextView = (TextView) view.findViewById(R.id.counter);
		return view;
	}

	@Override
	public void populateView(PlacesResponse t, int position) {
		Place place = t.getPlace();
		String text = "";
		if (place.state != null && place.state.length() > 0) {
			text = String.format("%s, %s, %s",
					WordUtils.capitalize(place.name, ' '),
					place.state.toUpperCase(), place.country.toUpperCase());
		} else {
			text = String.format("%s, %s",
					WordUtils.capitalize(place.name, ' ', '-'),
					place.country.toUpperCase());
		}
		placeTextView.setText(text);
		icon.setVisibility(View.GONE);
		countTextView.setVisibility(View.GONE);

	}

}