package in.boulevard.planningpoker;

import in.boulevard.planningpoker.card.DummyCardsFragment;
import in.boulevard.planningpoker.card.EvenNumberCardsFragment;
import in.boulevard.planningpoker.card.FibonacciCardsFragment;
import in.boulevard.planningpoker.card.ManDaysCardsFragment;
import in.boulevard.planningpoker.card.NumericCardsFragment;
import in.boulevard.planningpoker.card.TShirtSizeCardsFragment;
import in.boulevard.planningpoker.util.Constants;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	public static final String CARD_ID_MESSAGE = "card_id";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(actionBar.getThemedContext(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, new String[] {
								getString(R.string.title_section1),
								getString(R.string.title_section2),
								getString(R.string.title_section3),
								getString(R.string.title_section4),
								getString(R.string.title_section5) }), this);
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
		Fragment fragment = createCardsFragment(position);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();
		return true;
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_with_dropdown, menu);
		return true;
	}

	/** Called when the user clicks the card button */
	public void showCard(View view) {
		Button cardButton = (Button) view;
		int viewId = cardButton.getId();
		System.out.println(viewId);
		Intent intent = new Intent(this, DisplayCardActivity.class);
		intent.putExtra(CARD_ID_MESSAGE, viewId);
		System.out.println(viewId);
		startActivity(intent);
	}

	private Fragment createCardsFragment(int position) {
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

}
