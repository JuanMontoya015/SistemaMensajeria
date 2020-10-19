package co.edu.eam.sistema_mensajeria_consumidor.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  @Bean
  public Queue MiTienda(){ return new Queue("MiTienda", true); }

  @Bean
  public Queue errorMiTienda(){
    return new Queue("mi_tienda_error_queue", true);
  }

  @Bean
  public DirectExchange directExchange(){
    return new DirectExchange("direct_exchange");
  }

  @Bean
  public Binding bindDirectExchangeMiTiendaQueue(Queue MiTienda, DirectExchange directExchange){
    return BindingBuilder.bind(MiTienda).to(directExchange).with("mi_tienda");
  }

  @Bean
  public Binding bindDirectExchangeErrorMiTiendaQueue(Queue errorMiTienda, DirectExchange directExchange){
    return BindingBuilder.bind(errorMiTienda).to(directExchange).with("mi_tienda_error");
  }
}
