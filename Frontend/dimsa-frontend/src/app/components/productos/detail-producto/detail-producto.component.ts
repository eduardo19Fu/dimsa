import { HttpEventType } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';

import { Producto } from 'src/app/models/productos/producto';
import { ModalProductoService } from 'src/app/services/modal-producto.service';
import { ProductoService } from 'src/app/services/producto.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-detail-producto',
  templateUrl: './detail-producto.component.html',
  styleUrls: ['./detail-producto.component.css']
})
export class DetailProductoComponent implements OnInit {

  title: string;

  @Input() producto: Producto;

  imagenSeleccionada: File;
  progreso: number;

  constructor(
    public modalProductoService: ModalProductoService,
    private serviceProducto: ProductoService
  ) {
    this.title = 'Detalle del Producto';
    this.progreso = 0;
  }

  ngOnInit(): void {
  }

  seleccionarImagen(event): void {
    this.imagenSeleccionada = event.target.files[0];
    this.progreso = 0;

    if (this.imagenSeleccionada.type.indexOf('image') < 0) {
      swal.fire('Error: seleccionar imagen', 'El archivo debe de ser de tipo imagen', 'error');
      this.imagenSeleccionada = null;
    }
  }

  subirImagen(): void {

    if (!this.imagenSeleccionada) {
      swal.fire('Error: debe seleccionar una foto.', 'Debe seleccionar una foto', 'error');
    } else {
      // tslint:disable-next-line: deprecation
      this.serviceProducto.uploadImage(this.imagenSeleccionada, this.producto.idProducto).subscribe(
        event => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progreso = Math.round((event.loaded / event.total) * 100);
          } else if (event.type === HttpEventType.Response){
            // tslint:disable-next-line: prefer-const
            let response: any = event.body;

            this.producto = response.producto as Producto;

            this.modalProductoService.notificarUpload.emit(this.producto);
            swal.fire('Imagen ha sido subida con éxito', response.mensaje, 'success');
          }
        }
      );
    }
  }

  cerrarModal(): void{
    this.modalProductoService.cerrarModal();
    this.imagenSeleccionada = null;
    this.progreso = 0;
  }

}
