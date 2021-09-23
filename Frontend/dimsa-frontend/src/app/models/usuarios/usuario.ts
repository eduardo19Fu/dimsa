import { Estado } from '../estado';

export class Usuario {

    idUsuario: number;
    usuario: string;
    password: string;
    primerNombre: string;
    segundoNombre: string;
    apellido: string;
    fechaRegistro: Date;

    estado: Estado;
}
