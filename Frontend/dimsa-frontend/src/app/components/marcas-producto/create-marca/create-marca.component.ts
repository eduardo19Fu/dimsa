import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MarcaProducto } from 'src/app/models/productos/marca-producto';
import { MarcaProductoService } from 'src/app/services/marca-producto.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-create-marca',
  templateUrl: './create-marca.component.html',
  styles: [
  ]
})
export class CreateMarcaComponent implements OnInit {

  title: string;
  marcaProducto: MarcaProducto;

  constructor(
    private marcaService: MarcaProductoService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) {
    this.title = 'Registrar nueva marca';
    this.marcaProducto = new MarcaProducto();
  }

  ngOnInit(): void {
    this.cargarMarca();
  }

  cargarMarca(): void{
    this.activatedRoute.params.subscribe(params => {
      const id = params.id;
      if (id){
        this.marcaService.getMarca(id).subscribe(
          marca => this.marcaProducto = marca
        );
      }
    });
  }

  create(): void {

    this.marcaService.create(this.marcaProducto).subscribe(
      response => {
        this.router.navigate(['/productos/marcas/index']);
        swal.fire('Marca Guardada', `${response.mensaje}: ${response.marca.marca}`, 'success');
      }
    );
    /*this.usuarioService.getUsuario(this.authService.usuario.idUsuario).subscribe(
      usuario => {

        this.marcaProducto.usuario = usuario;

        this.marcaService.create(this.marcaProducto).subscribe(
          response => {
            this.router.navigate(['/productos/marcas/index']);
            swal.fire('Marca Guardada', `${response.mensaje}: ${response.marca.marca}`, 'success');
          }
        );
      }
    );*/
  }

  update(): void{
    this.marcaService.update(this.marcaProducto).subscribe(
      response => {
        this.router.navigate(['/productos/marcas/index']);
        swal.fire('Marca Actualizada', `${response.mensaje}: ${response.marca.marca} fué actualizada con éxito!`, 'success');
      }
    );
  }

}
