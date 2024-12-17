package com.tienda.controller;

import com.tienda.service.ReporteService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    ReporteService reporteService;

    @GetMapping("/principal")
    public String principal(Model model) {
        return "/reportes/principal";
    }

    @GetMapping("/usuarios")
    public ResponseEntity<Resource> usuarios(@RequestParam String tipo) throws IOException {

        return reporteService.generaReporte("usuarios", null, tipo);
    }

    @GetMapping("/ventas")
    public ResponseEntity<Resource> ventas(@RequestParam String tipo) throws IOException {

        return reporteService.generaReporte("ventas", null, tipo);
    }

    @GetMapping("/facturas")
    public ResponseEntity<Resource> facturas(@RequestParam String tipo) throws IOException {

        return reporteService.generaReporte("facturas", null, tipo);
    }

    @GetMapping("/inventario")
    public ResponseEntity<Resource> inventario(@RequestParam String tipo) throws IOException {

        return reporteService.generaReporte("inventario", null, tipo);
    }

    @GetMapping("/facturaPorId")
    public ResponseEntity<Resource> facturaPorId(@RequestParam Long facturaId, @RequestParam String tipo) throws IOException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("facturaId", facturaId);

        return reporteService.generaReporte("facturas", parametros, tipo);
    }
}
