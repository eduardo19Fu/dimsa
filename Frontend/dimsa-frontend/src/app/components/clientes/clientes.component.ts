import { Component, OnInit } from '@angular/core';

import { Cliente } from '../../models/clientes/cliente';
import { ClienteService } from '../../services/cliente.service';
import { JqueryConfigs } from 'src/app/utils/jquery-utils';

import swal from 'sweetalert2';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styles: [
  ]
})
export class ClientesComponent implements OnInit {

  title: string;
  clientes: Cliente[];

  jQueryConfigs: JqueryConfigs;

  swalWithBootstrapButtons = swal.mixin({
    customClass: {
      confirmButton: 'btn btn-success',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: true
  });

  constructor(
    private clienteService: ClienteService
  ) {
    this.title = 'Listado de clientes';
    this.jQueryConfigs = new JqueryConfigs();
  }

  ngOnInit(): void {
    this.getClientes();
  }

  getClientes(): void {
    this.clienteService.getClientes().subscribe(
      clientes => {
        this.clientes = clientes;
        this.jQueryConfigs.configDataTable('clientes');
      },
      error => { }
    );
  }

  delete(cliente: Cliente): void {
    this.swalWithBootstrapButtons.fire({
      title: '¿Está seguro?',
      text: `¿Seguro que desea eliminar al cliente ${cliente.nombre}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: '¡Si, eliminar!',
      cancelButtonText: '¡No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {

        this.clienteService.delete(cliente.idCliente).subscribe(
          response => {
            this.clientes = this.clientes.filter(cli => cli !== cliente);
            this.swalWithBootstrapButtons.fire(
              '¡Cliente Eliminado!',
              'El cliente ha sido eliminado con éxito!',
              'success'
            );
          }
        );
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === swal.DismissReason.cancel
      ) {
        this.swalWithBootstrapButtons.fire(
          'Proceso Cancelado',
          'El cliente no fúe eliminado de la base de datos.',
          'error'
        );
      }
    });
  }

}
