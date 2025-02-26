package LR.inventarios.servicio;

import LR.inventarios.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    public List<Producto> listarProdutos();
    public Producto buscarProductoPorId(Integer idProducto);
    public Producto guardarProducto(Producto producto);
    public void eliminarProductoPorId(Integer idProducto);
}
