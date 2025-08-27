export class ConsultaDTO {

  constructor(data:Partial<ConsultaDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  timestamp?: string|null;
  token?: string|null;
  origen?: string|null;
  mensaje?: string|null;
  respuesta?: string|null;

}
