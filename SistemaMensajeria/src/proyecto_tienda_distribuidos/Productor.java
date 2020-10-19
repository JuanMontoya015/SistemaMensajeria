package proyecto_tienda_distribuidos;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;


public class Productor {
	
	public static void main(String[] args) throws IOException, TimeoutException {
        // TODO Auto-generated method stub
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            MiTienda miTienda = new MiTienda();
            miTienda.leerMiArchivo(channel);
        }

        }

}
