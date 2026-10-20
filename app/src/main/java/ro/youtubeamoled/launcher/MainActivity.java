package ro.youtubeamoled.launcher;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String YOUTUBE_URL = "https://m.youtube.com/";
    private static final String BARE_PACKAGE = "org.barebrowser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(YOUTUBE_URL));
        intent.setPackage(BARE_PACKAGE);

        try {
            startActivity(intent);
            finish();
        } catch (ActivityNotFoundException e) {
            new AlertDialog.Builder(this)
                .setTitle("Bare Browser nu este disponibil")
                .setMessage("Instalează Bare Browser și încearcă din nou.")
                .setPositiveButton("Închide", (dialog, which) -> finish())
                .setOnCancelListener(dialog -> finish())
                .show();
        }
    }
}
