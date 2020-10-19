package proyecto_tienda_distribuidos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.rabbitmq.client.Channel;

public class MiTienda {

	private static final int CHUNK_SIZE = 2000;
	private final static String NOMBRE_COLA = "MiTienda";

	public MiTienda() {
		super();
	}

	public void particionar(String registros[], Channel canal) {

		int chunks = (int) Math.floor(registros.length / CHUNK_SIZE);
		

        for(int c = 0; c<chunks; c++){
            String nRegistro [] = Arrays.copyOfRange(registros,c*CHUNK_SIZE, (c + 1)*CHUNK_SIZE);
            for (int i = 0; i < nRegistro.length; i++) {
                System.out.println(nRegistro[i]);
                try {
                    canal.queueDeclare(NOMBRE_COLA, false, false, false, null);
                    canal.basicPublish("", NOMBRE_COLA, null, nRegistro[i].getBytes());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
	}
	
	public void leerMiArchivo(Channel channel) {
        BufferedReader bufferLectura = null;
        String[]campos=new String[10000];;
        try {
            bufferLectura = new BufferedReader(new FileReader(".\\src\\archivos\\RegistrosBase.csv"));
            String linea = bufferLectura.readLine();
            linea = bufferLectura.readLine();
            int i = 0;

            while(linea != null ) {
                campos[i]=linea;
                i++;
                linea = bufferLectura.readLine();
            }

            particionar(campos, channel);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
}