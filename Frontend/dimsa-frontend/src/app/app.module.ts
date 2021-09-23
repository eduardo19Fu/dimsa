import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientesComponent } from './components/clientes/clientes.component';
import { ProductosComponent } from './components/productos/productos.component';
import { HeaderComponent } from './components/header/header.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { CreateProductoComponent } from './components/productos/create-producto/create-producto.component';
import { MarcasProductoComponent } from './components/marcas-producto/marcas-producto.component';
import { CreateMarcaComponent } from './components/marcas-producto/create-marca/create-marca.component';
import { TiposProductoComponent } from './components/tipos-producto/tipos-producto.component';
import { CreateTipoComponent } from './components/tipos-producto/create-tipo/create-tipo.component';
import { CreateClienteComponent } from './components/clientes/create-cliente/create-cliente.component';
import { ModalCreateClienteComponent } from './components/clientes/modal-create-cliente/modal-create-cliente.component';
import { DetailProductoComponent } from './components/productos/detail-producto/detail-producto.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientesComponent,
    ProductosComponent,
    HeaderComponent,
    SidebarComponent,
    FooterComponent,
    HomeComponent,
    CreateProductoComponent,
    MarcasProductoComponent,
    CreateMarcaComponent,
    TiposProductoComponent,
    CreateTipoComponent,
    CreateClienteComponent,
    ModalCreateClienteComponent,
    DetailProductoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
