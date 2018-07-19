package peru.volcanes.volcanesper;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService{
    String Message;
    String ko,ajustes,tipo;
    Integer r,s;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            FileInputStream fileInputStream =  openFileInput("datos_configuracion");
            InputStreamReader inputStreamReader =  new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer =  new StringBuffer();
            try {
                while ((Message = bufferedReader.readLine())!=null)
                {
                    stringBuffer.append(Message);
                }
                ko = stringBuffer.toString();
                StringTokenizer st = new StringTokenizer(stringBuffer.toString(), ",");
                ajustes = st.nextToken();
                tipo = st.nextToken();
                r = ajustes.length();
                s = tipo.length();
                if (r == 1){
                    showNotification(remoteMessage.getData().get("message"));
                }
                else {
                    String bb = "";
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showNotification(String message) {
        Intent i = new Intent(this,Alertando.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        String pueblos_value = message.split("&")[0];
        String tipodeevento_value = message.split("&")[1];
        String direccion_value = message.split("&")[2];
        String radio_value = message.split("&")[3];
        String fecha_value = message.split("&")[4];
        String hora_value = message.split("&")[5];
        String recomendaciones_value = message.split("&")[6];
        String observaciones_value = message.split("&")[7];
        String volcan_value = message.split("&")[8];
        String simulacro_value = message.split("&")[9];


        String pueblos_value_dato;
        String tipodeevento_value_dato;
        String direccion_value_dato;
        String radio_value_dato;
        String fecha_value_dato;
        String hora_value_dato;
        String recomendaciones_value_dato;
        String observaciones_value_dato;
        String volcan_value_dato;
        String simulacro_value_dato;


        if (pueblos_value.length() < 2){
            pueblos_value_dato = "nulo";
        }
        else{
            pueblos_value_dato = pueblos_value;
        }

        if (tipodeevento_value.length() < 2){
            tipodeevento_value_dato = "nulo";
        }
        else{
            tipodeevento_value_dato = tipodeevento_value;
        }

        if (direccion_value.length() < 2){
            direccion_value_dato = "nulo";
        }
        else{
            direccion_value_dato = direccion_value;
        }

        if (radio_value.length() < 2){
            radio_value_dato = "nulo";
        }
        else{
            radio_value_dato = radio_value;
        }

        if (fecha_value.length() < 2){
            fecha_value_dato = "nulo";
        }
        else{
            fecha_value_dato = fecha_value;
        }

        if (hora_value.length() < 2){
            hora_value_dato = "nulo";
        }
        else{
            hora_value_dato = hora_value;
        }

        if (recomendaciones_value.length() < 2){
            recomendaciones_value_dato = "nulo";
        }
        else{
            recomendaciones_value_dato = recomendaciones_value;
        }


        if (observaciones_value.length() < 2){
            observaciones_value_dato = "nulo";
        }
        else{
            observaciones_value_dato = observaciones_value;
        }

        if (volcan_value.length() < 2){
            volcan_value_dato = "nulo";
        }
        else{
            volcan_value_dato = volcan_value;
        }

        if (simulacro_value.length() < 2){
            simulacro_value_dato = "nulo";
        }
        else{
            simulacro_value_dato = simulacro_value;
        }

        Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
        notificationIntent.setData(Uri.parse(pueblos_value_dato));
        PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Intent iint = new Intent(getApplicationContext(), Alertando.class);
        iint.putExtra("PUEBLOS", pueblos_value_dato);
        iint.putExtra("TIPODEEVENTO", tipodeevento_value_dato);
        iint.putExtra("DIRECCION", direccion_value_dato);
        iint.putExtra("RADIO", radio_value_dato);
        iint.putExtra("FECHA", fecha_value_dato);
        iint.putExtra("HORA", hora_value_dato);
        iint.putExtra("RECOMENDACIONES", recomendaciones_value_dato);
        iint.putExtra("OBSERVACIONES", observaciones_value_dato);
        iint.putExtra("VOLCAN", volcan_value_dato);
        iint.putExtra("SIMULACRO", simulacro_value_dato);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, iint, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap icon = BitmapFactory.decodeResource(this.getResources(), R.drawable.logo);
        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);

        if(pueblos_value_dato != "nulo" && pueblos_value_dato != "nulo"){
            if (s == 1){

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setVibrate(new long[] { 1000, 1000})
                        .setContentTitle("Alerta de cenizas")
                        .setLargeIcon(icon)
                        .setContentIntent(pendingIntent)
                        .setStyle(new NotificationCompat.InboxStyle()
                                .addLine("Alerta de cenizas")
                                .addLine("Pueblos:" + pueblos_value_dato)
                                .addLine("Tipo de evento: " + tipodeevento_value_dato)
                                .addLine("Dirección: " + direccion_value_dato)
                                .addLine("Radio de dispersion: " + radio_value_dato)
                                .addLine("Fecha: " + fecha_value_dato)
                                .addLine("Hora: " + hora_value_dato)
                                .addLine("Recomendaciones:" + recomendaciones_value_dato)
                                .addLine("Observaciones:" + observaciones_value_dato)
                                .addLine("volcan:" + volcan_value_dato)
                                .addLine("simulacro:" + simulacro_value_dato)
                                .setSummaryText("Click para detalles - IGP"));
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());

            }
            else
            {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentTitle("Alerta de cenizas")
                        .setLargeIcon(icon)
                        .setContentIntent(pendingIntent)
                        .setStyle(new NotificationCompat.InboxStyle()
                                .addLine("Alerta de cenizas")
                                .addLine("Pueblos:" + pueblos_value_dato)
                                .addLine("Tipo de evento: " + tipodeevento_value_dato)
                                .addLine("Dirección: " + direccion_value_dato)
                                .addLine("Radio de dispersion: " + radio_value_dato)
                                .addLine("Fecha: " + fecha_value_dato)
                                .addLine("Hora: " + hora_value_dato)
                                .addLine("Recomendaciones:" + recomendaciones_value_dato)
                                .addLine("Observaciones:" + observaciones_value_dato)
                                .addLine("volcan:" + volcan_value_dato)
                                .addLine("simulacro:" + simulacro_value_dato)



                                //.addLine(dato_fecha + " "+ dato_hora_local)
                                .setSummaryText("Click para detalles - IGP"));
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
        }

        else{
            if (s == 1){
                // String filtrado = message.replace(",", "");

                String titulo = message.split(",")[0];
                String contenido = message.split(",")[1];
                String url = message.split(",")[2];
                String fechax = message.split(",")[3];
                String hora_localx = message.split(",")[4];
                String latitudx = message.split(",")[5];
                String longitudx = message.split(",")[6];

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setVibrate(new long[] { 1000, 1000})
                        .setContentTitle("Volcanes Perú")
                        .setLargeIcon(icon)
                        .setContentIntent(pi)
                        .setStyle(new NotificationCompat.InboxStyle()
                                .addLine(titulo)
                                .addLine(contenido)
                                .addLine(contenido)
                                .setSummaryText("Click para ver contenido - IGP"));
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
            else
            {
                //   String filtrado = message.replace(",", "");

                String titulo = message.split(",")[0];
                String contenido = message.split(",")[1];
                String url = message.split(",")[2];
                String fechax = message.split(",")[3];
                String hora_localx = message.split(",")[4];
                String latitudx = message.split(",")[5];
                String longitudx = message.split(",")[6];

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentTitle("Volcanes Perú")
                        .setLargeIcon(icon)
                        .setContentIntent(pi)
                        .setStyle(new NotificationCompat.InboxStyle()
                                .addLine(titulo)
                                .addLine(contenido)
                                .addLine(contenido)
                                .setSummaryText("Click para ver contenido - IGP"));
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
        }

    }
}
