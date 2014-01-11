package in.boulevard.planningpoker.card;

import in.boulevard.planningpoker.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class DummyCardsFragment extends Fragment {

	public DummyCardsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.dummy_cards, container, false);
		return rootView;
	}
}