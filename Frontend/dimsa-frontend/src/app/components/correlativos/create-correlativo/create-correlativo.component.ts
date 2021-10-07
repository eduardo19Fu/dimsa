import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Correlativo } from '../../../models/correlativos/correlativo';
import { Usuario } from '../../../models/usuarios/usuario';
import { CorrelativoService } from '../../../services/correlativo.service';
import { UsuarioService } from '../../../services/usuario.service';
import swal from 'sweetalert2';


@Component({
  selector: 'app-create-correlativo',
  templateUrl: './create-correlativo.component.html',
  styles: [
  ]
})
export class CreateCorrelativoComponent implements OnInit {

  title: string;

  correlativo: Correlativo;
  usuarios: Usuario[];

  constructor(
    private correlativoService: CorrelativoService,
    private usuarioService: UsuarioService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.title = 'Crear Correlativo Nuevo';
    this.correlativo = new Correlativo();
  }

  ngOnInit(): void {
    this.cargarCorrelativo();
    this.cargarCajeros();
  }

  cargarCorrelativo(): void{
    this.activatedRoute.params.subscribe(
      params => {
        // tslint:disable-next-line: no-string-literal
        const id = params['id'];
        if (id){
          this.correlativoService.getCorrelativo(id).subscribe(
            correlativo => this.correlativo = correlativo
          );
        }
      }
    );
  }

  create(): void{
    this.correlativoService.create(this.correlativo).subscribe(
      response => {
        this.router.navigate(['/correlativos']);
        swal.fire('Correlativo Creado', `${response.mensaje}`, 'success');
      }
    );
  }

  update(): void{
    this.correlativoService.update(this.correlativo).subscribe(
      response => {
        this.router.navigate(['/correlativos']);
        swal.fire('Correlativo Actualizado', `${response.mensaje}: ${response.correlativo.idCorrelativo}`, 'success');
      }
    );
  }

  cargarCajeros(): void{
    // this.usuarioService.getCajeros().subscribe(usuarios => this.usuarios = usuarios);
  }

}
