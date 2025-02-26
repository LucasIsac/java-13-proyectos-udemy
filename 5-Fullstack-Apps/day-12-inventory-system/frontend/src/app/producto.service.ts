import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from './producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private urlBase="http://localhost:8080/inventario-app/productos"

  constructor(private ClienteHttp: HttpClient) { }

  obtenerProductoLista(): Observable<Producto[]>{
    return this.ClienteHttp.get<Producto[]>(this.urlBase);
  }

  agregarProducto(producto: Producto): Observable<Object>{
    return this.ClienteHttp.post(this.urlBase, producto);
  }

  obtenerProductoId(id: number){
    return this.ClienteHttp.get<Producto>(`${this.urlBase}/${id}`);
  }

  editarProducto(id: number, producto: Producto): Observable<Object>{
    return this.ClienteHttp.put(`${this.urlBase}/${id}`, producto);
  }

  eliminarProducto(id: number): Observable<Object>{
    return this.ClienteHttp.delete(`${this.urlBase}/${id}`);
  }
}
