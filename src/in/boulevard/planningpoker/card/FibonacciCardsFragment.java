package in.boulevard.planningpoker.card;

import in.boulevard.planningpoker.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * To display fibonacci cards
 * 
 * @author bala
 * 
 */
public class FibonacciCardsFragment extends DummyCardsFragment {

	public FibonacciCardsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fibonacci_cards, container,
				false);
		return rootView;
	}
}
