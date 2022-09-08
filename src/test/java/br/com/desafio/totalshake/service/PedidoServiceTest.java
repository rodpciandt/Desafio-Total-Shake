package br.com.desafio.totalshake.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest
public class PedidoServiceTest {


    @Autowired
    private PedidoService service;

    private final Logger log = Logger.getLogger(this.getClass().getName());
}
