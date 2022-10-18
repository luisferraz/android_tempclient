package br.ufpr.tads.luis.tempclient;

import android.os.AsyncTask;
import android.renderscript.Sampler;
import android.util.Log;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class RequestTask extends AsyncTask<Double, Void, Double> {
    private TextView saida;
    private final String IP = "10.0.2.2";
    private final int porta = 12345;

    public RequestTask(TextView saida) {
        this.saida = saida;
    }

    @Override
    protected void onPostExecute(Double aDouble) {
        super.onPostExecute(aDouble);
        saida.setText(String.valueOf(aDouble));
    }

    @Override
    protected Double doInBackground(Double... doubles) {
        double tempSaida = 0.0;

        try {
            Socket socket = new Socket(IP, porta);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeDouble(doubles[0]);
            System.out.println("entrada - doInBackground: " + doubles[0]);
            out.flush();
            tempSaida = in.readDouble();
            System.out.println("saida - doInBackground: " + tempSaida);
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempSaida;
    }
}
