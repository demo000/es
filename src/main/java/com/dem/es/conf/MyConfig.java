package com.dem.es.conf;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * elatisearch 配置
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class MyConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {

        Settings settings= Settings.builder()
                .put("cluster.name","DEM")
                .put("client.transport.sniff", true).build();
        TransportClient client = new PreBuiltTransportClient(settings);
        InetSocketTransportAddress master = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300);
     /*   InetSocketTransportAddress node_1 = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 8200);
        InetSocketTransportAddress node_2 = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 7200);*/
        client.addTransportAddress(master);
      /*  client.addTransportAddress(node_1);
        client.addTransportAddress(node_2);*/
        return client;
    }
}