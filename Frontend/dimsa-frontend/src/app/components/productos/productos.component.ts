import { Component, OnInit } from '@angular/core';

import { Producto } from 'src/app/models/productos/producto';
import { JqueryConfigs } from 'src/app/utils/jquery-utils';
import { ProductoService } from '../../services/producto.service';

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
    private productoService: ProductoService
  ) {
    this.title = 'Listado de Productos';
    this.jQueryConfigs = new JqueryConfigs();
  }

  ngOnInit(): void {
    this.getProductos();
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

}
