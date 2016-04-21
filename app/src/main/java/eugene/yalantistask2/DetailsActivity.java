package eugene.yalantistask2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import eugene.yalantistask2.adapters.ImageAdapter;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        setBackButton();
        recyclerViewInit();
    }

    /**
     * Close an activity when was clicked back button
     *
     * @param item which invoke this event
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Set back button to the activity.
     */
    private void setBackButton() {

        // set back button to action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Recycler view initialization.
     * Recycler view contents photos witch represents form arrays.xml,
     * photo_links parameter
     */
    private void recyclerViewInit() {

        String[] photoLinks = getResources().getStringArray(R.array.photo_links);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.HORIZONTAL, false);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvPhotos);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ImageAdapter(photoLinks, this));
    }

    /**
     * Click listener for any element on the screen,
     * to show a toast.
     */
    public void onShowToast(View view) {

        String caption = view.getClass().getSimpleName();

        Toast.makeText(this, caption, Toast.LENGTH_SHORT).show();
    }
}

