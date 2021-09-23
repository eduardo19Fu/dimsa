import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { ProductosComponent } from './components/productos/productos.component';
import { CreateProductoComponent } from './components/productos/create-producto/create-producto.component';
import { MarcasProductoComponent } from './components/marcas-producto/marcas-producto.component';
import { CreateMarcaComponent } from './components/marcas-producto/create-marca/create-marca.component';
import { TiposProductoComponent } from './components/tipos-producto/tipos-producto.component';
import { CreateTipoComponent } from './components/tipos-producto/create-tipo/create-tipo.component';
import { ClientesComponent } from './components/clientes/clientes.component';
import { CreateClienteComponent } from './components/clientes/create-cliente/create-cliente.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },

  /****** MENUS DE PRODUCTOS ******/
  { path: 'productos/index', component: ProductosComponent },
  { path: 'productos/create', component: CreateProductoComponent },
  { path: 'productos/create/:id', component: CreateProductoComponent },

  { path: 'productos/marcas/index', component: MarcasProductoComponent },
  { path: 'productos/marcas/create', component: CreateMarcaComponent },
  { path: 'productos/marcas/create/:id', component: CreateMarcaComponent },

  { path: 'productos/tipos/index', component: TiposProductoComponent },
  { path: 'productos/tipos/create', component: CreateTipoComponent },
  { path: 'productos/tipos/create/:id', component: CreateTipoComponent },

  /****** MENUS DE CLIENTES ******/
  { path: 'clientes/index', component: ClientesComponent },
  { path: 'clientes/create', component: CreateClienteComponent },
  { path: 'clientes/create/:id', component: CreateClienteComponent },

  { path: '**', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
