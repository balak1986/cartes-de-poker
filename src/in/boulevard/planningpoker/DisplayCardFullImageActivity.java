package in.boulevard.planningpoker;

import in.boulevard.planningpoker.util.Constants;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class DisplayCardFullImageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		Integer cardFullImageUri = intent.getIntExtra(
				Constants.CARD_FULL_IMAGE_ID, R.drawable.default_card);

		ImageView img = new ImageView(this);
		img.setImageResource(cardFullImageUri);

		setContentView(img);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_card, menu);
		return true;
	}

}
