package in.boulevard.planningpoker.util;

import in.boulevard.planningpoker.R;
import in.boulevard.planningpoker.card.DummyCardsFragment;
import in.boulevard.planningpoker.card.EvenNumberCardsFragment;
import in.boulevard.planningpoker.card.FibonacciCardsFragment;
import in.boulevard.planningpoker.card.ManDaysCardsFragment;
import in.boulevard.planningpoker.card.NumericCardsFragment;
import in.boulevard.planningpoker.card.TShirtSizeCardsFragment;
import android.support.v4.app.Fragment;

/**
 * Util to create objects and read mapping configuration
 * 
 * @author bala
 * 
 */
public class FactoryUtil {

	public static Fragment createCardsFragment(int position) {
		Fragment fragment;
		if (position == Constants.FIBONACCI_POSITION) {
			fragment = new FibonacciCardsFragment();
		} else if (position == Constants.NUMERIC_POSITION) {
			fragment = new NumericCardsFragment();
		} else if (position == Constants.TSHIRT_POSITION) {
			fragment = new TShirtSizeCardsFragment();
		} else if (position == Constants.MANDAYS_POSITION) {
			fragment = new ManDaysCardsFragment();
		} else if (position == Constants.EVEN_POSITION) {
			fragment = new EvenNumberCardsFragment();
		} else {
			fragment = new DummyCardsFragment();
		}
		return fragment;
	}

	public static int getFullScreenImageIdByButtonViewId(int imageButtonId) {
		int fullImageId;

		switch (imageButtonId) {
		case R.id.imageButton1f:
			fullImageId = R.drawable.fib_card1_fullscreen;
			break;
		case R.id.imageButton2f:
			fullImageId = R.drawable.fib_card2_fullscreen;
			break;
		default:
			fullImageId = R.drawable.default_card;
		}
		return fullImageId;
	}

}
