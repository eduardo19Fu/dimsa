import { Estado } from '../estado';
import { Usuario } from '../usuarios/usuario';

export class Correlativo {

    idCorrelativo: number;
    correlativoInicial: number;
    correlativoFinal: number;
    correlativoActual: number;
    serie: string;
    fechaCreacion: Date;

    estado: Estado;
    usuario: Usuario;

}
