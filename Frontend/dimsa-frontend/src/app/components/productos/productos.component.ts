import { Component, OnInit } from '@angular/core';

import { Producto } from 'src/app/models/productos/producto';
import { JqueryConfigs } from 'src/app/utils/jquery-utils';
import { ProductoService } from '../../services/producto.service';
import { ModalProductoService } from '../../services/modal-producto.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styles: [
  ]
})
export class ProductosComponent implements OnInit {

  title: string;
  productos: Producto[];

  productoSeleccionado: Producto;

  paginador: any;

  jQueryConfigs: JqueryConfigs;

  constructor(
    private productoService: ProductoService,
    private modalProductoService: ModalProductoService
  ) {
    this.title = 'Listado de Productos';
    this.jQueryConfigs = new JqueryConfigs();
  }

  ngOnInit(): void {
    this.getProductos();
    this.modalProductoService.notificarUpload.subscribe(producto => {
      this.productos = this.productos.map(productoOriginal => {
        if (producto.idProducto === productoOriginal.idProducto){
          productoOriginal.imagen = producto.imagen;
        }
        return productoOriginal;
      });
    });
  }

  getProductos(): void{
    this.productoService.getProductos().subscribe(
      productos => {
        this.productos = productos;
        this.jQueryConfigs.configDataTable('productos');
        this.jQueryConfigs.configToolTip();
      },
      error => { }
    );
  }

  abrirModal(producto: Producto): void{
    this.productoSeleccionado = producto;
    this.modalProductoService.abrirModal();
  }

}
