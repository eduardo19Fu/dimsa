import { Component, OnInit } from '@angular/core';

import { CorrelativoService } from '../../services/correlativo.service';
import { Correlativo } from '../../models/correlativos/correlativo';

import { JqueryConfigs } from '../../utils/jquery-utils';

import swal from 'sweetalert2';

@Component({
  selector: 'app-correlativos',
  templateUrl: './correlativos.component.html',
  styles: [
  ]
})
export class CorrelativosComponent implements OnInit {

  title: string;
  jQueryConfigs: JqueryConfigs;

  correlativos: Correlativo[];

  swalWithBootstrapButtons = swal.mixin({
    customClass: {
      confirmButton: 'btn btn-success',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: true
  });

  constructor(
    private correlativoService: CorrelativoService
  ) {
    this.title = 'Listado de Correlativos';
    this.jQueryConfigs = new JqueryConfigs();
  }

  ngOnInit(): void {
    this.getCorrelativos();
  }

  getCorrelativos(): void{
    this.correlativoService.getCorrelativos().subscribe(
      correlativos => {
        this.correlativos = correlativos;
        this.jQueryConfigs.configDataTable('correlativos');
      }
    );
  }

  anularCorrelativo(correlativo: Correlativo): void{
    this.swalWithBootstrapButtons.fire({
      title: '¿Está seguro?',
      text: `¿Seguro que desea anular el correlativo ${correlativo.idCorrelativo} del cajero ${correlativo.usuario.usuario}`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: '¡Si, anular!',
      cancelButtonText: '¡No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {

        // aqui va el codigo de confirmación para anular factura
        this.correlativoService.delete(correlativo.idCorrelativo).subscribe(response => {
          this.swalWithBootstrapButtons.fire(
            `${response.mensaje}`,
            `El correlativo No. ${response.correlativo.idCorrelativo} ha sido anulado con éxito`,
            'success'
          );
        });

      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === swal.DismissReason.cancel
      ) {
        this.swalWithBootstrapButtons.fire(
          'Proceso Cancelado',
          `El correlativo No. ${correlativo.idCorrelativo} no ha sido anulado`,
          'error'
        );
      }
    });
  }

}
