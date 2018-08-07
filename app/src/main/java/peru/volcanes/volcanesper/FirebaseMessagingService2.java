package peru.volcanes.volcanesper;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FirebaseMessagingService2 extends com.google.firebase.messaging.FirebaseMessagingService{
    String Message;
    String ko,ajustes,tipo;
    Integer r,s;
    String nobrevolcan_r1;
    String nobrevolcan_r2;

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


           // if (r == 1){
           //     showNotification(remoteMessage.getData().get("message"));
            //}
           // else {
           //     String bb = "";
            ///}

            ////

            String mensaje = remoteMessage.getData().get("message");
            String tipo = mensaje.split("&")[0];

            String volcanelegido = mensaje.split("&")[1];
            String va =  String.valueOf(volcanelegido);

            if(va.equals(",1493157379002,")){
                 nobrevolcan_r1 = "Volcán Ubinas";
            }
            else if(va.equals(",1493157381161,")) {
                 nobrevolcan_r1 = "Volcán Sabancaya";
            }
            else if(va.equals(",1506454510537,")) {
                 nobrevolcan_r1 = "Volcán Sara Sara";
            }
            else if(va.equals(",1506455245814,")) {
                 nobrevolcan_r1 = "Volcán Cerro Auquihuato";
            }
            else if(va.equals(",1506455248101,")) {
                 nobrevolcan_r1 = "Volcán Andahua";
            }
            else if(va.equals(",1506455249661,")) {
                 nobrevolcan_r1 = "Volcán Coropuna";
            }
            else if(va.equals(",1506455251429,")) {
                 nobrevolcan_r1 = "Volcán Huambo";
            }
            else if(va.equals(",1506455253382,")) {
                 nobrevolcan_r1 = "Volcán Chachani";
            }
            else if(va.equals(",1506455254838,")) {
                 nobrevolcan_r1 = "Volcán Tutupaca";
            }
            else if(va.equals(",1506455256229,")) {
                 nobrevolcan_r1 = "Volcán Huaynaputina";
            }
            else if(va.equals(",1506455257749,")) {
                 nobrevolcan_r1 = "Volcán Ticsani";
            }
            else if(va.equals(",1506455257753,")) {
                 nobrevolcan_r1 = "Volcán Casiri";
            }
            else if(va.equals(",1506455257755,")) {
                 nobrevolcan_r1 = "Volcán Cerros Purupuruni";

            }
            else if(va.equals(",1506455257757,")) {
                 nobrevolcan_r1 = "Volcán Quimsachata";
            }
            else if(va.equals(",1506455259126,")) {
                 nobrevolcan_r1 = "Volcán Yucamane";
            }
            else if(va.equals(",1506455259128,")) {
                 nobrevolcan_r1 = "Volcán Misti";
            }
            else {
                 nobrevolcan_r1 = "Volcán";
            }






            if (tipo.equals("n01,") && r == 1){

                if (s == 1) {
                    sendNotificationlaharsinsonido(remoteMessage.getData().get("message"));


                }
                else{
                    sendNotificationlahar(remoteMessage.getData().get("message"));

                }

            }
            else if(tipo.equals("n02,") && r == 1){
                if (s == 1) {
                    sendNotificationreporteactividadsinsonido(remoteMessage.getData().get("message"));

                }
                else{
                    sendNotificationreporteactividad(remoteMessage.getData().get("message"));

                }
            }
            else if(tipo.equals("n03,") && r == 1){
                if (s == 1) {
                    sendNotificationalertadecenizassinsonido(remoteMessage.getData().get("message"));

                }
                else{
                    sendNotificationalertadecenizas(remoteMessage.getData().get("message"));

                }
            }
            else if(tipo.equals("n04,") && r == 1){
                if (s == 1) {
                    sendNotificationreporteordinariosinsonido(remoteMessage.getData().get("message"));

                }
                else{
                    sendNotificationreporteordinario(remoteMessage.getData().get("message"));

                }
            }


            else{
                String retornar = "return";
            }

            ///



        }
        catch (IOException e) {
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }




}



private void sendNotificationlahar(String messageBody) {
    Intent intent = new Intent(this, pagedivisor.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    String tiponotificacion = messageBody.split("&")[0];
    String volcan = messageBody.split("&")[1];
    String tipodevento = messageBody.split("&")[2];
    String fecha = messageBody.split("&")[3];
    String hora = messageBody.split("&")[4];
    String observaciones = messageBody.split("&")[5];
    String simulacro = messageBody.split("&")[6];
    String horautc = messageBody.split("&")[7];

    Intent intentlahar = new Intent(getApplicationContext(), Alertadatoslahar.class);
    intentlahar.putExtra("TIPODENOTIFICACION", tiponotificacion);
    intentlahar.putExtra("VOLCAN", volcan);
    intentlahar.putExtra("TIPODEEVENTO", tipodevento);
    intentlahar.putExtra("FECHA", fecha);
    intentlahar.putExtra("HORA", hora);
    intentlahar.putExtra("OBSERVACIONES", observaciones);
    intentlahar.putExtra("SIMULACRO", simulacro);
    intentlahar.putExtra("HORAUTC", horautc);


    String fecha_subs3 = fecha.substring(1);
    String fecha_subs = fecha_subs3.substring(0, 10);

    String hora_subs = hora.substring(0, hora.length() - 1);
    String hora_subs3 = hora_subs.substring(1);

    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intentlahar, PendingIntent.FLAG_UPDATE_CURRENT);

    Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
    //   Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.mipmap.ic_launcher)
            //.setContentTitle(tiponotificacion)
            ///.setContentText(messageBody)

           // .setContentTitle("Alerta de lahar"  + "/"  + "Simulacro en curso")

            .setContentTitle("Alerta de lahar")
            .setContentText(nobrevolcan_r1 + "" + "  " + fecha_subs + "  " + hora_subs3)

           // .setContentText(tipodevento + "" + "" + fecha + "" + hora )

            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent);

    NotificationManager notificationManager =
            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
}





    private void sendNotificationlaharsinsonido(String messageBody) {
        Intent intent = new Intent(this, pagedivisor.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        String tiponotificacion = messageBody.split("&")[0];
        String volcan = messageBody.split("&")[1];
        String tipodevento = messageBody.split("&")[2];
        String fecha = messageBody.split("&")[3];
        String hora = messageBody.split("&")[4];
        String observaciones = messageBody.split("&")[5];
        String simulacro = messageBody.split("&")[6];
        String horautc = messageBody.split("&")[7];

        Intent intentlahar = new Intent(getApplicationContext(), Alertadatoslahar.class);
        intentlahar.putExtra("TIPODENOTIFICACION", tiponotificacion);
        intentlahar.putExtra("VOLCAN", volcan);
        intentlahar.putExtra("TIPODEEVENTO", tipodevento);
        intentlahar.putExtra("FECHA", fecha);
        intentlahar.putExtra("HORA", hora);
        intentlahar.putExtra("OBSERVACIONES", observaciones);
        intentlahar.putExtra("SIMULACRO", simulacro);
        intentlahar.putExtra("HORAUTC", horautc);

        String fecha_subs3 = fecha.substring(1);
        String fecha_subs = fecha_subs3.substring(0, 10);


        String hora_subs = hora.substring(0, hora.length() - 1);
        String hora_subs3 = hora_subs.substring(1);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intentlahar, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
        //   Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                //.setContentTitle(tiponotificacion)
                ///.setContentText(messageBody)


                //.setContentTitle("Alerta de lahar"  + "/"  + "Simulacro en curso")

                .setContentTitle("Alerta de lahar")
                .setContentText(nobrevolcan_r1 + "" + "  " + fecha_subs + "  " + hora_subs3)

                //.setContentText(tipodevento + "" + "" + fecha + "" + hora )

                .setAutoCancel(true)
                //.setSound(defaultSoundUri)
                .setVibrate(new long[] { 1000, 1000})
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }





    private void sendNotificationreporteordinario(String messageBody) {
        Intent intent = new Intent(this, Alertareporteactividad.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        String tiponotificacion = messageBody.split("&")[0];
        String volcan = messageBody.split("&")[1];
        String tipodevento = messageBody.split("&")[2];
        String fecha = messageBody.split("&")[3];
        String hora = messageBody.split("&")[4];
        String simulacro = messageBody.split("&")[5];

        String horautc = messageBody.split("&")[6];
        String reportepdf = messageBody.split("&")[7];



        Intent intentreportedeactividad = new Intent(getApplicationContext(), Alertareporteactividad.class);
        intentreportedeactividad.putExtra("TIPODENOTIFICACION", tiponotificacion);
        intentreportedeactividad.putExtra("VOLCAN", volcan);
        intentreportedeactividad.putExtra("TIPODEEVENTO", tipodevento);
        intentreportedeactividad.putExtra("FECHA", fecha);
        intentreportedeactividad.putExtra("HORA", hora);
        intentreportedeactividad.putExtra("SIMULACRO", simulacro);

        intentreportedeactividad.putExtra("HORAUTC", horautc);
        intentreportedeactividad.putExtra("REPORTEACTIVIDAD", reportepdf);

        // String fechasubs =  fecha.substring(1);
        String fecha_subs3 = fecha.substring(1);

        String fecha_subs = fecha_subs3.substring(0, 10);


        // String hora_subs = hora.substring(0, 1);

        String hora_subs = hora.substring(0, hora.length() - 1);
        String hora_subs3 = hora_subs.substring(1);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intentreportedeactividad, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
        //   Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Reporte Ordinario de Actividad")
                .setContentText(nobrevolcan_r1  + " " + fecha_subs + " " + " " + hora_subs3 +" " )
                //.setContentTitle(tiponotificacion)

                // .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

    private void sendNotificationreporteordinariosinsonido(String messageBody) {
        Intent intent = new Intent(this, Alertareporteactividad.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        String tiponotificacion = messageBody.split("&")[0];
        String volcan = messageBody.split("&")[1];
        String tipodevento = messageBody.split("&")[2];
        String fecha = messageBody.split("&")[3];
        String hora = messageBody.split("&")[4];
        String simulacro = messageBody.split("&")[5];

        String horautc = messageBody.split("&")[6];
        String reportepdf = messageBody.split("&")[7];

        Intent intentreportedeactividad = new Intent(getApplicationContext(), Alertareporteactividad.class);
        intentreportedeactividad.putExtra("TIPODENOTIFICACION", tiponotificacion);
        intentreportedeactividad.putExtra("VOLCAN", volcan);
        intentreportedeactividad.putExtra("TIPODEEVENTO", tipodevento);
        intentreportedeactividad.putExtra("FECHA", fecha);
        intentreportedeactividad.putExtra("HORA", hora);
        intentreportedeactividad.putExtra("SIMULACRO", simulacro);

        intentreportedeactividad.putExtra("HORAUTC", horautc);
        intentreportedeactividad.putExtra("REPORTEACTIVIDAD", reportepdf);

        //  String fecha_subs = fecha.substring(0, 10);
        // String fecha_subs3 = fecha_subs.substring(1);

        String fecha_subs3 = fecha.substring(1);

        String fecha_subs = fecha_subs3.substring(0, 10);

        // String hora_subs = hora.substring(0, 1);

        String hora_subs = hora.substring(0, hora.length() - 1);
        String hora_subs3 = hora_subs.substring(1);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intentreportedeactividad, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
        //   Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Reporte Ordinario de Actividad")
                //.setContentText(nobrevolcan_r1  + " "  + fecha_subs3 + " " + hora_subs )
                // .setContentText(nobrevolcan_r1  + "*" + fecha_subs + "*" + "*" + hora_subs3 +"*" )
                .setContentText(nobrevolcan_r1  + " " + fecha_subs + " " + " " + hora_subs3 +" " )

                //   .setContentTitle("Reporte Extraordinario de Actividad"  + "/"  + "Simulacro en curso")
                //  .setContentText(tipodevento + "" + "" + fecha + "" + hora )

                //.setContentTitle(tiponotificacion)

                // .setContentText(messageBody)
                .setAutoCancel(true)
                //.setSound(defaultSoundUri)
                .setVibrate(new long[] { 1000, 1000})
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }



    private void sendNotificationreporteactividad(String messageBody) {
    Intent intent = new Intent(this, Alertareporteactividad.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    String tiponotificacion = messageBody.split("&")[0];
    String volcan = messageBody.split("&")[1];
    String tipodevento = messageBody.split("&")[2];
    String fecha = messageBody.split("&")[3];
    String hora = messageBody.split("&")[4];
    String simulacro = messageBody.split("&")[5];

    String horautc = messageBody.split("&")[6];
    String reportepdf = messageBody.split("&")[7];



    Intent intentreportedeactividad = new Intent(getApplicationContext(), Alertareporteactividad.class);
    intentreportedeactividad.putExtra("TIPODENOTIFICACION", tiponotificacion);
    intentreportedeactividad.putExtra("VOLCAN", volcan);
    intentreportedeactividad.putExtra("TIPODEEVENTO", tipodevento);
    intentreportedeactividad.putExtra("FECHA", fecha);
    intentreportedeactividad.putExtra("HORA", hora);
    intentreportedeactividad.putExtra("SIMULACRO", simulacro);

    intentreportedeactividad.putExtra("HORAUTC", horautc);
    intentreportedeactividad.putExtra("REPORTEACTIVIDAD", reportepdf);

   // String fechasubs =  fecha.substring(1);
    String fecha_subs3 = fecha.substring(1);

    String fecha_subs = fecha_subs3.substring(0, 10);


   // String hora_subs = hora.substring(0, 1);

    String hora_subs = hora.substring(0, hora.length() - 1);
    String hora_subs3 = hora_subs.substring(1);

    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intentreportedeactividad, PendingIntent.FLAG_UPDATE_CURRENT);

    Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
    //   Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Reporte Extraordinario de Actividad")
            .setContentText(nobrevolcan_r1  + " " + fecha_subs + " " + " " + hora_subs3 +" " )
            //.setContentTitle(tiponotificacion)

           // .setContentText(messageBody)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent);

    NotificationManager notificationManager =
            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
}




    private void sendNotificationreporteactividadsinsonido(String messageBody) {
        Intent intent = new Intent(this, Alertareporteactividad.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        String tiponotificacion = messageBody.split("&")[0];
        String volcan = messageBody.split("&")[1];
        String tipodevento = messageBody.split("&")[2];
        String fecha = messageBody.split("&")[3];
        String hora = messageBody.split("&")[4];
        String simulacro = messageBody.split("&")[5];

        String horautc = messageBody.split("&")[6];
        String reportepdf = messageBody.split("&")[7];

        Intent intentreportedeactividad = new Intent(getApplicationContext(), Alertareporteactividad.class);
        intentreportedeactividad.putExtra("TIPODENOTIFICACION", tiponotificacion);
        intentreportedeactividad.putExtra("VOLCAN", volcan);
        intentreportedeactividad.putExtra("TIPODEEVENTO", tipodevento);
        intentreportedeactividad.putExtra("FECHA", fecha);
        intentreportedeactividad.putExtra("HORA", hora);
        intentreportedeactividad.putExtra("SIMULACRO", simulacro);

        intentreportedeactividad.putExtra("HORAUTC", horautc);
        intentreportedeactividad.putExtra("REPORTEACTIVIDAD", reportepdf);

      //  String fecha_subs = fecha.substring(0, 10);
       // String fecha_subs3 = fecha_subs.substring(1);

        String fecha_subs3 = fecha.substring(1);

        String fecha_subs = fecha_subs3.substring(0, 10);

        // String hora_subs = hora.substring(0, 1);

        String hora_subs = hora.substring(0, hora.length() - 1);
        String hora_subs3 = hora_subs.substring(1);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intentreportedeactividad, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
        //   Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Reporte Extraordinario de Actividad")
                //.setContentText(nobrevolcan_r1  + " "  + fecha_subs3 + " " + hora_subs )
               // .setContentText(nobrevolcan_r1  + "*" + fecha_subs + "*" + "*" + hora_subs3 +"*" )
                .setContentText(nobrevolcan_r1  + " " + fecha_subs + " " + " " + hora_subs3 +" " )

             //   .setContentTitle("Reporte Extraordinario de Actividad"  + "/"  + "Simulacro en curso")
              //  .setContentText(tipodevento + "" + "" + fecha + "" + hora )

                //.setContentTitle(tiponotificacion)

                // .setContentText(messageBody)
                .setAutoCancel(true)
                //.setSound(defaultSoundUri)
                .setVibrate(new long[] { 1000, 1000})
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }



    private void sendNotificationalertadecenizas(String messageBody) {
    Intent intent = new Intent(this, pagedivisor.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    String tiponotificacion = messageBody.split("&")[0];
    String pueblos = messageBody.split("&")[1];
    String tipodevento = messageBody.split("&")[2];
    String direccion = messageBody.split("&")[3];
    String radio = messageBody.split("&")[4];
    String fecha = messageBody.split("&")[5];
    String hora = messageBody.split("&")[6];
    String recomendaciones = messageBody.split("&")[7];
    String observaciones = messageBody.split("&")[8];
    String volcan = messageBody.split("&")[9];
    String simulacro = messageBody.split("&")[10];
    String horautc = messageBody.split("&")[11];




    String substraccionfecha = fecha.substring(0, 11);


    //    String volcanelegido = volcan.split("&")[1];
        String va =  String.valueOf(volcan);

        if(va.equals(",1493157379002,")){
            nobrevolcan_r2 = "Volcán Ubinas";
        }
        else if(va.equals(",1493157381161,")) {
             nobrevolcan_r2 = "Volcán Sabancaya";
        }
        else if(va.equals(",1506454510537,")) {
             nobrevolcan_r2 = "Volcán Sara Sara";
        }
        else if(va.equals(",1506455245814,")) {
             nobrevolcan_r2 = "Volcán Cerro Auquihuato";
        }
        else if(va.equals(",1506455248101,")) {
             nobrevolcan_r2 = "Volcán Andahua";
        }
        else if(va.equals(",1506455249661,")) {
             nobrevolcan_r2 = "Volcán Coropuna";
        }
        else if(va.equals(",1506455251429,")) {
             nobrevolcan_r2 = "Volcán Huambo";
        }
        else if(va.equals(",1506455253382,")) {
             nobrevolcan_r2 = "Volcán Chachani";
        }
        else if(va.equals(",1506455254838,")) {
             nobrevolcan_r2 = "Volcán Tutupaca";
        }
        else if(va.equals(",1506455256229,")) {
             nobrevolcan_r2 = "Volcán Huaynaputina";
        }
        else if(va.equals(",1506455257749,")) {
             nobrevolcan_r2 = "Volcán Ticsani";
        }
        else if(va.equals(",1506455257753,")) {
             nobrevolcan_r2 = "Volcán Casiri";
        }
        else if(va.equals(",1506455257755,")) {
             nobrevolcan_r2 = "Volcán Cerros Purupuruni";

        }
        else if(va.equals(",1506455257757,")) {
             nobrevolcan_r2 = "Volcán Quimsachata";
        }
        else if(va.equals(",1506455259126,")) {
             nobrevolcan_r2 = "Volcán Yucamane";
        }
        else if(va.equals(",1506455259128,")) {
             nobrevolcan_r2 = "Volcán Misti";
        }
        else {
             nobrevolcan_r2 = "Volcán";
        }


        Intent intentalertadecenizas = new Intent(getApplicationContext(), Alertando.class);
    intentalertadecenizas.putExtra("TIPODENOTIFICACION", tiponotificacion);
    intentalertadecenizas.putExtra("VOLCAN", volcan);
    intentalertadecenizas.putExtra("PUEBLOS", pueblos);
    intentalertadecenizas.putExtra("TIPODEEVENTO", tipodevento);
    intentalertadecenizas.putExtra("DIRECCION", direccion);
    intentalertadecenizas.putExtra("RADIO", radio);
    intentalertadecenizas.putExtra("FECHA", fecha);
    intentalertadecenizas.putExtra("HORA", hora);
    intentalertadecenizas.putExtra("RECOMENDACIONES", recomendaciones);
    intentalertadecenizas.putExtra("OBSERVACIONES", observaciones);
    intentalertadecenizas.putExtra("SIMULACRO", simulacro);
    intentalertadecenizas.putExtra("HORAUTC", horautc);


    String fecha_subs3 = fecha.substring(1);
    String fecha_subs = fecha_subs3.substring(0, 10);

    String hora_subs = hora.substring(0, hora.length() - 1);
    String hora_subs3 = hora_subs.substring(1);

    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intentalertadecenizas, PendingIntent.FLAG_UPDATE_CURRENT);
    Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
    //   Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.mipmap.ic_launcher)
           // .setContentTitle(tiponotificacion)
           // .setContentText(messageBody)

            .setContentTitle("Alerta de cenizas")
            //.setContentTitle("Alerta de cenizas"  + "/"  + "Simulacro en curso")
           // .setContentText(tipodevento + "" + "" + substraccionfecha + "" + hora )
            .setContentText(nobrevolcan_r2  + "  " + fecha_subs + " " + "  " + hora_subs3 +" " )

            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent);

    NotificationManager notificationManager =
            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
}





    private void sendNotificationalertadecenizassinsonido(String messageBody) {
        Intent intent = new Intent(this, pagedivisor.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        String tiponotificacion = messageBody.split("&")[0];
        String pueblos = messageBody.split("&")[1];
        String tipodevento = messageBody.split("&")[2];
        String direccion = messageBody.split("&")[3];
        String radio = messageBody.split("&")[4];
        String fecha = messageBody.split("&")[5];
        String hora = messageBody.split("&")[6];
        String recomendaciones = messageBody.split("&")[7];
        String observaciones = messageBody.split("&")[8];
        String volcan = messageBody.split("&")[9];
        String simulacro = messageBody.split("&")[10];
        String horautc = messageBody.split("&")[11];




       // String volcanelegido = volcan.split("&")[1];
        String va =  String.valueOf(volcan);

        if(va.equals(",1493157379002,")){
            nobrevolcan_r2 = "Volcán Ubinas";
        }
        else if(va.equals(",1493157381161,")) {
            nobrevolcan_r2 = "Volcán Sabancaya";
        }
        else if(va.equals(",1506454510537,")) {
            nobrevolcan_r2 = "Volcán Sara Sara";
        }
        else if(va.equals(",1506455245814,")) {
            nobrevolcan_r2 = "Volcán Cerro Auquihuato";
        }
        else if(va.equals(",1506455248101,")) {
            nobrevolcan_r2 = "Volcán Andahua";
        }
        else if(va.equals(",1506455249661,")) {
            nobrevolcan_r2 = "Volcán Coropuna";
        }
        else if(va.equals(",1506455251429,")) {
            nobrevolcan_r2 = "Volcán Huambo";
        }
        else if(va.equals(",1506455253382,")) {
            nobrevolcan_r2 = "Volcán Chachani";
        }
        else if(va.equals(",1506455254838,")) {
            nobrevolcan_r2 = "Volcán Tutupaca";
        }
        else if(va.equals(",1506455256229,")) {
            nobrevolcan_r2 = "Volcán Huaynaputina";
        }
        else if(va.equals(",1506455257749,")) {
            nobrevolcan_r2 = "Volcán Ticsani";
        }
        else if(va.equals(",1506455257753,")) {
            nobrevolcan_r2 = "Volcán Casiri";
        }
        else if(va.equals(",1506455257755,")) {
            nobrevolcan_r2 = "Volcán Cerros Purupuruni";

        }
        else if(va.equals(",1506455257757,")) {
            nobrevolcan_r2 = "Volcán Quimsachata";
        }
        else if(va.equals(",1506455259126,")) {
            nobrevolcan_r2 = "Volcán Yucamane";
        }
        else if(va.equals(",1506455259128,")) {
            nobrevolcan_r2 = "Volcán Misti";
        }
        else {
            nobrevolcan_r2 = "Volcán";
        }



        String substraccionfecha = fecha.substring(0, 11);


        Intent intentalertadecenizas = new Intent(getApplicationContext(), Alertando.class);
        intentalertadecenizas.putExtra("TIPODENOTIFICACION", tiponotificacion);
        intentalertadecenizas.putExtra("VOLCAN", volcan);
        intentalertadecenizas.putExtra("PUEBLOS", pueblos);
        intentalertadecenizas.putExtra("TIPODEEVENTO", tipodevento);
        intentalertadecenizas.putExtra("DIRECCION", direccion);
        intentalertadecenizas.putExtra("RADIO", radio);
        intentalertadecenizas.putExtra("FECHA", fecha);
        intentalertadecenizas.putExtra("HORA", hora);
        intentalertadecenizas.putExtra("RECOMENDACIONES", recomendaciones);
        intentalertadecenizas.putExtra("OBSERVACIONES", observaciones);
        intentalertadecenizas.putExtra("SIMULACRO", simulacro);
        intentalertadecenizas.putExtra("HORAUTC", horautc);


        String fecha_subs3 = fecha.substring(1);
        String fecha_subs = fecha_subs3.substring(0, 10);

        String hora_subs = hora.substring(0, hora.length() - 1);
        String hora_subs3 = hora_subs.substring(1);


        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intentalertadecenizas, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
        //   Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                // .setContentTitle(tiponotificacion)
                // .setContentText(messageBody)

                .setContentTitle("Alerta de cenizas")
                //.setContentTitle("Alerta de cenizas"  + "/"  + "Simulacro en curso")
                // .setContentText(tipodevento + "" + "" + substraccionfecha + "" + hora )
                .setContentText(nobrevolcan_r2  + "  " + fecha_subs + " " + "  " + hora_subs3 +" " )


              //  .setContentTitle("Alerta de cenizas"  + "/"  + "Simulacro en curso")
               // .setContentText(tipodevento + "" + "" + fecha + "" + hora )

                .setAutoCancel(true)
                //.setSound(defaultSoundUri)
                .setVibrate(new long[] { 1000, 1000})
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }


}
