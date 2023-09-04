package com.example.TurismoaApplication.controladores;


import com.example.TurismoaApplication.modelos.Oferta;
import com.example.TurismoaApplication.servicios.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estagonorreasestanllevadas")
public class OfertaControlador {

    @Autowired
    OfertaServicio ofertaServicio;
    @PostMapping
    public ResponseEntity<?> registrarOferta(@RequestBody Oferta datosOferta) {

        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.registrarOferta(datosOferta));

            }catch(Exception error){
                return  ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());

            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> editarOferta(@RequestBody Oferta datosNuevosOferta, @PathVariable Integer id) {
            try{

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.ofertaServicio.modificarOferta(id,datosNuevosOferta));

            }catch(Exception error){
                return  ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());

            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> buscarUnaOferta(@PathVariable Integer id) {
            try{
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.ofertaServicio.buscarOfertaPorId(id));

            }catch(Exception error){
                return  ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());

            }
        }

        @GetMapping
        public ResponseEntity<?> buscarTodaslasOferta() {
            try{
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.ofertaServicio.buscarTodasOfertas());

            }catch(Exception error){
                return  ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());

            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> eliminarOferta(@PathVariable Integer id) {
            try{
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.ofertaServicio.eliminarOfertas(id));

            }catch(Exception error){
                return  ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());

            }
        }
    }

