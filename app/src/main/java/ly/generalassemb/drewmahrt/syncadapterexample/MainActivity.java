package ly.generalassemb.drewmahrt.syncadapterexample;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();

    // Constants
    // Content provider authority
    public static final String AUTHORITY = "ly.generalassemb.drewmahrt.syncadapterexample.StubProvider";
    // Account type
    public static final String ACCOUNT_TYPE = "example.com";
    // Account
    public static final String ACCOUNT = "default_account";

    Account mAccount;

    // Global variables
    // A content resolver for accessing the provider
    ContentResolver mResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccount = createSyncAccount(this);

        Button syncButton60 = (Button)findViewById(R.id.sync_button60);
        syncButton60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle settingsBundle = new Bundle();
                settingsBundle.putBoolean(
                        ContentResolver.SYNC_EXTRAS_MANUAL, true);
                settingsBundle.putBoolean(
                        ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
                /*
                 * Request the sync for the default account, authority, and
                 * manual sync settings
                 */
                ContentResolver.requestSync(mAccount, AUTHORITY, settingsBundle);
                ContentResolver.setSyncAutomatically(mAccount, AUTHORITY, true);
                ContentResolver.addPeriodicSync(
                        mAccount,
                        AUTHORITY,
                        Bundle.EMPTY,
                        60);
            }
        });

        Button syncButton300 = (Button)findViewById(R.id.sync_button300);
        syncButton300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle settingsBundle = new Bundle();
                settingsBundle.putBoolean(
                        ContentResolver.SYNC_EXTRAS_MANUAL, true);
                settingsBundle.putBoolean(
                        ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
                /*
                 * Request the sync for the default account, authority, and
                 * manual sync settings
                 */
                ContentResolver.requestSync(mAccount, AUTHORITY, settingsBundle);
                ContentResolver.setSyncAutomatically(mAccount, AUTHORITY, true);
                ContentResolver.addPeriodicSync(
                        mAccount,
                        AUTHORITY,
                        Bundle.EMPTY,
                        300);
            }
        });

        Button syncButton = (Button)findViewById(R.id.sync_button);
        syncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle settingsBundle = new Bundle();
                settingsBundle.putBoolean(
                        ContentResolver.SYNC_EXTRAS_MANUAL, true);
                settingsBundle.putBoolean(
                        ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
                /*
                 * Request the sync for the default account, authority, and
                 * manual sync settings
                 */
                ContentResolver.requestSync(mAccount, AUTHORITY, settingsBundle);
                ContentResolver.setSyncAutomatically(mAccount, AUTHORITY, true);
                ContentResolver.addPeriodicSync(
                        mAccount,
                        AUTHORITY,
                        Bundle.EMPTY,
                        0);
            }
        });



    }

    /**
     * Create a new dummy account for the sync adapter
     *
     * @param context The application context
     */
    public static Account createSyncAccount(Context context) {
        // Create the account type and default account
        Account newAccount = new Account(
                ACCOUNT, ACCOUNT_TYPE);
        // Get an instance of the Android account manager
        AccountManager accountManager =
                (AccountManager) context.getSystemService(
                        ACCOUNT_SERVICE);
        /*
         * Add the account and account type, no password or user data
         * If successful, return the Account object, otherwise report an error.
         */
        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            /*
             * If you don't set android:syncable="true" in
             * in your <provider> element in the manifest,
             * then call context.setIsSyncable(account, AUTHORITY, 1)
             * here.
             */
        } else {
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
        }
        return newAccount;
    }
}
