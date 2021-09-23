import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError, map } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';

import { MarcaProducto } from '../models/productos/marca-producto';
import { global } from './global';
import swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class MarcaProductoService {

  url: string;
  httpHeaders = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(
    private http: HttpClient,
    private router: Router
  ) {
    this.url = global.url;
  }

  getMarcas(): Observable<MarcaProducto[]> {
    // return of(MARCAS);
    return this.http.get<MarcaProducto[]>(`${this.url}/marcas`).pipe(
      map(response => {
        const marcas = response as MarcaProducto[];
        return marcas.map(marca => {
          marca.marca = marca.marca.toUpperCase();
          // const datePipe = new DatePipe('en-US');
          // marca.fechaRegistro = datePipe.transform(marca.fechaRegistro, 'dd-MM-yyyy');
          // formatDate(marca.fechaRegistro, 'dd-MM-yyyy', 'en-US');
          return marca;
        });
      })
    );
  }

  getMarcasPage(page: number): Observable<any> {
    return this.http.get(`${this.url}/marcas/page/${page}`).pipe(
      map((response: any) => {
        (response.content as MarcaProducto[]).map(marca => {
          marca.marca = marca.marca.toUpperCase();
          return marca;
        });
        return response;
      })
    );
  }

  getMarca(id: number): Observable<MarcaProducto> {
    return this.http.get<MarcaProducto>(`${this.url}/marcas/${id}`).pipe(
      catchError(e => {
        swal.fire('Error al consultar la marca', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  create(marcaProducto: MarcaProducto): Observable<any> {
    return this.http.post<any>(`${this.url}/marcas`, marcaProducto).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  update(marcaProducto: MarcaProducto): Observable<any> {
    return this.http.put<any>(`${this.url}/marcas`, marcaProducto).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  delete(id: number): Observable<MarcaProducto> {
    return this.http.delete<MarcaProducto>(`${this.url}/marcas/${id}`).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }
}
