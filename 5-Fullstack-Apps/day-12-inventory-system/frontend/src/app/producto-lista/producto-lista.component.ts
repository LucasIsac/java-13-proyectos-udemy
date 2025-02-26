import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  standalone: false,
  templateUrl: './producto-lista.component.html',
})
export class ProductoListaComponent {
  productos: Producto[];

  constructor(
    private productoServicio: ProductoService,
    private enrutador: Router
  ) {}

  ngOnInit() {
    //Cargamos los productos
    this.obtenerProductos();
  }

  obtenerProductos() {
    //Consumimos los datos del observable
    this.productoServicio.obtenerProductoLista().subscribe((datos) => {
      this.productos = datos;
    });
  }

  editarProducto(id: number) {
    this.enrutador.navigate(['editar-producto', id]);
  }

  eliminarProducto(id: number) {
    this.productoServicio.eliminarProducto(id).subscribe({
      next: (datos) => this.obtenerProductos(),
      error: (errores) => console.error(errores),
    });
  }
}
