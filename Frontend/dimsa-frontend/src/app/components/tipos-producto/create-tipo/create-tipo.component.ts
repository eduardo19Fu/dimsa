import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { TipoProducto } from 'src/app/models/productos/tipo-producto';
import { TipoProductoService } from 'src/app/services/tipo-producto.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-create-tipo',
  templateUrl: './create-tipo.component.html',
  styles: [
  ]
})
export class CreateTipoComponent implements OnInit {

  title: string;
  tipoProducto: TipoProducto;

  constructor(
    private tipoService: TipoProductoService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.title = 'Registrar Tipo de Producto';
    this.tipoProducto = new TipoProducto();
  }

  ngOnInit(): void {
    this.cargarTipoProducto();
  }

  cargarTipoProducto(): void{
    this.activatedRoute.params.subscribe(params => {
      const id = params.id;
      if (id){
        this.tipoService.getTipoProducto(id).subscribe(
          tipoProducto => this.tipoProducto = tipoProducto
        );
      }
    });
  }

  create(): void{
    this.tipoService.create(this.tipoProducto).subscribe(
      response => {
        this.router.navigate(['/productos/tipos/index']);
        swal.fire('Tipo Creado', `${response.mensaje}: ${response.tipoProducto.tipoProducto}`, 'success');
      }
    );
    /*this.usuarioService.getUsuario(this.authService.usuario.idUsuario).subscribe(
      usuario => {
        this.tipoProducto.usuario = usuario;

        this.tipoService.create(this.tipoProducto).subscribe(
          response => {
            this.router.navigate(['/productos/categorias/index']);
            swal.fire('Tipo Creado', `${response.mensaje}: ${response.tipoProducto.tipoProducto}`, 'success');
          }
        );
      }
    );*/
  }

  update(): void{
    this.tipoService.update(this.tipoProducto).subscribe(
      response => {
        this.router.navigate(['/productos/tipos/index']);
        swal.fire('Tipo Actualizado', `${response.mensaje}: ${response.tipoProducto.tipoProducto}`, 'success');
      }
    );
  }

}
