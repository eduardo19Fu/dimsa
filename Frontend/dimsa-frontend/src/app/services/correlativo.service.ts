import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

import { Correlativo } from '../models/correlativos/correlativo';

import { global } from './global';
import swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class CorrelativoService {

  url: string;
  httpHeaders = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(
    private http: HttpClient
  ) {
    this.url = global.url;
  }

  getCorrelativos(): Observable<Correlativo[]>{
    return this.http.get<Correlativo[]>(`${this.url}/correlativos`);
  }

  getCorrelativosPage(page: number): Observable<any>{
    return this.http.get<any>(`${this.url}/correlativos/page/${page}`).pipe(
      map((response: any) => {
        (response.content as Correlativo[]).map(correlativo => {
          return correlativo;
        });
        return response;
      })
    );
  }

  getCorrelativo(id: number): Observable<Correlativo>{
    return this.http.get<Correlativo>(`${this.url}/correlativos/${id}`).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  getCorrelativoPorUsuario(idusuario: number): Observable<Correlativo>{
    return this.http.get<Correlativo>(`${this.url}/correlativos/usuario/${idusuario}`).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  create(correlativo: Correlativo): Observable<any>{
    return this.http.post<any>(`${this.url}/correlativos`, correlativo).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  update(correlativo: Correlativo): Observable<any>{
    return this.http.put<any>(`${this.url}/correlativos`, correlativo).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  delete(id: number): Observable<any>{
    return this.http.delete<any>(`${this.url}/correlativos/${id}`).pipe(
      catchError(e => {
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }
}
