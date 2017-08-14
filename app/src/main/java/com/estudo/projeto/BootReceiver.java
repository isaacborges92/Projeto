package com.estudo.projeto;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import static com.estudo.projeto.Informacoes.SIMPLE_NOTIFICATION_ID;

/**
 * Created by Isaac on 07/08/2017.
 */

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

            PendingIntent pendIntentTwo = PendingIntent.getActivity(context,0,
                    new Intent(context, MainActivity.class),0);

            NotificationCompat.Builder mBuilder =
                    (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Está em Juazeiro?")
                            .setAutoCancel(true)
                            .setContentText("Clique aqui para ver os melhores locais para se visitar...");

            mBuilder.setContentIntent(pendIntentTwo);
            mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);

            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(SIMPLE_NOTIFICATION_ID, mBuilder.build());
        }
    }

}
