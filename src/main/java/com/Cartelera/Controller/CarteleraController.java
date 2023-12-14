/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Controller.java to edit this template
 */
package com.Cartelera.Controller;

import com.Cartelera.Service.*;
import com.Cartelera.domain.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class CarteleraController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private FacturaService facturaService;

    private final List<Producto> carrito = new ArrayList<>();
    private final List<Producto> listaCarrito = new ArrayList<>();

    private int cantidad = 0;
    private double total = 0;
    private double subTotal = 0;
    private double iva = 0;

    @RequestMapping("/")
    public String page(Model model, Model model2) {
        var clientesDB = usuarioService.getUsuario();
        model.addAttribute("clientesDB", clientesDB);
        var usuarioActivo = usuarioService.findByEstado(true); //SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model2.addAttribute("usuarioActivo", usuarioActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
         var peliculas = peliculaService.getPelicula();
        model2.addAttribute("peliculas", peliculas);
        return "index";
    }

    @GetMapping("/InicioSesion")
    public String InicioSesion(Usuario usuario, Model model) {
        model.addAttribute("attribute", "value");
        return "InicioSesion";
    }

    @PostMapping("/validarSesion")
    public String validarSesion(Usuario usuario) {
        if (usuarioService.findByCorreoElectronicoAndContrasena(usuario.getCorreoElectronico(), usuario.getContrasena()) == null) {
            return "redirect:/InicioSesion";
        } else {
            usuario = usuarioService.findByCorreoElectronicoAndContrasena(usuario.getCorreoElectronico(), usuario.getContrasena());
            usuario.setEstado(true);
            usuarioService.save(usuario);
            return "redirect:/";
        }
    }

    /*Metodo para cerrar sesion y cambiar el estado*/
    @GetMapping("/cerrarSesion")
    @Transactional
    public String cerrarSesion(Model model) {
        var usuario = usuarioService.findByEstado(true);
        usuario.setEstado(false);
        usuarioService.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/Registro")
    public String Registro(Usuario usuario, Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Registro";
    }

    @Transactional
    @PostMapping("/guardarUsuario")
    public String guardarCliente(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/cartelera")
    public String cartelera(Model model, Model model2) {
        var peliculas = peliculaService.getPelicula();
        model2.addAttribute("peliculas", peliculas);
        var usuarioActivo = usuarioService.findByEstado(true); //SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("usuarioActivo", usuarioActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "cartelera";
    }

    @GetMapping("/Promociones")
    public String Promociones(Model model, Model model2) {
        var productos = productoService.getProducto();
        model2.addAttribute("productos", productos);
        var usuarioActivo = usuarioService.findByEstado(true); //SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("usuarioActivo", usuarioActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "Promociones";
    }

    @GetMapping("/Dulceria")
    public String Dulceria(Model model, Model model2) {
        var productos = productoService.getProducto();
        model2.addAttribute("productos", productos);
        var usuarioActivo = usuarioService.findByEstado(true); //SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("usuarioActivo", usuarioActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "Dulceria";
    }

    @GetMapping("/CinePlus")
    public String CinePlus(Model model) {
        var usuarioActivo = usuarioService.findByEstado(true); //SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("usuarioActivo", usuarioActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "CinePlus";
    }

    @GetMapping("/Horarios")
    public String Horarios(Model model) {
        var usuarioActivo = usuarioService.findByEstado(true); //SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("usuarioActivo", usuarioActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "Horarios";
    }

    @GetMapping("/Carrito")
    public String Carrito(Model model) {
        var usuarioActivo = usuarioService.findByEstado(true); //SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        var productos = productoService.getProducto();
        
        for (var listaProductos : productos) {
            cantidad = 0;
            for (var producto : carrito) {
                if (Objects.equals(producto.getProductoId(), listaProductos.getProductoId())) {
                    cantidad++;                   
                    if (carrito.contains(producto)) {
                        listaCarrito.remove(producto);
                        producto.setCantidad(cantidad);
                        listaCarrito.add(producto);

                    } else {
                        producto.setCantidad(cantidad);
                        listaCarrito.add(producto);
                    }
                }
                
            }
            
        }
        for (var producto : listaCarrito) {
            subTotal = (producto.getPrecio()).doubleValue() + subTotal;
        }
        iva = subTotal * 0.13;
        total = subTotal + iva;
        model.addAttribute("usuarioActivo", usuarioActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("productos", listaCarrito);
        model.addAttribute("total", total);
        model.addAttribute("subTotal", subTotal);
        model.addAttribute("iva", iva);
        return "Carrito";
    }

    @GetMapping("/AgregarCarrito")
    public String AgregarCarrito(@RequestParam(value = "id", required = false) int producto) {
        var productos = productoService.getProducto();
        for (var listaProducto : productos) {
            if (listaProducto.getProductoId() == producto) {
                carrito.add(listaProducto);
            }
        }
        return "redirect:/Carrito";
    }

    @PostMapping("/Pagar")
    public String PagarCarrito() {
        carrito.clear();
        listaCarrito.clear();
        iva = 0;
        total = 0;
        cantidad = 0;
        subTotal=0;
         return "redirect:/Carrito";
    }
    
    @PostMapping("/LimpiarCarrito")
    public String LimpiarCarrito() {
        carrito.clear();
        listaCarrito.clear();
        iva = 0;
        total = 0;
        cantidad = 0;
        subTotal=0;
         return "redirect:/Carrito";
    }
    
}
