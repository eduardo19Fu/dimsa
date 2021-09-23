import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

import { TipoProducto } from '../models/productos/tipo-producto';
import { global } from './global';
import swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class TipoProductoService {

  url: string;
  httpHeaders = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(
    private http: HttpClient,
    private router: Router
  ) {
    this.url = global.url;
  }

  getTiposProducto(): Observable<TipoProducto[]> {
    return this.http.get<TipoProducto[]>(`${this.url}/tipos-producto`).pipe(
      map((response: any) => {
        (response as TipoProducto[]).map(tipo => {
          tipo.tipoProducto = tipo.tipoProducto.toUpperCase();
          return tipo;
        });
        return response;
      })
    );
  }

  getTiposPaginados(page: number): Observable<TipoProducto[]> {
    return this.http.get(`${this.url}/tipos-producto/page/${page}`).pipe(
      map((response: any) => {
        (response.content as TipoProducto[]).map(tipo => {
          tipo.tipoProducto = tipo.tipoProducto.toUpperCase();
          return tipo;
        });
        return response;
      })
    );
  }

  getTipoProducto(id: number): Observable<TipoProducto> {
    return this.http.get<TipoProducto>(`${this.url}/tipos-producto/${id}`).pipe(
      catchError(e => {
        swal.fire('Error al consultar el tipo deseado', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  create(tipoProducto: TipoProducto): Observable<any> {
    return this.http.post<any>(`${this.url}/tipos-producto`, tipoProducto).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  update(tipoProducto: TipoProducto): Observable<any> {
    return this.http.put<any>(`${this.url}/tipos-producto`, tipoProducto).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  delete(id: number): Observable<TipoProducto> {
    return this.http.delete<TipoProducto>(`${this.url}/tipos-producto/${id}`).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }
}
